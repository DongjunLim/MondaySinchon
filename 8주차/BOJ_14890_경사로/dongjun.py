"""
    무식하게 짜서 리팩토링 할 예정입니다.
"""

import sys
sys.stdin = open("input.txt", "r")


def setup_horizontal_down_hill_ramp(row, col, L, N, board):
    global ramps
    if N <= col + L:
        return False

    next = board[row][col + 1]
    for c in range(col+1, col+L+1):
        if board[row][c] is not next or ramps[row][c]:
            return False

    for c in range(col+1, col+L+1):
        ramps[row][c] = True
    return True


def setup_horizontal_up_hill_ramp(row, col, L, N, board):
    global ramps
    if col - L + 1< 0:
        return False

    now = board[row][col]
    for c in range(col, col-L, -1):
        if board[row][c] is not now or ramps[row][c]:
            return False

    for c in range(col, col-L, -1):
        ramps[row][c] = True
    return True


def setup_vertical_down_hill_ramp(row, col, L, N, board):
    global ramps
    if N <= row + L:
        return False

    next = board[row + 1][col]
    for r in range(row+1, row+L+1):
        if board[r][col] is not next or ramps[r][col]:
            return False

    for r in range(row+1, row+L+1):
        ramps[r][col] = True
    return True


def setup_vertical_up_hill_ramp(row, col, L, N, board):
    global ramps
    if row - L + 1 < 0:
        return False

    now = board[row][col]
    for r in range(row, row-L, -1):
        if board[r][col] is not now or ramps[r][col]:
            return False

    for r in range(row, row-L, -1):
        ramps[r][col] = True
    return True



def solution(N, L, board):
    global ramps
    answer = 0

    for row in range(N):
        is_possible = 1
        col = 0
        while col < N-1:
            nextValue = board[row][col + 1]
            if nextValue is board[row][col]:
                col += 1
                continue

            elif nextValue is board[row][col] + 1:
                if not setup_horizontal_up_hill_ramp(row, col, L, N, board):
                    is_possible = 0
                    break
                col += 1

            elif nextValue is board[row][col] - 1:
                if not setup_horizontal_down_hill_ramp(row, col, L, N, board):
                    is_possible = 0
                    break
                col += L
            else:
                is_possible = 0
                break

        answer += is_possible

    ramps = [[False] * 101 for _ in range(101)]

    for col in range(N):
        is_possible = 1
        row = 0
        while row < N-1:
            nextValue = board[row + 1][col]
            if nextValue is board[row][col]:
                row += 1
                continue

            elif nextValue is board[row][col] + 1:
                if not setup_vertical_up_hill_ramp(row, col, L, N, board):
                    is_possible = 0
                    break
                row += 1

            elif nextValue is board[row][col] - 1:
                if not setup_vertical_down_hill_ramp(row, col, L, N, board):
                    is_possible = 0
                    break
                row += L
            else:
                is_possible = 0
                break

        answer += is_possible

    return answer


def main():
    N, L = map(int, input().split())
    board = [list(map(int, input().split())) for _ in range(N)]

    print(solution(N, L, board))


ramps = [[False] * 101 for _ in range(101)]

if __name__ == '__main__':
    main()

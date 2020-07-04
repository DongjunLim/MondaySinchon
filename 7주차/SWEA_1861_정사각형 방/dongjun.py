""" 
    완전 탐색을 사용해 풀었습니다.
    배열의 모든 x, y 좌표에서 얼만큼 이동이 가능한지 재귀적으로 탐색해서 구하고,
    구한 값 중 가장 작은 값과 좌표를 출력합니다.
"""

import sys
sys.stdin = open("input.txt", "r")


def next_point(row, col, board):
    """ 현재 좌표에서 이동 가능한 경로가 있는지 확인하고, 경로가 존재하면 경로의 좌표값을 반환한다. """
    now = board[row][col]
    length = len(board)-1

    if row is not 0 and board[row-1][col] == now + 1:
        return row-1, col

    if row is not length and board[row+1][col] == now + 1:
        return row+1, col

    if col is not 0 and board[row][col-1] == now + 1:
        return row, col-1

    if col is not length and board[row][col+1] == now + 1:
        return row, col+1

    return -1, -1


def brute_force(row, col, board, move_cnt):
    """ 현재 좌표에서 이동이 불가능할 때까지 재귀적으로 탐색한다. """
    next_row, next_col = next_point(row, col, board)

    if next_row == -1:
        return move_cnt

    return brute_force(next_row, next_col, board, move_cnt + 1)


def solution(N, board):
    """ 2중 for 문을 순회하며 각각의 좌표값에서의 이동횟수를 모두 구하고, 가장 작은 값과 좌표를 반환한다. """
    answer = 1
    number = 1
    
    for i in range(N):
        for j in range(N):
            move_cnt = brute_force(i, j, board, 1)
            
            if answer < move_cnt:
                answer = move_cnt
                number = board[i][j]
            elif answer == move_cnt:
                number = min(number, board[i][j])
                
    return number, answer


def main():
    T = int(input())

    for tc in range(1, T+1):
        N = int(input())
        board = [list(map(int, input().split())) for _ in range(N)]

        number, answer = solution(N, board)

        print(f'#{tc} {number} {answer}')


if __name__ == "__main__":
    main()

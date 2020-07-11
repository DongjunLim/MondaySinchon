import sys
sys.stdin = open("input.txt", "r")


def check_out_of_range(row, col, N, M):
    """ 맵 범위를 벗어났는지 확인. """
    if 0 > row or row >= N or 0 > col or col >= M:
        return True
    
    return False


def cleaning(row, col):
    """ board[row][col] 좌표를 청소표시하고 청소횟수를 카운트. """
    global isClean, answer

    isClean[row][col] = True
    answer += 1

    return


def is_cleaning_possible(N, M, row, col, board):
    """ board[row][col]을 청소할 수 있는지 확인. """
    global isClean

    if check_out_of_range(row, col, N, M):
        return False

    if board[row][col] == 1:
        return False

    if isClean[row][col]:
        return False

    return True


def is_reverse_possible(N, M, row, col, board):
    """ 후진할 수 있는지 확인. """
    if check_out_of_range(row, col, N, M):
        return False

    if board[row][col] == 1:
        return False

    return True


def solution(N, M, row, col, d, board):
    """ 정해진 규칙대로 청소를 한다. """
    global isClean, answer
    dt = [(-1, 0), (0, 1), (1, 0), (0, -1)]

    # 1. 현재 위치 청소
    while True:
        cleaning(row, col)
        rCnt = 0
        reverse_row, reverse_col = dt[(d + 2) % 4]
        
        # 2. 주변 탐색
        while True:
            rCnt += 1
            d = (d - 1) % 4
            next_row, next_col = dt[d]
            
            # 2-1. 현재 방향 왼쪽방향에 청소를 할 수 있는가? 청소할 수 있다면 이동
            if is_cleaning_possible(N, M, row + next_row, col + next_col, board):
                row, col = row + next_row, col + next_col
                break

            # 2-2. 4방향을 확인하지 않았을 경우 방향만 전환
            elif rCnt < 4:
                continue

            # 2-3. 4방향을 모두 확인했을 경우, 후진이 가능한지 확인, 후진이 가능하면 후진
            elif is_reverse_possible(N, M, row + reverse_row, col + reverse_col, board):
                row, col = row + reverse_row, col + reverse_col
                rCnt = 0
                continue
            
            # 2-4. 후진이 가능하지 않으면 청소 종료
            else:
                return 0


def main():
    N, M = map(int, input().split())
    r, c, d = map(int, input().split())

    board = [list(map(int, input().split())) for _ in range(N)]

    solution(N, M, r, c, d, board)
    
    print(answer)


isClean = [[False] * 51 for _ in range(51)]
answer = 0


if __name__ == '__main__':
    main()

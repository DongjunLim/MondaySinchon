"""
    모든 칸의 숫자를 표시하는 최소 클릭 횟수 = 독립적으로 연쇄표시가 가능한 칸 + 연쇄표시가 다 끝나고 남은 칸의 갯수
    문제해결 로직은 다음과 같습니다.
    1. 2차원 리스트 board를 순회하며 주변에 지뢰가 없는 칸을 찾습니다.
    2. 주변에 지뢰가 없는 칸을 찾았으면, 주변을 탐색하며 연쇄적으로 주변칸의 지뢰를 찾고, 숫자를 표시합니다.
    3. 2번을 마치면 클릭 카운트를 1 증가시키고 다시 1번으로 돌아가 주변에 지뢰가 없는 칸을 찾습니다.
    4. 주변에 지뢰가 없는 칸을 모두 찾아서 연쇄 표시를 마쳤으면, 아직 숫자가 표시되지 않은 칸의 갯수를 세어 클릭 카운트에 더합니다.
"""


import sys
from collections import deque

sys.stdin = open("input.txt", "r")

visited = []
dt = [(-1, -1), (-1, 0), (-1, 1), (0, -1), (0, 1), (1, -1), (1, 0), (1, 1)]
board = []
n = 0


def check_out_of_range(row, col):
    """ 맵 범위를 벗어났는지 확인합니다. """
    global n
    if 0 > row or row >= n or 0 > col or col >= n:
        return True

    return False


def check_mine(row, col):
    """ board[row][col]을 기준으로 이웃한 8군데에 지뢰가 있는지 확인합니다. """
    global dt, n, board

    mine_cnt = 0

    for x, y in dt:
        if check_out_of_range(row + x, col + y):
            continue

        if board[row + x][col + y] == '*':
            mine_cnt += 1

    return mine_cnt  # 이웃한 지뢰의 갯수를 반환합니다.


def click_all_zero_area(n):
    """ board에서 주변에 지뢰가 없는 칸을 모두 카운팅 합니다. 이때 카운팅하는 칸은 연결되지 않은 경우에 한합니다."""
    global board
    clickCnt = 0

    for i in range(n):
        for j in range(n):
            clickCnt += click_zero_area(i, j)

    return clickCnt


def click_zero_area(row, col):
    """ 현재 칸 board[row][col] 주변에 지뢰가 있는지 확인하고 지뢰가 없으면 연쇄적으로 주변 칸도 확인합니다. """
    global board

    if board[row][col] == '.' and check_mine(row, col) == 0:
        bfs(row, col)
        return 1

    return 0


def bfs(row, col):
    """ 지뢰가 없을 경우 그 주변 칸을 확인하고 숫자를 표시하는 bfs 함수입니다. """
    global board, visited

    queue = deque()

    visited[row][col] = True
    board[row][col] = 0

    for x, y in dt:
        next_x, next_y = row + x, col + y
        if not check_out_of_range(next_x, next_y) and not visited[next_x][next_y]:
            if board[next_x][next_y] == '.':
                visited[next_x][next_y] = True
                queue.append((next_x, next_y))

    while queue:
        tx, ty = queue.popleft()
        board[tx][ty] = check_mine(tx, ty)
        if board[tx][ty] == 0:
            for x, y in dt:
                next_x, next_y = tx + x, ty + y

                if not check_out_of_range(next_x, next_y) and not visited[next_x][next_y]:
                    if board[next_x][next_y] == '.':
                        visited[next_x][next_y] = True
                        queue.append((next_x, next_y))


def click_non_zero_area(n):
    """ 주변에 지뢰가 있는 경우를 카운팅합니다. """
    global board
    clickCnt = 0

    for i in range(n):
        for j in range(n):
            if board[i][j] == '.':
                clickCnt += 1
    return clickCnt


def solution(n):
    global dt, visited, board
    visited = [[False] * n for _ in range(n)]
    cnt = 0

    cnt += click_all_zero_area(n)

    cnt += click_non_zero_area(n)

    return cnt


def main():
    global board, n
    T = int(input())

    for tc in range(1, T + 1):
        n = int(input())
        board = [list(str(input())) for _ in range(n)]
        print(f'#{tc} {solution(n)}')


if __name__ == "__main__":
    main()

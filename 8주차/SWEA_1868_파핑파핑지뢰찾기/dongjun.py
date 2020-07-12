"""
    ��� ĭ�� ���ڸ� ǥ���ϴ� �ּ� Ŭ�� Ƚ�� = ���������� ����ǥ�ð� ������ ĭ + ����ǥ�ð� �� ������ ���� ĭ�� ����
    �����ذ� ������ ������ �����ϴ�.
    1. 2���� ����Ʈ board�� ��ȸ�ϸ� �ֺ��� ���ڰ� ���� ĭ�� ã���ϴ�.
    2. �ֺ��� ���ڰ� ���� ĭ�� ã������, �ֺ��� Ž���ϸ� ���������� �ֺ�ĭ�� ���ڸ� ã��, ���ڸ� ǥ���մϴ�.
    3. 2���� ��ġ�� Ŭ�� ī��Ʈ�� 1 ������Ű�� �ٽ� 1������ ���ư� �ֺ��� ���ڰ� ���� ĭ�� ã���ϴ�.
    4. �ֺ��� ���ڰ� ���� ĭ�� ��� ã�Ƽ� ���� ǥ�ø� ��������, ���� ���ڰ� ǥ�õ��� ���� ĭ�� ������ ���� Ŭ�� ī��Ʈ�� ���մϴ�.
"""


import sys
from collections import deque

sys.stdin = open("input.txt", "r")

visited = []
dt = [(-1, -1), (-1, 0), (-1, 1), (0, -1), (0, 1), (1, -1), (1, 0), (1, 1)]
board = []
n = 0


def check_out_of_range(row, col):
    """ �� ������ ������� Ȯ���մϴ�. """
    global n
    if 0 > row or row >= n or 0 > col or col >= n:
        return True

    return False


def check_mine(row, col):
    """ board[row][col]�� �������� �̿��� 8������ ���ڰ� �ִ��� Ȯ���մϴ�. """
    global dt, n, board

    mine_cnt = 0

    for x, y in dt:
        if check_out_of_range(row + x, col + y):
            continue

        if board[row + x][col + y] == '*':
            mine_cnt += 1

    return mine_cnt  # �̿��� ������ ������ ��ȯ�մϴ�.


def click_all_zero_area(n):
    """ board���� �ֺ��� ���ڰ� ���� ĭ�� ��� ī���� �մϴ�. �̶� ī�����ϴ� ĭ�� ������� ���� ��쿡 ���մϴ�."""
    global board
    clickCnt = 0

    for i in range(n):
        for j in range(n):
            clickCnt += click_zero_area(i, j)

    return clickCnt


def click_zero_area(row, col):
    """ ���� ĭ board[row][col] �ֺ��� ���ڰ� �ִ��� Ȯ���ϰ� ���ڰ� ������ ���������� �ֺ� ĭ�� Ȯ���մϴ�. """
    global board

    if board[row][col] == '.' and check_mine(row, col) == 0:
        bfs(row, col)
        return 1

    return 0


def bfs(row, col):
    """ ���ڰ� ���� ��� �� �ֺ� ĭ�� Ȯ���ϰ� ���ڸ� ǥ���ϴ� bfs �Լ��Դϴ�. """
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
    """ �ֺ��� ���ڰ� �ִ� ��츦 ī�����մϴ�. """
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

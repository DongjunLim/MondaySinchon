"""
    BFS + ��Ʈ����ŷ���� Ǯ�����ϴ�.
    3���� dist[row][col][key] �� �̷��� ��� ��, �׸��� Ű�� ������ �ε����� ǥ���߽��ϴ�.
    key�� ������ ���� ��Ʈ������ ����߽��ϴ�.
    https://rebas.kr/738 ����
"""

import sys
from collections import deque
sys.stdin = open("input.txt", "r")
N, M = 0, 0
dt = [[0, -1], [0, 1], [1, 0], [-1, 0]]


def check_out_of_range(row, col):
    ''' �迭 ������ ������� Ȯ�� '''
    if row < 0 or N <= row or col < 0 or M <= col:
        return False
    return True


def check_start(board):
    ''' �������� ���� '''
    global N, M
    for i in range(N):
        for j in range(M):
            if board[i][j] == '0':
                return i, j


def bfs(row, col, board):
    global N, M, dt
    dist = [[[0] * 64 for _ in range(M)] for _ in range(N)]

    queue = deque()
    queue.append([row, col, 0])
    while queue:
        r, c, k = queue.popleft()
        if board[r][c] == '1':
            return dist[r][c][k]

        for x, y in dt:
            nr, nc, nk = r + x, c + y, k

            if not check_out_of_range(nr, nc) or board[nr][nc] == '#':
                continue

            now = board[nr][nc]

            if now.islower():
                nk |= (1 << (ord(now) - ord('a')))
            elif now.isupper() and not nk & (1 << (ord(now) - ord('A'))):
                continue

            if not dist[nr][nc][nk]:
                queue.append([nr, nc, nk])
                dist[nr][nc][nk] = dist[r][c][k] + 1

    return -1


def solve(board):

    startRow, startCol = check_start(board)

    return bfs(startRow, startCol, board)


def main():
    global N, M
    N, M = map(int, input().split())

    board = [list(input()) for _ in range(N)]

    print(solve(board))


if __name__ == '__main__':
    main()

"""
    BFS + 비트마스킹으로 풀었씁니다.
    3차원 dist[row][col][key] 에 미로의 행과 열, 그리고 키의 정보를 인덱스로 표현했습니다.
    key의 정보는 각각 비트단위로 기록했습니다.
    https://rebas.kr/738 참고
"""

import sys
from collections import deque
sys.stdin = open("input.txt", "r")
N, M = 0, 0
dt = [[0, -1], [0, 1], [1, 0], [-1, 0]]


def check_out_of_range(row, col):
    ''' 배열 범위를 벗어났는지 확인 '''
    if row < 0 or N <= row or col < 0 or M <= col:
        return False
    return True


def check_start(board):
    ''' 시작지점 설정 '''
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

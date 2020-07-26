"""
    3차원 배열 bfs를 통해 풀었습니다.
"""


import sys
from collections import deque
sys.stdin = open("input.txt", "r")
L, R, C = 0, 0, 0
dt = [(0, 0, 1), (0, 0, -1), (0, 1, 0), (0, -1, 0), (1, 0, 0), (-1, 0, 0)]
start = [0, 0, 0, 0]


def check_out_of_range(l, r, c):
    """ 범위가 벗어났는지 확인 """
    global L, R, C
    if l < 0 or L <= l or r < 0 or R <= r or c < 0 or C <= c:
        return False

    return True


def is_wall(l, r, c, board):
    """ 벽인지 확인 """

    if board[l][r][c] == '#':
        return True
    return False


def bfs(board):
    global dt, L, R, C, start

    visited = [[[False] * C for _ in range(R)] for _ in range(L)]

    queue = deque()
    queue.append(start)
    visited[start[0]][start[1]][start[2]] = True

    while queue:
        l, r, c, cnt = queue.popleft()

        if board[l][r][c] == 'E':
            return cnt

        for x, y, z in dt:
            nl, nr, nc = l + x, r + y, c + z
            if check_out_of_range(nl, nr, nc) and not is_wall(nl, nr, nc, board) and not visited[nl][nr][nc]:
                visited[nl][nr][nc] = True
                queue.append([nl, nr, nc, cnt+1])

    return -1


def solve(board):
    global L, R, C

    result = bfs(board)

    if result == -1:
        return "Trapped!"

    else:
        return f'Escaped in {result} minute(s).'


def main():
    global L, R, C, start
    while True:
        L, R, C = map(int, input().split())

        if L == 0:
            return
        board = []
        for i in range(L):
            board.append([list(input()) for _ in range(R)])
            input()
        for i in range(L):
            for j in range(R):
                for k in range(C):
                    if board[i][j][k] == 'S':
                        start = [i, j, k, 0]
        print(solve(board))


if __name__ == '__main__':
    main()

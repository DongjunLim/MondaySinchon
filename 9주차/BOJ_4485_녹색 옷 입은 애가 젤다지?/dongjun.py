"""
    다익스트라 알고리즘을 사용해 풀었습니다.
    간선의 수가 정점당 4개밖에 안되기 때문에
    우선순위큐를 사용하여 구현했습니다.
"""


import sys
import heapq
sys.stdin = open("input.txt", "r")
INF = 999999999
dt = [(0, -1), (0, 1), (1, 0), (-1, 0)]


def check_out_of_range(row, col, n):
    """ 배열 인덱스 범위를 벗어났는지 확인 """
    if row < 0 or n <= row or col < 0 or n <= col:
        return False
    return True


def dijkstra(startRow, startCol, n, board):
    """ 다익스트라 최단경로 탐색 알고리즘 """
    global dt
    queue = []
    visited = [[False] * n for _ in range(n)]
    answer = [[INF] * n for _ in range(n)]

    heapq.heappush(queue, (board[startRow][startCol], startRow, startCol))
    answer[startRow][startCol] = board[startRow][startCol]

    while queue:
        val, row, col = heapq.heappop(queue)

        visited[row][col] = True

        if row == n-1 and col == n-1:
            return answer[-1][-1]

        for x, y in dt:
            nextRow, nextCol = row + x, col + y
            if check_out_of_range(nextRow, nextCol, n) and not visited[nextRow][nextCol]:
                if answer[nextRow][nextCol] > val+board[nextRow][nextCol]:
                    answer[nextRow][nextCol] = val+board[nextRow][nextCol]
                    heapq.heappush(queue, (answer[nextRow][nextCol], nextRow, nextCol))


def solution(n, board):
    global dt

    return dijkstra(0, 0, n, board)


def main():
    cnt = 0
    while True:
        N = int(input())
        if N == 0:
            return
        cnt += 1
        board = [list(map(int, input().split())) for _ in range(N)]

        print(f'Problem {cnt}: {solution(N, board)}')


if __name__ == '__main__':
    main()

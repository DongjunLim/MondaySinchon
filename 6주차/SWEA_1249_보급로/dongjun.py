'''
    다익스트라 알고리즘을 사용하여 목적지까지의 최단 경로를 찾았습니다.
    인접한 상하좌우 인덱스를 현재 정점에 연결된 정점이라 생각하고
    각 정점의 값을 인접한 정점과의 연결간선 가중치로 생각하여 풀었습니다.
'''

import sys
sys.stdin = open("input.txt","r")
import heapq

def setEdgeList(i,j):
    ''' 정점 v(i,j)에 연결된 상하좌우 정점의 간선 가중치 값 설정. '''

    global INF, N
    row, col = i, j
    up, down, left, right = INF,INF,INF,INF

    if row != 0:
        up = graph[row - 1][col]
    if row != N - 1:
        down = graph[row + 1][col]
    if col != 0:
        left = graph[row][col - 1]
    if col != N - 1:
        right = graph[row][col + 1]

    ''' 입력데이터를 문자열로 받았었기 때문에 리턴할때 정수로 변환합니다. '''
    return int(up), int(down), int(left), int(right)


T = int(input())
INF = 9999999999

for tc in range(1,T+1):

    N = int(input())
    graph = [input() for _ in range(N)]
    memo = [[INF]*N for _ in range(N)]
    visited = [[False]*N for _ in range(N)]

    queue = []
    memo[0][0] = 0

    queue.append((memo[0][0],0,0))

    while queue != []:
        now = heapq.heappop(queue)  # 방문하지 않은 정점 중에서 경로값이 최소인 정점을 꺼낸다.

        row = now[1]        # 행 인덱스
        col = now[2]        # 열 인덱스
        weight = now[0]     # 인덱스 row, col에서의 최단경로값

        up, down, left, right = setEdgeList(row,col)

        if row != 0:
            if not visited[row-1][col]:
                if weight + up < memo[row-1][col]:
                    memo[row-1][col] = weight + up
                    heapq.heappush(queue,(memo[row-1][col], row - 1, col))

        if row != N-1:
            if not visited[row+1][col]:
                if weight + down < memo[row+1][col]:
                    memo[row + 1][col] = weight + down
                    heapq.heappush(queue,(memo[row+1][col], row + 1, col))

        if col != 0:
            if not visited[row][col-1]:
                if weight + left < memo[row][col-1]:
                    memo[row][col - 1] = weight + left
                    heapq.heappush(queue,(memo[row][col-1], row, col-1))

        if col != N-1:
            if not visited[row][col+1]:
                if weight + right < memo[row][col+1]:
                    memo[row][col + 1] = weight + right
                    heapq.heappush(queue,(memo[row][col+1], row, col+1))

        visited[row][col] = True

    print(f'#{tc} {memo[-1][-1]}')

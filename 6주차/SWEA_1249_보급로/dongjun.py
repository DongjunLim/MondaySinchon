'''
    ���ͽ�Ʈ�� �˰����� ����Ͽ� ������������ �ִ� ��θ� ã�ҽ��ϴ�.
    ������ �����¿� �ε����� ���� ������ ����� �����̶� �����ϰ�
    �� ������ ���� ������ �������� ���ᰣ�� ����ġ�� �����Ͽ� Ǯ�����ϴ�.
'''

import sys
sys.stdin = open("input.txt","r")
import heapq

def setEdgeList(i,j):
    ''' ���� v(i,j)�� ����� �����¿� ������ ���� ����ġ �� ����. '''

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

    ''' �Էµ����͸� ���ڿ��� �޾Ҿ��� ������ �����Ҷ� ������ ��ȯ�մϴ�. '''
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
        now = heapq.heappop(queue)  # �湮���� ���� ���� �߿��� ��ΰ��� �ּ��� ������ ������.

        row = now[1]        # �� �ε���
        col = now[2]        # �� �ε���
        weight = now[0]     # �ε��� row, col������ �ִܰ�ΰ�

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

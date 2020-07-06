'''
    완전 그래프라고 생각하고
    프림알고리즘을 사용해 풀었습니다.
'''

import sys

sys.stdin = open("input.txt", "r")


def tex_rate(x1, y1, x2, y2):
    """ 터널길이를 구하는 함수. """
    return (x2 - x1) ** 2 + (y2 - y1) ** 2


def select_vertex(n, visited, dist, INF):
    """ 정점 선택을 위한 함수. """
    vertex = -1
    min_dist = INF

    for i in range(n):
        if not visited[i] and min_dist > dist[i]:
            min_dist = dist[i]
            vertex = i

    return vertex, min_dist


def prim(N, x_points, y_points):
    """ 프림 알고리즘으로 최소비용을 구함. """
    INF = tex_rate(0, 0, 1000001, 1000001)

    # 선택여부 확인 변수
    visited = [False] * N

    # 각 정점에서의 최소 연결가중치를 기록하는 변수
    dist = [INF] * N

    # 누적합을 담을 정답변수 실수로 초기화
    answer = 0.0

    # 0번부터 시작하기 위해 dist[0]을 0으로 초기화
    dist[0] = 0

    for _ in range(N):
        u, min_dist = select_vertex(N, visited, dist, INF)

        if u is -1: break

        answer += min_dist
        visited[u] = True

        for v in range(N):
            if not u is v and not visited[v]:
                dist[v] = min(dist[v], tex_rate(x_points[u], y_points[u], x_points[v], y_points[v]))

    return answer


def main():
    T = int(input())

    for tc in range(1, T + 1):
        # 섬의 갯수
        N = int(input())

        # 모든 섬의 x, y 좌표
        x_points = list(map(int, input().split()))
        y_points = list(map(int, input().split()))

        # 환경 세율
        E = float(input())

        print(f'#{tc} {round(prim(N, x_points, y_points) * E)}')


if __name__ == '__main__':
    main()

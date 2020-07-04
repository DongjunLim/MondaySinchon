'''
    ���� �׷������ �����ϰ�
    �����˰����� ����� Ǯ�����ϴ�.
'''

import sys

sys.stdin = open("input.txt", "r")


def tex_rate(x1, y1, x2, y2):
    """ �ͳα��̸� ���ϴ� �Լ�. """
    return (x2 - x1) ** 2 + (y2 - y1) ** 2


def select_vertex(n, visited, dist, INF):
    """ ���� ������ ���� �Լ�. """
    vertex = -1
    min_dist = INF

    for i in range(n):
        if not visited[i] and min_dist > dist[i]:
            min_dist = dist[i]
            vertex = i

    return vertex, min_dist


def prim(N, x_points, y_points):
    """ ���� �˰������� �ּҺ���� ����. """
    INF = tex_rate(0, 0, 1000001, 1000001)

    # ���ÿ��� Ȯ�� ����
    visited = [False] * N

    # �� ���������� �ּ� ���ᰡ��ġ�� ����ϴ� ����
    dist = [INF] * N

    # �������� ���� ���亯�� �Ǽ��� �ʱ�ȭ
    answer = 0.0

    # 0������ �����ϱ� ���� dist[0]�� 0���� �ʱ�ȭ
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
        # ���� ����
        N = int(input())

        # ��� ���� x, y ��ǥ
        x_points = list(map(int, input().split()))
        y_points = list(map(int, input().split()))

        # ȯ�� ����
        E = float(input())

        print(f'#{tc} {round(prim(N, x_points, y_points) * E)}')


if __name__ == '__main__':
    main()

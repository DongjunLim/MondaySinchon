"""
    200���� ����(400���� ���� ���ֺ��� ������ ������ 200��)����
    ���� ���� ��ġ�� ������ ã�Ƽ� ��ȯ�մϴ�.
    �л����� ��ΰ� ����ִ� �迭�� ��ȸ�ϸ�, ��ΰ� ��ġ�� ��� ������ ī��Ʈ�� ������ŵ�ϴ�.
    �迭�� ��� ��ȸ�ϰ� ���� ���� cnts �迭���� ���� ���� ���� ���� ��ȯ�մϴ�.
"""


import sys
sys.stdin = open("input.txt", "r")


def count_overlap(start, end, cnts):
    """ �̵���ο� �����ִ� ��� ������ ī��Ʈ�� 1�� ������ŵ�ϴ�. """
    if start % 2 is 0:
        start -= 1

    if end % 2 is 1:
        end += 1

    for i in range(start, end+1):
        cnts[i] += 1

    return


def solution(routes):
    """ �л����� �̵� ��θ� ��ȸ�մϴ�. """
    cnts = [0] * 401

    for room in routes:
        first = min(room[0], room[1])
        second = max(room[0], room[1])

        count_overlap(first, second, cnts)

    return max(cnts)


def main():
    T = int(input())

    for tc in range(1, T+1):
        N = int(input())
        routes = [tuple(map(int, input().split())) for _ in range(N)]

        print(f'#{tc} {solution(routes)}')


if __name__ == "__main__":
    main()

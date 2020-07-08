"""
    200개의 구간(400개의 방이 마주보고 있으니 구간은 200개)에서
    가장 많이 겹치는 구간을 찾아서 반환합니다.
    학생들의 경로가 들어있는 배열을 순회하며, 경로가 겹치는 모든 구간의 카운트를 증가시킵니다.
    배열을 모두 순회하고 나서 가장 cnts 배열에서 값이 가장 높은 값을 반환합니다.
"""


import sys
sys.stdin = open("input.txt", "r")


def count_overlap(start, end, cnts):
    """ 이동경로에 놓여있는 모든 구간의 카운트를 1씩 증가시킵니다. """
    if start % 2 is 0:
        start -= 1

    if end % 2 is 1:
        end += 1

    for i in range(start, end+1):
        cnts[i] += 1

    return


def solution(routes):
    """ 학생들의 이동 경로를 순회합니다. """
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

"""
    그리디하게 풀었습니다.
    routes 배열을 진출시간으로 정렬하고
    진출이 발생할때마다 진입시간에서 진출시간 사이에
    카메라가 있는지 확인합니다.
    카메라가 없다면 카메라 위치를 진출시간으로 설정하고
    answer를 카운트합니다.
"""


def solve(routes):
    answer = 0

    routes.sort(key=lambda x: x[1])
    lastCamera = -30001

    for start, end in routes:
        if start > lastCamera:
            lastCamera = end
            answer += 1

    return answer


def main():
    routes = [[-20, 15], [-14, -5], [-18, -13], [-5, -3]]

    print(solve(routes))


if __name__ == "__main__":
    main()

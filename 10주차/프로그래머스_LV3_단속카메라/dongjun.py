"""
    �׸����ϰ� Ǯ�����ϴ�.
    routes �迭�� ����ð����� �����ϰ�
    ������ �߻��Ҷ����� ���Խð����� ����ð� ���̿�
    ī�޶� �ִ��� Ȯ���մϴ�.
    ī�޶� ���ٸ� ī�޶� ��ġ�� ����ð����� �����ϰ�
    answer�� ī��Ʈ�մϴ�.
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

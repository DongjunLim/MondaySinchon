"""
    DFS�� ������ ������ ã�ҽ��ϴ�.
    �ߺ��Ǵ� ��츦 Ȯ���Ϸ��� answer�� ���ڰ� �ƴ� 2���� �迭�� �����
    �̹� ���� ������ answer�� �����ϸ� pass, �������� ������
    answer�� �����߽��ϴ�. �湮��ΰ� ��ġ�� �ʵ��� �ϱ� ����
    ������ visited������ u_check�� b_check�� �����߽��ϴ�.
"""


answer = []
u_check = []
b_check = []    


def solution(user_id, banned_id):
    global u_check, b_check, answer
    u_check = [False] * len(user_id)
    b_check = [False] * len(banned_id)

    dfs(0, user_id, banned_id, [])

    return len(answer)


def dfs(idx, user_id, banned_id, candidate):
    global u_check, b_check, answer

    if idx == len(banned_id):
        for lst in answer:
            if sorted(candidate) == sorted(lst):
                return
        answer.append(candidate.copy())
        return

    b_id = banned_id[idx]

    for i, u_id in enumerate(user_id):
        if not u_check[i] and not b_check[idx] and compare(b_id, u_id):
            u_check[i] = True
            b_check[idx] = True
            candidate.append(u_id)
            dfs(idx + 1, user_id, banned_id, candidate)
            candidate.remove(u_id)
            u_check[i] = False
            b_check[idx] = False

    return


def compare(b_id, u_id):
    if len(b_id) != len(u_id):
        return False

    for i in range(len(b_id)):
        if b_id[i] == '*':
            continue

        if u_id[i] != b_id[i]:
            return False

    return True


def main():
    user_id = ["frodo", "fradi", "crodo", "abc123", "frodoc"]
    banned_id = ["fr*d*", "*rodo", "******", "******"]

    print(solution(user_id, banned_id))

    return


if __name__ == "__main__":
    main()

"""
    DFS로 가능한 조합을 찾았습니다.
    중복되는 경우를 확인하려고 answer를 숫자가 아닌 2차원 배열로 만들고
    이미 구한 조합이 answer에 존재하면 pass, 존재하지 않으면
    answer에 삽입했습니다. 방문경로가 겹치지 않도록 하기 위해
    각각의 visited변수인 u_check와 b_check를 선언했습니다.
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

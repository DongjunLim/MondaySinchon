import sys
sys.stdin = open("input.txt", "r")


def dfs(idx, swapCnt, C, number, length):
    global answer, visited

    if swapCnt is C:
        answer = max(answer, int(''.join(number)))
        return

    for i in range(idx, length):
        for j in range(i+1, length):
            number[i], number[j] = number[j], number[i]
            if not visited[int(''.join(number))][swapCnt+1]:
                visited[int(''.join(number))][swapCnt + 1] = True
                dfs(i, swapCnt + 1, C, number, length)
            number[i], number[j] = number[j], number[i]

    return


def solution(N, C):
    global answer
    number = list(str(N))
    dfs(0, 0, C, number, len(number))


def main():
    global answer
    T = int(input())
    for tc in range(1, T+1):
        N, C = map(int, input().split())
        answer = 0
        solution(N, C)

        print(f'#{tc} {answer}')


answer = 0
visited = [[False] * 11 for _ in range(1000000)]
if __name__ == '__main__':
    main()

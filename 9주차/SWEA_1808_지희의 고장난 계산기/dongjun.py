"""
    약수 + 동적계획법을 사용해 풀었습니다.
    곱셈연산만 가능하니 A * b = target이 되는 A, B를 찾습니다.
    target의 계산기 입력 최소횟수는 A의 최소횟수 + B의 최소횟수 + 1입니다. ( 1은 곱셈키 )
    다시 A와 B 각각의 최소횟수는 A의 두 약수의 최소횟수를 더한 값 + 1, 
    B의 두 약수의 최소횟수를 더한 값 + 1로 볼 수 있습니다.
    이렇게 재귀적으로 들어가 각각의 최소횟수를 모두 구하고 이를 더해 target의 최소횟수를 구합니다.
"""


import sys
sys.stdin = open("input.txt", "r")
dp, numbers = [], []
INF = 999999999


def count_number(n):
    """ 
        곱셈 연산 없이 계산기 숫자를 눌러 숫자 n을 만들 수 있는지 확인. 
        만들 수 있다면 계산기를 몇번 눌러서 만들 수 있는지 카운트 변수 반환
    """
    global numbers, INF
    cnt = 0

    while n > 0:
        temp = n % 10
        if numbers[temp] == 0:
            return INF
        n //= 10
        cnt += 1
    return cnt


def calc(num):
    """ 소인수 분해하며 각각의 매개변수 num에서의 최소 입력값을 찾는다. """
    global dp, INF

    if dp[num] != 0:
        return dp[num]

    dp[num] = count_number(num)

    for i in range(2, int(num ** 0.5) + 1):
        if num % i == 0:
            a = calc(i)
            b = calc(num//i)

            dp[num] = min(dp[num], a+b+1 if a != INF and b != INF else INF)

    return dp[num]


def solution(target, numbers):
    global INF, dp
    dp = [0] * (target + 10)

    for i, x in enumerate(numbers):
        if x:
            dp[i] = 1

    calc(target)

    return dp[target] + 1 if dp[target] != INF else -1


def main():
    global numbers
    T = int(input())

    for tc in range(1, T+1):
        numbers = list(map(int, input().split()))
        target = int(input())

        print(f'#{tc} {solution(target, numbers)}')


if __name__ == '__main__':
    main()

'''
    이진트리를 사용해 풀었습니다.
    Alice가 먼저 시작하므로, Alice는 이진트리의 깊이가 홀수일 때의 값을, Bob은 깊이가 짝수일 떄의 값을 고를 수 있습니다.

                                1                                 Bob의 턴(1부터 시작이라 생략)
                    2                       3                     Alice의 턴
            4             5           {6}           7             Bob의 턴
        8       9    {10}     11     12    13   14     15         Alice의 턴

    숫자 n이 Alice의 높이에 있을경우, Alice는 숫자를 계속 크게 증가시키는게 유리합니다.
    반대로, 숫자 n이 Bob의 높이에 있을 경우 Alice는 숫자를 계속 작게 증가시키는게 유리합니다.
    위에 트리에서 깊이 2(Bob의 턴)의 노드를 보게 되면, n이 6미만(4, 5) 일 경우 Alice가 승리하고,
    n이 6이상(6, 7)일 경우 Bob이 승리합니다.
    깊이 3(Alice)의 노드를 보게 되면 10을 기준으로, n이 10보다 작으면 Bob이 승리하고 10이상일 경우 Alice가 승리합니다.

    따라서, 주어진 숫자 n의 이진트리 높이에서 {6}, {10}과 같은 승리를 가르는 분기숫자를 찾아내고, 누구의 턴인지에 따라
    크거나 작은 경우에 대해 승자를 찾으면 됩니다.
    마지막 턴이 Alice의 턴인 경우, 숫자 n이 분기숫자보다 크거나 같으면 Alice의 승리입니다.
    마지막 턴이 Bob의 턴인 경우, 숫자 n이 분기숫자보다 크거나 같으면 Bob의 승리입니다.
'''


import sys
import math
sys.stdin = open("input.txt", "r")


def whose_turn(depth):
    """ 매개변수 depth에서 누구의 턴인지 확인한다. Alice의 턴이면 True, Bob의 턴이면 False를 반환한다. """

    return True if depth % 2 is 1 else False


def check_winner(depth, branch_number, target_number):
    """ 마지막 턴에서 분기숫자를 기준으로 승자를 확인한다. """

    if whose_turn(depth):
        if branch_number <= target_number:
            return 'Alice'
        else:
            return 'Bob'
    else:
        if branch_number <= target_number:
            return 'Bob'
        else:
            return 'Alice'


def calc_branch_number(depth):
    """ 이진트리의 특정 깊이 depth 에서의 분기숫자를 찾는다."""

    num = 1

    if whose_turn(depth):
        for i in range(1, depth+1):
            if i % 2 is 1:
                num = num * 2
            elif i % 2 is 0:
                num = num * 2 + 1
    else:
        for i in range(1, depth+1):
            if i % 2 is 1:
                num = num * 2 + 1
            elif i % 2 is 0:
                num = num * 2

    return num


def solution(n):
    """ 숫자 n의 트리 깊이를 계산하고, 분기숫자를 찾아내 승자를 찾는다. """

    depth = int(math.log(n,2))
    branch_number = calc_branch_number(depth)

    return check_winner(depth, branch_number, n)


def main():
    T = int(input())

    for tc in range(1, T+1):
        N = int(input())
        print(f'#{tc} {solution(N)}')

    return


if __name__ == "__main__":
    main()

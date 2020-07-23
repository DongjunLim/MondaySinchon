"""
    엘리스와 토끼는 최선을 다해서 게임을 해야 합니다.
    여기서 최선을 다해 게임을 하는 경우는 다음과 같습니다.
    
    number의 길이가 짝수일때:
        number의 길이를 홀수로 만들어야 유리합니다.
        따라서 만들 수 있는 가장 작은 값을 만들어 number의 길이를 홀수로 만듭니다.
    number의 길이가 홀수일때:
        number의 길이를 홀수로 유지시켜 상대에게 줘야 유리합니다.
        따라서 만들 수 있는 가장 큰 값을 만들어 number의 길이가 줄지 않도록 합니다.
    
    숫자의 크기가 1자리수가 됐을때 반복을 종료하고 해당 턴이 아닌 플레이어를 반환합니다. 
"""


import sys
sys.stdin = open("input.txt", "r")

alice = 0
rabbit = 1
INF = 20


def solve(num):
    global alice, rabbit, INF

    length = len(num)
    turn = alice

    while length > 1:
        index = [0, 1]
        if length % 2 == 0:
            choice = INF
            for i in range(1, length):
                if choice > int(num[i]) + int(num[i-1]):
                    choice = int(num[i]) + int(num[i-1])
                    index = [i-1, i]
        else:
            choice = 0
            for i in range(1, length):
                if choice < int(num[i]) + int(num[i-1]):
                    choice = int(num[i]) + int(num[i-1])
                    index = [i-1, i]

        if choice > 9:
            num[index[0]] = 1
            num[index[1]] = choice % 10
        else:
            num[index[0]] = choice
            del num[index[1]]
            length -= 1

        turn = rabbit if turn == alice else alice

    return "A" if turn == rabbit else "B"


def main():
    T = int(input())
    for tc in range(1, T+1):
        number = list(input())

        print(f'#{tc} {solve(number)}')


if __name__ == '__main__':
    main()

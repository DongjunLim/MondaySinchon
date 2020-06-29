"""
    완전탐색으로 모든 경우의 수를 탐색.
    모든 기타로 만들 수 있는 연주곡의 조합을 구하고,
    가장 많은 연주곡을 재생하는 경우, 기존에 구했던
    최소 기타수와 비교해 더 적은 기타를 가지고 연주가 가능하면
    정답을 갱신한다.
"""

import sys
from collections import deque
sys.stdin = open("input.txt","r")
INF = 999999999

def combine(str1, str2):
    """ 문자열을 결합하는 함수. """
    result = ''

    for i in range(len(str1)):
        result += isYes(str1[i],str2[i])

    return result

def isYes(char1, char2):
    """ Y와 N을 OR 시켜 Y로 바꾸는 함수. """
    return 'Y' if char1 == 'Y' or char2 == 'Y' else 'N'


def bruteForce(index, playlist, num):
    """ 재귀호출을 통해 모든 경우의 수를 구함."""
    global guitars, N, answer

    yCnt = playlist.count('Y')

    if answer[1] < yCnt:
        answer[0] = num
        answer[1] = yCnt
    elif answer[1] == yCnt:
        answer[0] = min(answer[0], num)

    if index == N:
        return

    bruteForce(index+1, combine(playlist, guitars[index][1]), num+1)
    bruteForce(index+1, playlist,num)
    return



N, M = map(int, input().split())

guitars = [tuple(map(str, input().split())) for _ in range(N)]

answer = [INF,0]
visited = [False] * N
start = 'N' * M

bruteForce(0, start, 0)

if answer[0] != 0:
    print(answer[0])
else:
    print(-1)

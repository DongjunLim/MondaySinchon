import sys
from itertools import combinations
sys.stdin = open("./input.txt", "r")

N, M= map(int, input().split())

cardList = list(map(int,input().split()))

answer = 0

#카드 리스트에서 3개를 뽑아 나올 수 있는 모든 경우의 수를 comb에 저장
comb = list(combinations(cardList, 3))

for x in comb:
    #각각의 경우의 수로 뽑힌 수를 더함
    cardSum = sum(x)
    
    #더한 경우의 수가 M보다 작고 answer 값보다 크면 answer를 갱신
    if cardSum <= M and cardSum > answer:
        answer = cardSum

#결과 출력
print(answer)

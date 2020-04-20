T = int(input())

i = 0
answer = 0

#1부터 시작해 원하는 숫자가 나올때까지 반복
while T:
    i = i+1
    
    # 666이 들어간 숫자를 찾으면 T를 감소시킨다
    if '666' in str(i):
        T = T-1
        answer = i

#결과출력
print(answer)


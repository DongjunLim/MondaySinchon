import sys
import time
import copy
sys.stdin = open("./input.txt", "r")
print()

# 테스트케이스 갯수 입력받음
T = int(input())

# 테스트케이스 갯수만큼 순회
for tc in range(1, T+1):

    # 테스트케이스 입력받음
    x = list(map(str, input()))
    print(f'input: {10**(tc+1)}')
    a = x
    b = copy.deepcopy(x)

    # 라이브러리 정렬시간측정
    # 시작시간측정
    start = time.time()
    # 정렬알고리즘호출
    a.sort()
    # 끝나는시간 측정해서 시작시간을뺀다. ms로 표시할거기때문에 1000을 곱함
    ms = (time.time()-start)*1000

    print(f"라이브러리 : {round(ms,2)}ms")

    # 직접짠코드 시간측정
    # 시작시간측정
    start = time.time()
    # 정렬알고리즘호출
    b.sort()
    # 끝나는시간 측정해서 시작시간을뺀다. ms로 표시할거기때문에 1000을 곱함
    ms = (time.time()-start)*1000
    print(f"내가 짠 코드 : {round(ms,2)}ms")
    print()

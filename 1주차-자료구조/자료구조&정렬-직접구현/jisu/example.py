import sys
import time
import copy
from sorts import *
sys.stdin = open("../input.txt", "r")
print()
x = [1,4,8,7,3,2,6]
merge_sort(x)
print(x)
# # 테스트케이스 갯수 입력받음
# T = int(input())
#
# # 테스트케이스 갯수만큼 순회
# for tc in range(1, T+1):
#
#     # 테스트케이스 입력받음
#     x = list(map(str, input()))
#     print(f'input: {10**(tc+1)}')
#     a = x
#     b = copy.deepcopy(x)
#
#     # 라이브러리 정렬시간측정
#     # 시작시간측정
#     start = time.time()
#     # 정렬알고리즘호출
#     a.sort()
#     # 끝나는시간 측정해서 시작시간을뺀다. ms로 표시할거기때문에 1000을 곱함
#     ms = (time.time()-start)*1000
#
#     print(f"라이브러리 : {round(ms,2)}ms")
#
#     # 직접짠코드 시간측정
#     # 시작시간측정
#     start = time.time()
#     # 정렬알고리즘호출
#     merge_sort(b)
#     # 끝나는시간 측정해서 시작시간을뺀다. ms로 표시할거기때문에 1000을 곱함
#     ms = (time.time()-start)*1000
#     print(f"내가 짠 코드 : {round(ms,2)}ms")
#     print()

'''
insertion_sort

input: 100
라이브러리 : 0.0ms
내가 짠 코드 : 2.99ms

input: 1000
라이브러리 : 0.0ms
내가 짠 코드 : 260.34ms

input: 10000
라이브러리 : 2.99ms
내가 짠 코드 : 33480.54ms

merge_sort

input: 100
라이브러리 : 0.0ms
내가 짠 코드 : 1.0ms

input: 1000
라이브러리 : 0.0ms
내가 짠 코드 : 12.97ms

input: 10000
라이브러리 : 1.99ms
내가 짠 코드 : 195.46ms

input: 100000
라이브러리 : 31.91ms
내가 짠 코드 : 2199.43ms

input: 1000000
라이브러리 : 273.81ms
내가 짠 코드 : 31389.11ms

quick_sort

input: 100
라이브러리 : 0.0ms
내가 짠 코드 : 1.0ms

input: 1000
라이브러리 : 0.0ms
내가 짠 코드 : 8.98ms

input: 10000
라이브러리 : 2.99ms
내가 짠 코드 : 108.71ms

input: 100000
라이브러리 : 26.93ms
내가 짠 코드 : 1375.32ms

input: 1000000
라이브러리 : 289.26ms
내가 짠 코드 : 15688.85ms

'''
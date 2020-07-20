"""
    min heap과 max heap을 사용해 구현했습니다.
    조건은 다음과 같습니다.
    1. maxHeap의 크기가 min Heap의 크기와 같거나 1크다
    (1이 큰 이유는 중간값이 maxHeap에 들어있기 떄문)
    2. min heap의 모든 원소는 max heap의 모든 원소보다 크다.
    
    즉 max heap과 min heap은 중간값을 기준으로 큰 수와 작은 수로 나눠지는 겁니다.
    min heap에는 중간값보다 큰 값들을,
    max heap에는 중간값을 포함해 중간값보다 작은 값들을 삽입합니다.
    만약 min heap의 가장 작은 값이 max heap의 가장 큰 값보다 크다면,
    조건 2를 지키기 위해 두 원소를 스왑합니다.
"""

import heapq
import sys

sys.stdin = open("input.txt", "r")
input = sys.stdin.readline
print = sys.stdout.write


def solution(speak):
    minHeap = []
    maxHeap = []
    
    """ 
        파이썬의 heap 은 기본적으로 min heap입니다.
        max heap에 삽입할때 -를 붙여 가장 큰 값을
        가장 작은 값으로 만들어 heap에 삽입하는 방법으로
        max heap을 구현했습니다.
    """
    
    for x in speak:
        if len(maxHeap) > len(minHeap):
            heapq.heappush(minHeap, x)
        else:
            heapq.heappush(maxHeap, -x)

        if minHeap and maxHeap and -maxHeap[0] > minHeap[0]:
            minTemp = heapq.heappop(minHeap)
            maxTemp = heapq.heappop(maxHeap)

            heapq.heappush(minHeap, -maxTemp)
            heapq.heappush(maxHeap, -minTemp)

        print(f'{-maxHeap[0]}\n')

def main():
    n = int(input())
    speak = [int(input()) for _ in range(n)]
    solution(speak)


if __name__ == '__main__':
    main()

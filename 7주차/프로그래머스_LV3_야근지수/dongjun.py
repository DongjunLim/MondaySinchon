"""
    MAX_HEAP을 사용해 구현했습니다.
    야근지수를 낮추려면 가장 높은 값부터 감소시켜야 합니다.
    Max heap 자료구조를 사용해 가장 높은 값부터 감소시킵니다.
    감소시킬때는 1씩 감소시키지 않고 그 다음 높은 값만큼 한꺼번에 감소시킵니다.
"""


import heapq


def solution(n, works):
    max_heap = []
    answer = 0

    for x in works:
        heapq.heappush(max_heap, (-x, x))

    while n:
        now = heapq.heappop(max_heap)[1]
        comparison = max_heap[0][1]

        if now is 0:
            return 0

        sub = now - comparison
        if sub is 0:
            n -= 1
            now -= 1
        elif sub <= n:
            now -= sub
            n -= sub
        else:
            now -= n
            n = 0

        heapq.heappush(max_heap, (-now, now))

    for x in max_heap:
        answer += x[1]**2

    return answer

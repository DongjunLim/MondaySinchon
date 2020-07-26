"""
    이분탐색으로 풀었습니다.
    돌의 최대값은 2억이기 때문에
    징검다리를 건널 수 있는 친구의 수는 최대 2억입니다.
    1부터 2억 범위 내에서 이분탐색을 해가며 건널 수 있는 최대 값을 찾았습니다.
"""


def solution(stones, k):
    left, right = 1, max(stones)
    answer = 0

    while left <= right:
        mid = (left + right) // 2

        cnt = 0
        for stn in stones:
            if stn - mid < 0:
                cnt += 1
            else:
                cnt = 0
            # 건널 수 없는 징검다리의 수가 연속으로 k개 있으면 건너지 못하는 것이므로 반복문을 종료합니다.
            if cnt == k:
                break

        # mid 명의 친구가 건널 수 없으면 right를 mid -1로 옮겨 친구의 수를 반으로 줄여봅니다.
        if cnt == k:
            right = mid - 1
        
        # mid 명의 친구가 건널 수 있으면 answer의 값을 갱신하고 left를 mid+1로 옮겨 친구의 수를 증가시킵니다.
        else:
            answer = mid
            left = mid + 1


    return answer

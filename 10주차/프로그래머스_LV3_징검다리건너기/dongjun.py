"""
    �̺�Ž������ Ǯ�����ϴ�.
    ���� �ִ밪�� 2���̱� ������
    ¡�˴ٸ��� �ǳ� �� �ִ� ģ���� ���� �ִ� 2���Դϴ�.
    1���� 2�� ���� ������ �̺�Ž���� �ذ��� �ǳ� �� �ִ� �ִ� ���� ã�ҽ��ϴ�.
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
            # �ǳ� �� ���� ¡�˴ٸ��� ���� �������� k�� ������ �ǳ��� ���ϴ� ���̹Ƿ� �ݺ����� �����մϴ�.
            if cnt == k:
                break

        # mid ���� ģ���� �ǳ� �� ������ right�� mid -1�� �Ű� ģ���� ���� ������ �ٿ����ϴ�.
        if cnt == k:
            right = mid - 1
        
        # mid ���� ģ���� �ǳ� �� ������ answer�� ���� �����ϰ� left�� mid+1�� �Ű� ģ���� ���� ������ŵ�ϴ�.
        else:
            answer = mid
            left = mid + 1


    return answer

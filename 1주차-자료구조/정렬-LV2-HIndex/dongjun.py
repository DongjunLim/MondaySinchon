def solution(citations):
    # 정답변수
    answer = 0

    # H-Index 후보를 담을 리스트 변수
    HIndexList = []

    # 입력데이터 정렬
    citations.sort()

    # 배열의 길이를 담을 변수
    length = len(citations)

    for i, x in enumerate(citations, 1):

        # 논문인용수 x만큼 인용한 논문갯수가 x개보다 많을 경우
        if x <= length - i:
            HIndexList.append(length - i)

    # HIndexList가 비어있으면, HIndex = 논문의 수와 같다
    if not HIndexList:
        answer = length

    # HIndexList에 값이 있으면 그 중에 가장 작은 값이 HIndex이다.
    else:
        answer = min(HIndexList)

    # 결과출력
    return answer


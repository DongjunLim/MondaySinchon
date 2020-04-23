def solution(brown, red):
    answer = []
    # 카펫의 가로세로 길이는 최대 2500을 넘지 않는다. 갈색격자의 MAX가 5000이므로
    for i in range(1,2500):
        for j in range(1,2500):
            
            # 행 i와 열 j가 다음 세 가지 조건을 만족하는지 확인한다.
            # 1. 갈색격자와 빨간색격자를 합하면 전체크기가 되는지
            # 2. 전체크기에서 테두리를 뺀 영역이 빨간색격자의 크기와 일치하는지
            # 3. 가로의 길이가 새로보다 큰지
            if brown + red == i*j and (i-2)*(j-2) == red and i >= j:
                    # 조건문을 만족하면 행 i와 열 j를 리스트에 담아 반환
                    answer = [i,j]
                    return answer

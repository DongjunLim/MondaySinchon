def solution(brown, red):
    answer = []
    total = brown + red
    row = 0
    col = 0
    calc = 0

    while True:
        # row를 하나씩 올린다.
        row += 1
        # total에서 나눈 몫을 col로 한다.
        col = total // row
        # 곱해서 calc에 저장한다.
        calc = row * col
        '''
        기저조건 
        1. total 과 calc가 일치해야 함.
        2. 가로 길이가 세로 길이와 같거나 세로 길이보다 길어야 함.
        3. 중앙에는 항상 빨간 카펫이 있어야 함.
        -> 맞으면 종료
        '''
        if total == calc and row >= col and (row - 2) * (col - 2) == red:
            break
    answer = [row, col]
    return answer
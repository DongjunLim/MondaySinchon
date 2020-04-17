import sys
sys.stdin = open("./input.txt", "r")
T = int(input())

for tc in range(1, T+1):

    #입력 문자열 저장
    L = list(sys.stdin.readline().replace("\n",""))

    #커서를 기준으로 왼쪽 범위 데이, 오른쪽 범위 데이터를 담을 스택 각각 선언
    leftStack = []
    rightStack = []

    #문자열 순회
    for x in L:

        #'-'일때 왼족스택을 pop해 데이터 삭제
        if x == '-':
            if len(leftStack) != 0:
                leftStack.pop()

        #'<'일때 왼쪽스택의 top 데이터를 오른쪽 스택에 push
        elif x == '<':
            if len(leftStack) != 0:
                rightStack.append(leftStack.pop())

        #'>'일때 오른쪽스택의 top 데이터를 왼쪽 스택에 push
        elif x == '>':
            if len(rightStack) != 0:
                leftStack.append(rightStack.pop())

        #일반문자일때 왼쪽스택에 push
        else:
            leftStack.append(x)

    #스택리스트를 문자열로 전환
    left = ''.join(leftStack)
    right = ''.join(rightStack[::-1])

    #왼쪽문자열과 오른쪽문자열을 병합
    answer = ''.join([left,right])

    #결과출력
    print(answer)
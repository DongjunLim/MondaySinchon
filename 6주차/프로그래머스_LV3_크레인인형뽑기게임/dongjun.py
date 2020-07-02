'''
    스택을 사용하여 풀이.
    조건에 맞는 인형을 스택에 집어넣고,
    스택의 peek와 인형이 일치하면 스택에 집어넣지 않고 pop.
    인형이 2개씩 터지므로 정답에 2를 더한다.
'''


def solution(board,moves):
    answer = 0
    stack = []

    for j in moves:
        for i in range(len(board)):
            if board[i][j-1] == 0:
                continue
            else:
                if stack != []:
                    if stack[-1] == board[i][j-1]:
                        stack.pop()
                        answer += 2
                        board[i][j-1] = 0
                        break

                stack.append(board[i][j-1])
                board[i][j-1] = 0
                break

    return answer

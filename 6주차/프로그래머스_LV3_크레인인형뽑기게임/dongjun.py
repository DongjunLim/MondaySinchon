'''
    ������ ����Ͽ� Ǯ��.
    ���ǿ� �´� ������ ���ÿ� ����ְ�,
    ������ peek�� ������ ��ġ�ϸ� ���ÿ� ������� �ʰ� pop.
    ������ 2���� �����Ƿ� ���信 2�� ���Ѵ�.
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

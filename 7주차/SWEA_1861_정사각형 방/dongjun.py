""" 
    ���� Ž���� ����� Ǯ�����ϴ�.
    �迭�� ��� x, y ��ǥ���� ��ŭ �̵��� �������� ��������� Ž���ؼ� ���ϰ�,
    ���� �� �� ���� ���� ���� ��ǥ�� ����մϴ�.
"""

import sys
sys.stdin = open("input.txt", "r")


def next_point(row, col, board):
    """ ���� ��ǥ���� �̵� ������ ��ΰ� �ִ��� Ȯ���ϰ�, ��ΰ� �����ϸ� ����� ��ǥ���� ��ȯ�Ѵ�. """
    now = board[row][col]
    length = len(board)-1

    if row is not 0 and board[row-1][col] == now + 1:
        return row-1, col

    if row is not length and board[row+1][col] == now + 1:
        return row+1, col

    if col is not 0 and board[row][col-1] == now + 1:
        return row, col-1

    if col is not length and board[row][col+1] == now + 1:
        return row, col+1

    return -1, -1


def brute_force(row, col, board, move_cnt):
    """ ���� ��ǥ���� �̵��� �Ұ����� ������ ��������� Ž���Ѵ�. """
    next_row, next_col = next_point(row, col, board)

    if next_row == -1:
        return move_cnt

    return brute_force(next_row, next_col, board, move_cnt + 1)


def solution(N, board):
    """ 2�� for ���� ��ȸ�ϸ� ������ ��ǥ�������� �̵�Ƚ���� ��� ���ϰ�, ���� ���� ���� ��ǥ�� ��ȯ�Ѵ�. """
    answer = 1
    number = 1
    
    for i in range(N):
        for j in range(N):
            move_cnt = brute_force(i, j, board, 1)
            
            if answer < move_cnt:
                answer = move_cnt
                number = board[i][j]
            elif answer == move_cnt:
                number = min(number, board[i][j])
                
    return number, answer


def main():
    T = int(input())

    for tc in range(1, T+1):
        N = int(input())
        board = [list(map(int, input().split())) for _ in range(N)]

        number, answer = solution(N, board)

        print(f'#{tc} {number} {answer}')


if __name__ == "__main__":
    main()

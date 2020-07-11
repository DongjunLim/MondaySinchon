import sys
sys.stdin = open("input.txt", "r")


def check_out_of_range(row, col, N, M):
    """ �� ������ ������� Ȯ��. """
    if 0 > row or row >= N or 0 > col or col >= M:
        return True
    
    return False


def cleaning(row, col):
    """ board[row][col] ��ǥ�� û��ǥ���ϰ� û��Ƚ���� ī��Ʈ. """
    global isClean, answer

    isClean[row][col] = True
    answer += 1

    return


def is_cleaning_possible(N, M, row, col, board):
    """ board[row][col]�� û���� �� �ִ��� Ȯ��. """
    global isClean

    if check_out_of_range(row, col, N, M):
        return False

    if board[row][col] == 1:
        return False

    if isClean[row][col]:
        return False

    return True


def is_reverse_possible(N, M, row, col, board):
    """ ������ �� �ִ��� Ȯ��. """
    if check_out_of_range(row, col, N, M):
        return False

    if board[row][col] == 1:
        return False

    return True


def solution(N, M, row, col, d, board):
    """ ������ ��Ģ��� û�Ҹ� �Ѵ�. """
    global isClean, answer
    dt = [(-1, 0), (0, 1), (1, 0), (0, -1)]

    # 1. ���� ��ġ û��
    while True:
        cleaning(row, col)
        rCnt = 0
        reverse_row, reverse_col = dt[(d + 2) % 4]
        
        # 2. �ֺ� Ž��
        while True:
            rCnt += 1
            d = (d - 1) % 4
            next_row, next_col = dt[d]
            
            # 2-1. ���� ���� ���ʹ��⿡ û�Ҹ� �� �� �ִ°�? û���� �� �ִٸ� �̵�
            if is_cleaning_possible(N, M, row + next_row, col + next_col, board):
                row, col = row + next_row, col + next_col
                break

            # 2-2. 4������ Ȯ������ �ʾ��� ��� ���⸸ ��ȯ
            elif rCnt < 4:
                continue

            # 2-3. 4������ ��� Ȯ������ ���, ������ �������� Ȯ��, ������ �����ϸ� ����
            elif is_reverse_possible(N, M, row + reverse_row, col + reverse_col, board):
                row, col = row + reverse_row, col + reverse_col
                rCnt = 0
                continue
            
            # 2-4. ������ �������� ������ û�� ����
            else:
                return 0


def main():
    N, M = map(int, input().split())
    r, c, d = map(int, input().split())

    board = [list(map(int, input().split())) for _ in range(N)]

    solution(N, M, r, c, d, board)
    
    print(answer)


isClean = [[False] * 51 for _ in range(51)]
answer = 0


if __name__ == '__main__':
    main()

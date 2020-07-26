"""
    경우의 수 다 따지면서 무식하게 풀었습니다.
"""


import sys
sys.stdin = open("input.txt", "r")
dt = [[1, 1], [1, 0], [1, -1], [0, -1], [0, 1], [-1, -1], [-1, 0], [-1, 1]]


def count_bingo(board):
    """ 몇개의 빙고가 있는지 확인 """
    oc, xc = 0, 0

    tempX, tempO = 0, 0
    tempX2, tempO2 = 0, 0
    for i in range(3):
        if board[i][i] == 'O':
            tempO += 1
        elif board[i][i] == 'X':
            tempX += 1
        if board[2-i][i] == 'O':
            tempO2 += 1
        elif board[2-i][i] == 'X':
            tempX2 += 1

    if tempO == 3:
        oc += 1
    elif tempX == 3:
        xc += 1
    if tempO2 == 3:
        oc += 1
    elif tempX2 == 3:
        xc += 1

    for row in board:
        if row.count('O') == 3:
            oc += 1
        elif row.count('X') == 3:
            xc += 1

    for i in range(3):
        tempX = 0
        tempO = 0
        for j in range(3):
            if board[j][i] == 'O':
                tempO += 1
            elif board[j][i] == 'X':
                tempX += 1
        if tempO == 3:
            oc += 1
        elif tempX == 3:
            xc += 1

    return oc, xc


def solve(board):
    xc = board.count('X')
    oc = board.count('O')

    if xc > oc + 1 or xc < oc:
        return "invalid"

    mat = [board[i:i + 3] for i in range(0, 9, 3)]

    o, x = count_bingo(mat)

    if x != 0 and o != 0:
        return "invalid"

    if o > 0 and xc > oc:
        return "invalid"

    if x > 0 and xc == oc:
        return "invalid"

    if '.' not in board:
        return "valid"

    if x == 0 and o == 0:
        return "invalid"

    return "valid"


def main():
    while True:
        board = input()
        if board == "end":
            return

        print(solve(list(board)))


if __name__ == "__main__":
    main()


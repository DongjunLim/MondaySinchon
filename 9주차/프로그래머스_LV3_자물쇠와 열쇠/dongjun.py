"""
    시뮬레이션 문제로 생각하고, 문제 조건 그대로 구현해서 풀었습니다.
    lock 배열에 key의 크기만큼 -1로 패딩을 주어 키의 위치를 옮겼을때 인덱스를 벗어나지 않도록 했습니다.
    예) key의 크기가 2x2 이고 lock의 크기가 3x3인
        [1,0,1]
        [0,1,0]
        [1,1,1]
        배열이라면 상하좌우 key의 길이 - 1 만큼의 padding을 주어
       [-1,-1,-1,-1,-1]
       [-1, 1, 0, 1,-1]
       [-1, 0, 1, 0,-1]
       [-1, 1, 1, 1,-1]
       [-1,-1,-1,-1,-1]
       형태의 5X5 lock 배열을 만듭니다.
    key배열을 시계방향으로 회전시키고 새로 만든 배열을 순회하며 자물쇠를 열 수 있는지 확인합니다.
    0도 90도 180도 270도로 key배열을 회전시켜도 자물쇠를 열 수 없으면 False를 반환합니다.
"""


def set_padding(key, lock):
    """ 입력 lock 배열에 패딩을 주는 함수. """
    lockLength = len(lock)
    keyLength = len(key) - 1
    paddingLength = lockLength + (keyLength * 2)

    arr = [[-1] * paddingLength for _ in range(paddingLength)]

    for i in range(keyLength, paddingLength - keyLength):
        for j in range(keyLength, paddingLength - keyLength):
            arr[i][j] = lock[i-keyLength][j-keyLength]

    return arr


def rotate_key(key):
    """ 키를 회전시키는 함수. 시계방향으로 90도 회전시킨다. """
    n = len(key)

    newKey = [[0] * n for _ in range(n)]

    for row in range(n):
        for col in range(n):
            newKey[col][n-1-row] = key[row][col]

    return newKey


def is_unlock(row, col, keyL, lockCnt, key, lock):
    """ lock[row][col] 위치에서 key를 통해 자물쇠를 열 수 있는지 확인한다. """
    cnt = 0

    for r in range(row, row + keyL + 1):
        for c in range(col, col + keyL + 1):
            if key[r - row][c - col] == 1 and lock[r][c] == 0:
                lock[r][c] = 1
                cnt += 1
            elif key[r - row][c - col] == 1 and lock[r][c] == 1:
                return False

    if cnt == lockCnt:
        return True
    else:
        return False


def solution(key, lock):

    lockCnt = 0

    for row in lock:
        lockCnt += row.count(0)

    newLock = set_padding(key, lock)

    keyL = len(key) - 1
    lockL = len(newLock)

    for _ in range(4):
        key = rotate_key(key)

        for row in range(lockL-keyL):
            for col in range(lockL-keyL):
                newLock = set_padding(key, lock)
                if is_unlock(row, col, keyL, lockCnt, key, newLock):
                    return True
    return False


def main():

    key = [[0, 0, 0], [1, 0, 0], [0, 1, 1]]
    lock = [[1, 1, 1], [1, 1, 0], [1, 0, 1]]

    print(solution(key, lock))


if __name__ == '__main__':
    main()

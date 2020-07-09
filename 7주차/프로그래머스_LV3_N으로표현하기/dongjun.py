"""
    동적계획법을 사용해 풀었습니다.
    숫자 N을 하나만 사용해서 만들 수 있는 숫자들부터,
    8번을 모두 사용해서 만들 수 있는 숫자들까지를
    use_counts에 저장했습니다.
    여기서 N을 x번 사용해서 만들 수 있는 숫자는
    use_counts[x]에 저장됩니다.
"""


def calc_number_of_uses(idx, use_counts):
    """ idx = 사용하는 N의 갯수, 숫자 N을 idx 만큼 사용해 만들 수 있는 모든 숫자를 use_counts[idx]에 저장합니다. """
    for j in range(1, idx):
        for x in use_counts[j]:
            for y in use_counts[idx-j]:
                use_counts[idx].add(x + y)
                use_counts[idx].add(x * y)
                use_counts[idx].add(x - y)
                use_counts[idx].add(y - x)
                if y is not 0:  use_counts[idx].add(x // y)
                if x is not 0:  use_counts[idx].add(y // x)
    return


def update_memo(idx, memo, use_counts):
    """ 숫자 num에 대해, N을 최소로 사용했을 때의 N의 갯수를 memo[num]에 저장합니다. """
    for num in use_counts[idx]:
        if MAX_NUMBER >= num > 1:
            memo[num] = min(memo[num], idx)
    return


def set_base_numbers(N, use_counts):
    """ use_count[1]부터 use_count[N]까지 각각 N,NN,NNN,...,NNNN...N을 기본으로 저장합니다."""
    temp = ''
    for use_count in use_counts[1:]:
        temp += str(N)
        use_count.add(int(temp))


def solution(N, number):
    memo = [9] * (MAX_NUMBER + 1)
    use_counts = [set() for _ in range(10)]

    set_base_numbers(N, use_counts)

    memo[N] = 1

    for i in range(2, 9):
        calc_number_of_uses(i, use_counts)
        update_memo(i, memo, use_counts)

    return memo[number] if memo[number] < 9 else -1


def main():
    N = 4
    number = 17
    print(solution(N, number))


MAX_NUMBER = 32000

if __name__ == '__main__':
    main()

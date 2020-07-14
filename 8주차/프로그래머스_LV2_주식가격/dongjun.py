def solution(prices):
    answer = []
    length = len(prices)

    for i in range(length):
        end = True
        for j in range(i+1, length):
            if prices[i] > prices[j]:
                answer.append(j-i)
                end = False
                break
        if end:
            answer.append(length-1-i)

    return answer

def solution(citations):
    answer = 0

    # 역방향 정렬
    citations.sort(reverse=True)

    # 인용 수를 계산하기 위해 2차원으로 확장
    calc_h = [[j, 0] for j in citations]

    # 순서대로 인 횟수를 하나씩 늘려줌 인용 
    for i in range(len(citations)):
        calc_h[i][1] += i + 1

    # H-index를 계산, citation에 H-index 저장 
    for i in range(len(citations)):
        if calc_h[i - 1][0] > calc_h[i - 1][1]:
            citations[i - 1] = calc_h[i - 1][1]

    # 최대 H-index 찾기 위해 정방향 정렬 
    citations.sort()

    # answer에 저장
    answer = citations[len(citations) - 1]

    return answer

'''
테스트 1 〉	통과 (0.29ms, 10.7MB)
테스트 2 〉	통과 (0.52ms, 10.8MB)
테스트 3 〉	통과 (0.45ms, 10.6MB)
테스트 4 〉	통과 (0.42ms, 10.7MB)
테스트 5 〉	통과 (0.47ms, 10.8MB)
테스트 6 〉	통과 (0.53ms, 10.7MB)
테스트 7 〉	통과 (0.18ms, 10.8MB)
테스트 8 〉	통과 (0.06ms, 10.8MB)
테스트 9 〉	통과 (0.10ms, 10.7MB)
테스트 10 〉	통과 (0.34ms, 10.8MB)
테스트 11 〉	통과 (0.60ms, 10.8MB)
테스트 12 〉	통과 (0.10ms, 10.8MB)
테스트 13 〉	통과 (0.56ms, 10.8MB)
테스트 14 〉	통과 (0.49ms, 10.7MB)
테스트 15 〉	통과 (0.54ms, 10.7MB)
테스트 16 〉	통과 (0.04ms, 10.7MB)
'''
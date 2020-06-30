'''
    깊이 우선 탐색을 통해 시작 정점과 연결된 모든 정점을 방문 처리 합니다.
    최초로 dfs에 들어가는 경우(방문하지 않은 정점을 발견했을 때)만 카운트를 1 증가시킵니다.
'''

answer = 0
visited = []

def dfs(i,adj_list):
    ''' 시작 정점 i와 연결된 모든 노드를 방문 처리. '''
    global answer, visited
    computer = adj_list[i]

    for x in computer:
        if visited[x]:
            continue
        visited[x] = True
        dfs(x,adj_list,depth+1,n)


def solution(n, computers):
    global visited,answer
    answer = 0

    visited = [False] * n
    length = len(computers)
    adj_list = [set() for _ in range(length)]

    ''' 인접행렬을 인접리스트로 변환하는 과정. '''
    for i in range(length):
        for j in range(length):
            if i == j:
                continue
            if computers[i][j] == 1:
                adj_list[i].add(j)
                adj_list[j].add(i)
    for i in range(length):
        adj_list[i] = list(adj_list[i])

    ''' 정점 순회. 방문 가능 한 경우만 dfs함수를 호출하여 연결된 모든 정점을 방문처리 합니다. '''
    for i in range(length):
        if visited[i]:
            continue
        visited[i] = True

        dfs(i,adj_list)
        answer += 1

    return answer

total = []
adjacencyList = {}
length = 0
import copy

# 이전에 구한 정답과 새로 구한 값과 뭐가 더 오름차순인지 비교
def compare(list1, list2):
    for i in range(len(list1)):
        if list1[i] > list2[i]:
            return True
        elif list2[i] > list1[i]:
            return False
    return None

# 여행시작
def dfs(dict, airport, candidate):
    global length
    global total

    # 해당 공항에서 갈 수 있는 공항이 없을 경우
    if not airport in dict.keys():
        # 모든 항공권을 다 썼는지 확인
        if len(candidate) == length:
            candidate.append(airport)
            if total == [] or compare(total,candidate):
                total = candidate
            return
        else:
            return

    # 항공권을 다 썼을 때 경우
    if len(candidate) == length:
        candidate.append(airport)
        if total == [] or compare(total, candidate):
            total = candidate
        return

    # 경로 배열 복사
    route = copy.deepcopy(candidate)
    # 해당 공항에서 갈 수 있는 항공권 리스트
    temp = dict[str(airport)]

    # 해당 공항에서 갈 수 있는 항공권 모두 가보는 반복문
    # 재귀호출할때 항공권을 하나씩 제거하면서 탐색한다(이미 사용한 항공권을 또 탐색하면 안되니까)
    for i,ap in enumerate(temp):

        temp.pop(i)         # 이번에 사용하는 항공권 제거
        route.append(ap)    # 경로에 해당하는 항공권 추가

        dfs(dict,ap,route)  # 도착지 공항을 기준으로 재귀호출

        route.pop(-1)       # 경로에서 항공권 삭제
        temp.insert(i,ap)   # 재귀호출이 끝나면 항공권을 다시 복구한다.

def solution(tickets):
    global length
    array = []
    length = len(tickets)+1

    # 입력 배열을 인접리스트로 변환하는 과정
    for i in tickets:
        temp = []
        if i[0] in adjacencyList.keys():
            temp = adjacencyList[str(i[0])]
        temp.append(i[1])
        adjacencyList[str(i[0])] = temp

    # 인천공항에서 출발하므로 경로에 인천공항 삽입
    array.append("ICN")
    # 인천공항부터 여행 시작
    dfs(adjacencyList, "ICN", array)

    # 결과 출력
    answer = total
    return answer

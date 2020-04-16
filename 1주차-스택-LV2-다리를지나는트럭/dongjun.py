def solution(bridge_length, weight, truck_weights):
    #시간초 기록할 변수
    time = 0
    
    #현재 다리를 건너는 트럭의 중량
    nowWeight = 0
    
    #다리에 있는 트럭의 리스트
    bridge_trucks = []
    
    #대기중인 트럭이 없고 트럭이 모두 다리를 건널대까지 반복
    while truck_weights or bridge_trucks:
        
        removeList = []
        
        # 다리의 트럭이 다리를 다 건넜으면
        for i, x in enumerate(bridge_trucks):
            x[1] = x[1] + 1
            if x[1] >= bridge_length:
                nowWeight = nowWeight - x[0]
                removeList.append(i)
                
        #다리를 다 건넌 트럭을 리스트에서 삭제
        while removeList:
            del bridge_trucks[removeList.pop()]

        # 만약 대기트럭의 무게가 다리의 잔여 중량보다 작다면 다리를 건너는 리스트에 트럭 추가
        if truck_weights:
            if truck_weights[0] <= weight - nowWeight:
                bridge_trucks.append([truck_weights[0], 0])
                nowWeight = nowWeight + truck_weights[0]
                del truck_weights[0]
        time = time + 1

    #결과 반환
    answer = time
    return answer




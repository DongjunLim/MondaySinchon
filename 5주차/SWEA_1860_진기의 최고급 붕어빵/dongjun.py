'''
 1. 시간대별 붕어빵 재고를 미리 계산해서 fishBreads 배열에 저장합니다.
 2. 예약손님의 도착시간이 저장된 arrivalTimes 배열을 시간순으로 순회하기 위해 오름차순으로 정렬합니다.
 3. 정렬한 arrivalTimes 배열을 순회하며 방문 시간에 빵이 남았는지 확인합니다.(현재 빵의 재고: fishBreads[now]-sold)
 4. 빵이 없다면 정답변수를 Impossible로 반환하고 반복문을 종료합니다.
 5. 빵이 있다면 sold 변수값을 1 증가시키고 계속 순회합니다.
'''



T = int(input())

for tc in range(1,T+1):

    N, M, K = map(int,input().split())
    arrivalTimes = list(map(int, input().split()))

    last = arrivalTimes[-1]
    sold = 0
    answer = "Possible"
    arrivalTimes.sort()

    fishBreads = [0] * (last+1)

    for i in range(M,last+1):
        if i % M == 0:
            fishBreads[i] = fishBreads[i-M] + K
        else:
            fishBreads[i] = fishBreads[i-1]

    for now in arrivalTimes:
        if fishBreads[now] - sold < 1:
            answer = "Impossible"
            break
        sold += 1


    print(f'#{tc} {answer}')
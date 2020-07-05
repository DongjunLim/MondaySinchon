/*
    큐를 사용해서 주어진 조건 그대로 구현해서 작성했습니다.
    매 시간마다 편지가 도착했는지 확인하고 편지가 도착했으면 우편함(mailBox) 큐에 집어 넣습니다.
    우편함(mailBox)에 가장 오래 있던 편지(queue의 front)가 b시간이 지났거나,
    우편함에 들어있는 편지의 갯수가 a개 이상인지 확인하여, 우편함에서 편지의 절반을 꺼냅니다.
    문제에서 라이브러리 사용이 불가하여 큐를 직접 구현했습니다.
 */



#include <iostream>
using namespace std;

struct queue{
    int data[1001];
    int front = 0;
    int rear = 0;
    int count = 0;
};

int isEmpty(queue* Q){
    return Q->count == 0 ? true : false;
}
void push(queue* Q, int data){
    Q->data[Q->rear++] = data;
    Q->count++;
    return;
}

int pop(queue* Q){
    if(isEmpty(Q))
        return 0;
    int temp = Q->data[Q->front++];
    Q->count--;
    return temp;
}

int front(queue* Q){
    return Q->data[Q->front];
}


queue solution(int n, int a, int b, queue* letters){
    
    // 우편함 큐
    queue mailBox;
    
    // 정답 큐
    queue answer;
    
    // 편지가 1000시간에 도착하고 b가 1000일 경우 2000시간에 편지를 읽을 수 있으니 최대 반복 횟수를 2000으로 설정한다.
    for(int time=1; time<=2000; time++){
        // 대기 편지와 우편함 모두 비어 있으면 처리할 편지가 없는 것이므로 반복 종료.
        if(isEmpty(letters) && isEmpty(&mailBox)) break;
        
        // 대기편지 큐에서 가장 이른 시간대의 편지를 frontLetter에 저장한다.
        int frontLetter = front(letters);
        
        // 꺼낸 편지시간과 현재시간이 일치하면 우편함에 편지를 넣고 대기편지에서 pop 한다.
        if(frontLetter == time){
            push(&mailBox, frontLetter);
            pop(letters);
        }
        
        if(isEmpty(&mailBox)) continue;

        // 우편함에서 가장 오래 있던 편지를 oldLetter에 저장한다.
        int oldLetter = front(&mailBox);
        int mailCnt = mailBox.count;

        // 현재 시간이 가장 오래 있던 편지 + b 시간이거나 우편함이 a보다 같거나 커졌을 때 우편함을 절반 비운다.
        if(oldLetter + b == time || a <= mailCnt){
            int targetCnt = (double)mailCnt/(double)2;

            if(mailCnt%2!=0){
                targetCnt++;
            }
            
            // 우편함을 비우면서 비우는 만큼 정답큐에 현재 시간을 push한다.
            for(int i=0; i<targetCnt; i++){
                push(&answer, time);
                pop(&mailBox);
            }
        }

    }
    
    return answer;
}

int main(){
    int T, tc;
    int N, A, B;
    int letterTime;
    freopen("input.txt","r",stdin);
    cin >> T;
    
    for(tc = 1; tc <= T; tc++){
        cin >> N >> A >> B;
        queue letters;
        for(int i=1; i<=N; i++){
            cin >> letterTime;
            push(&letters, letterTime);
        }
        queue answer = solution(N, A, B, &letters);
        
        cout << "#" << tc << " ";
        while(!isEmpty(&answer)){
            cout << pop(&answer) << " ";
        }
        cout << endl;
    }
    return 0;
}


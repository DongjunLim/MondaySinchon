/*
    ť�� ����ؼ� �־��� ���� �״�� �����ؼ� �ۼ��߽��ϴ�.
    �� �ð����� ������ �����ߴ��� Ȯ���ϰ� ������ ���������� ������(mailBox) ť�� ���� �ֽ��ϴ�.
    ������(mailBox)�� ���� ���� �ִ� ����(queue�� front)�� b�ð��� �����ų�,
    �����Կ� ����ִ� ������ ������ a�� �̻����� Ȯ���Ͽ�, �����Կ��� ������ ������ �����ϴ�.
    �������� ���̺귯�� ����� �Ұ��Ͽ� ť�� ���� �����߽��ϴ�.
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
    
    // ������ ť
    queue mailBox;
    
    // ���� ť
    queue answer;
    
    // ������ 1000�ð��� �����ϰ� b�� 1000�� ��� 2000�ð��� ������ ���� �� ������ �ִ� �ݺ� Ƚ���� 2000���� �����Ѵ�.
    for(int time=1; time<=2000; time++){
        // ��� ������ ������ ��� ��� ������ ó���� ������ ���� ���̹Ƿ� �ݺ� ����.
        if(isEmpty(letters) && isEmpty(&mailBox)) break;
        
        // ������� ť���� ���� �̸� �ð����� ������ frontLetter�� �����Ѵ�.
        int frontLetter = front(letters);
        
        // ���� �����ð��� ����ð��� ��ġ�ϸ� �����Կ� ������ �ְ� ����������� pop �Ѵ�.
        if(frontLetter == time){
            push(&mailBox, frontLetter);
            pop(letters);
        }
        
        if(isEmpty(&mailBox)) continue;

        // �����Կ��� ���� ���� �ִ� ������ oldLetter�� �����Ѵ�.
        int oldLetter = front(&mailBox);
        int mailCnt = mailBox.count;

        // ���� �ð��� ���� ���� �ִ� ���� + b �ð��̰ų� �������� a���� ���ų� Ŀ���� �� �������� ���� ����.
        if(oldLetter + b == time || a <= mailCnt){
            int targetCnt = (double)mailCnt/(double)2;

            if(mailCnt%2!=0){
                targetCnt++;
            }
            
            // �������� ���鼭 ���� ��ŭ ����ť�� ���� �ð��� push�Ѵ�.
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


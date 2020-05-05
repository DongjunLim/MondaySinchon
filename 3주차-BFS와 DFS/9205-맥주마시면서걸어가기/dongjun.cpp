#include <iostream>
#include <vector>
#include <cstring>
#include <queue>
using namespace std;

// 좌표 포인트 구조체
typedef struct point{
    int x;
    int y;
}pnt;

bool visited[102];   // 탐색할때 방문여부를 확인하기 위한 배열


vector<pnt> arr;     // 입력값을 받을 포인트 배열 벡터


// 맨해튼 거리를 계산하기 위한 함수
int getDistance(pnt p1, pnt p2){
    return abs(p1.x - p2.x) + abs(p1.y - p2.y);
}

// 맥주가 떨어지기 전에 도착지에 도착할 수 있는지 탐색하는 bfs 함수
void bfs(){
    // 방문표시 초기화
    memset(visited,false,sizeof(visited));
    queue<pnt> Q;    // 작업 큐 선언
    Q.push(arr[0]);  // 출발지 좌표 작업큐에 삽입
    visited[0] = true;  // 출발지 방문 표시
    
    // 넓이 우선 탐색 시작
    while(!Q.empty()){
        pnt now = Q.front();  // 현재 좌표를 작업큐에서 꺼냄

        Q.pop();             // pop
        
        // 입력 배열 전체 탐색
        for(int i=0; i<arr.size(); i++){
            
            // 좌표 i가 현재좌표 now와 맨해튼 거리가 1000이하면서 방문하지 않았을 때
            if(getDistance(now, arr[i]) < 1001 and !visited[i]){
                
                // 좌표 i가 도착좌표면 happy 출력하고 함수 종료
                if(i==arr.size()-1){
                    cout << "happy" << endl;
                    return;
                }
                
                // 도착지가 아니면 방문표시를 한 후 작업큐에 좌표 입력
                visited[i] = true;
                Q.push(arr[i]);
            }
        }
    }
    // happy에 도달하지 못했으면 sad를 출력하고 함수 종료
    cout << "sad" <<endl;
}

int main(){
    int n;
    int T;
    
    cin >> T;
    
    // 좌표를 입력받을 pnt 구조체 변수
    pnt p;
    
    // 테스트 케이스 만큼 반복
    for(int tc = 0; tc<T; tc++){
        // 입력 배열 초기화
        arr.clear();
        cin >> n;
        cin >> p.x >> p.y;
        
        // 좌표 입력 받음
        for(int i=0; i<n+2; i++){
            cin >> p.x >> p.y;
            arr.push_back(p);
        }
        
        // 탐색 시작
        bfs();
    }
    return 0;
}


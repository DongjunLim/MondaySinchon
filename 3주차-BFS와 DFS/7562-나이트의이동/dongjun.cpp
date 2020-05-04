#include <iostream>
#include <vector>
#include <cstdlib>
#include <queue>
using namespace std;

bool board[300][300];   // 좌표를 방문했는지 확인하기 위한 2차원 배열


int DP[300][300];   // 좌표의 뎁스를 저장하기 위한 2차원 배열

// 시작좌표와 종료좌표
int startX, startY, endX, endY;

int l;  // 보드판 길이

// 좌표값 저장을 위한 구조체
struct point
{
    int x;
    int y;
};

// 나이트의 이동방향
point pnt[8] = { {-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1} };


// 보드판
bool isPlay(int row, int col){
    if(row < 0 || l <= row || col < 0 || l <= col)
        return false;
    if(board[row][col])
        return false;
    
    return true;
}

// 배열 초기화 함수
void setDP(){
    for(int i=0; i<300; i++){
        for(int j=0; j<300; j++){
            DP[i][j] = 999999999;
            board[i][j] = false;
        }
    }
}

int bfs(int idx, int row, int col){
    
    // 시작 전 배열 초기화
    setDP();
    
    // 작업큐 선언
    queue<pair<int,int>> waiting;
    
    // x,y 좌표를 담을 pair 변수 선언
    pair<int, int> nowPoint;
    
    // 현재 좌표 작업큐에 푸시
    waiting.push(make_pair(row, col));
    
    // 현재 좌표 방문표시
    board[row][col] = true;
    
    // 현재 좌표 깊이표시
    DP[row][col] = 0;
    
    while(!waiting.empty()){
        
        // 작업큐에서 좌표 데이터 가져옴
        nowPoint = waiting.front();
        waiting.pop();
        
        // 작업좌표가 종료좌표와 일치하면 좌표깊이값 반환
        if(nowPoint.first == endX && nowPoint.second == endY){
            return DP[nowPoint.first][nowPoint.second];
        }
        
        
        // 나이트의 8방향 이동경로 탐색
        for(int i=0; i<8; i++){
            
            // 탐색할 좌표
            int x= nowPoint.first+pnt[i].x, y = nowPoint.second+pnt[i].y;
            
            // 좌표가 탐색 가능한지 확인
            if(isPlay(x, y)){
                
                // 깊이 갱신
                DP[x][y] = min(DP[x][y],DP[nowPoint.first][nowPoint.second] + 1);
                
                // 탐색 좌표 방문 표시
                board[x][y] = true;
                
                // 작업큐에 탐색 좌표 푸시
                waiting.push(make_pair(x, y));
            }
        }
    }
    return 0;
}


int main(){
    int T;
    freopen("input.txt","r",stdin);
    cin >> T;
    
    for(int tc = 0; tc<T; tc++){
        cin >> l;
        cin >> startX >> startY;
        cin >> endX >> endY;
                
        // bfs 결과 출력
        cout << bfs(0,startX,startY) << endl;
        
    }
    

    return 0;
}


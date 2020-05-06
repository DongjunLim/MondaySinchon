#include <iostream>
#include <vector>
#include <cstdlib>
#include <string.h>
using namespace std;

// 일반인 맵
char normalArr[102][102];

// 적록색약 맵
char colorBlindArr[102][102];

// 일반인 맵 방문 기록
bool normal[102][102];

// 적록색약 맵 방문 기록
bool colorBlind[102][102];

// 일반인 맵 영역 카운트
int normalCnt = 0;

// 적록색약 맵 영역 카운트
int colorBlindCnt = 0;

// 좌표 구조체 구현
struct point{
    int x;
    int y;
};

// 상하좌우 좌표배열
point pnt[4] = {{-1,0}, {0,-1}, {1,0}, {0, 1}};

// 연결된 같은 영역을 탐색하며 방문기록을 저장하는 dfs 함수
void dfs(char (*arr)[102], bool (*board)[102],int row, int col){
    int x, y;
    
    char color = arr[row][col];
    
    // 방문 표시
    board[row][col] = true;
    
    // 현 좌표 기준 상하좌우 연결된 같은 색상이 있는지 탐색
    for(int i=0; i<4; i++){
        x = row + pnt[i].x;
        y = col + pnt[i].y;
        if(arr[x][y] == color && board[x][y] == false){
            dfs(arr,board,x,y);
        }
    }
}

int main(){
    freopen("input.txt","r",stdin);
    
    int N;
    cin >> N;

    for(int i=1; i<= N; i++){
        for(int j=1; j<= N; j++){
            cin >> normalArr[i][j];
            
            // 적록색약 맵은 G를 R로 바꿔 입력한다.
            if(normalArr[i][j] == 'G'){
                colorBlindArr[i][j] = 'R';
            } else{
                colorBlindArr[i][j] = normalArr[i][j];
            }
        }
    }
    
    // 배열을 순회하며 일반인 영역탐색
    for(int i=1; i<=N; i++){
        for(int j=1; j<=N; j++){
            // 탐색이 안되어있으면 연결영역 전체 탐색
            if(!normal[i][j]){
                dfs(normalArr,normal,i,j);
                // 영역 카운트 증가
                normalCnt++;
            }
        }
    }
    
    // 배열을 순회하며 적록색약 영역탐색
    for(int i=1; i<=N; i++){
        for(int j=1; j<=N; j++){
            // 탐색이 안되어있으면 연결영역 전체 탐색
            if(!colorBlind[i][j]){
                dfs(colorBlindArr,colorBlind,i,j);
                // 영역 카운트 증가
                colorBlindCnt++;
            }
        }
    }
    
    // 결과 출력
    cout << normalCnt << " " << colorBlindCnt;
    
    return 0;
}


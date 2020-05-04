#include <iostream>
#include <vector>
#include <cstdlib>
#include <string.h>
using namespace std;

// 입력을 받을 배열
int arr[102][102];

// 탐색여부를 확인할 배열
bool visited[102][102];

// 물에 잠길 수 있는 최소치를 담을 변수
int mn = 101;

// 모든 영역이 물에 잠길 수 있는 최대치를 담을 변수
int mx = 0;

// 영역 갯수를 카운트할 변수
int cnt = 0;

// 최대 영역 갯수를 담을 변수, 모든 영역이 물에 잠기지 않을 수 있으니 최소값으로 1을 설정한다.
int answer = 1;

// 좌표값 구조체
struct point{
    int x;
    int y;
};

// 상하좌우 이동에 사용될 4방향 구조체 배열
point pnt[4] = {{-1,0},{0,-1},{1,0},{0,1}};

// 물에 잠기지 않는 연결된 영역을 탐색하는 dfs 함수
void dfs(int row, int col, int rain){
    
    // 방문 표시
    visited[row][col] = true;
    
    // 4방향 순회
    for(int i=0; i<4; i++){
        int x = row + pnt[i].x;
        int y = col + pnt[i].y;
        
        // arr[x][y]가 잠기지 않으면서 동시에 방문을 안했으면 깊이 들어감
        if(arr[x][y] > rain && visited[x][y] == false){
            dfs(x,y,rain);
        }
    }
}

// DP 배열 초기화 함수
void initVisitedArr(){
    for(int i=0; i<102; i++){
        for(int j=0; j<102; j++)
            visited[i][j] = false;
    }
    return;
}


int main(){
    freopen("input.txt","r",stdin);
    
    int N;
    cin >> N;
    
    // 2차원 배열 입력받음. 가장 큰 값을 mx에, 가장 작은 값을 mn에 담음
    for(int i=1; i<=N; i++){
        for(int j=1; j<=N; j++){
            cin >> arr[i][j];
            if(mn > arr[i][j])
                mn = arr[i][j];
            if(mx < arr[i][j])
                mx = arr[i][j];
        }
    }
    
    // 비의 양을 최소부터 최대까지 증가시키며 반복
    for(int i = mn; i <= mx; i++){
        
        // DP 초기화
        initVisitedArr();
        
        // 영역갯수 초기화
        cnt = 0;
        
        // 입력배열 순회
        for(int j = 1; j <= N; j++){
            for(int k = 1; k<=N; k++){
                // 방문하지 않았으며 물에 잠기지 않을때 영역 갯수를 증가시키고 방문표시를 하기 위해 dfs를 호출한다.
                if(!visited[j][k] && arr[j][k] > i){
                    dfs(j,k,i);
                    cnt++;
                }
            }
        }
        
        // 이전에 구한 최대영역보다 크면 answer 갱신
        if(answer < cnt)
            answer = cnt;
    }
    
    // 결과 출력
    cout << answer;

    return 0;
}


#include <iostream>
#include <vector>
#include <queue>
using namespace std;

// 인접리스트(?) 선언. g의 인덱스 = 컴퓨터 번호, 값인 큐의 데이터 = 해당 컴퓨터에 연결된 컴퓨터 번호
vector<queue<int>> g;

// 몇개가 연결됐는지 카운트
int cnt = 0;

// 해당 컴퓨터를 탐색했는지 확인하는 DP 배열
bool visited[101];

// T = 컴퓨터의 수, N = 연결 관계의 수
int T, N;

// 매개변수 idx = 컴퓨터 번호, 해당 컴퓨터에 몇개의 컴퓨터가 연결됐는지 탐색하는 dfs 함수
void dfs(int idx){
    // idx가 컴퓨터 번호를 초과하면 return;
    if(idx > T) return;
    
    // 호출됐으면 해당 컴퓨터 방문표시
    visited[idx] = true;
    
    // 해당 컴퓨터에 연결된 컴퓨터를 모두 확인할때까지 반복
    while(!g[idx].empty()){
        
        // 해당 컴퓨터와 연결된 타겟 컴퓨터를 큐에서 하나 빼 온다.
        int target = g[idx].front();
        g[idx].pop();
        
        // 연결된 컴퓨터를 탐색하지 않았으면 카운트를 증가시키고 재귀호출
        if(!visited[target]){
            cnt++;
            dfs(target);
        }
    }
    return;
}

int main(){
    freopen("input.txt", "r", stdin);
    
    // x , y = 컴퓨터 간 연결관계를 입력 받을 변수
    int x, y;
    
    // 컴퓨터 수와 관계의 수를 입력받음
    cin >> T >> N;
    
    // 컴퓨터의 수만큼 인접리스트 크기 초기화
    for(int i=1; i<=T+1; i++){
        queue<int> t;
        g.push_back(t);
    }
    
    // 입력받은 관계를 바탕으로 인접리스트에 데이터 입력
    for(int i=0; i< N; i++){
        cin >> x >> y;
        g[x].push(y);
        g[y].push(x);
    }
    
    // 1번 컴퓨터부터 탐색 시작
    dfs(1);
    
    // 결과 출력
    cout << cnt;

    return 0;
}


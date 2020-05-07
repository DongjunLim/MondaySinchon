#include <iostream>
#include <vector>
#include <queue>
using namespace std;

// 인접리스트 생성
vector<queue<int>> arr;

// 방문 여부를 체크할 배열
bool visited[1001];

// 정답 갯수
int cnt = 0;

// 번호 idx 와 연결된 모든 노드를 true로 체크하기 위한 dfs 함수
void dfs(int idx){
    // idx 방문표시
    visited[idx] = true;
    
    // idx와 연결된 모든 노드를 확인
    while(!arr[idx].empty()){
        int target = arr[idx].front();
        arr[idx].pop();
        
        // idx와 연결된 노드를 방문하지 않았다면 dfs를 재귀호출해 target 노드와 연결된 다른 노드들도 모두 방문 표시
        if(!visited[target]){
            dfs(target);
        }
    }
}


int main(){
    freopen("input.txt", "r", stdin);
    
    int N, M;
    int x, y;
    cin >> N >> M;
    
    // 인접리스트 사이즈 생성
    for(int i=0; i<=N; i++){
        queue<int> list;
        arr.push_back(list);
    }
    
    // 입력 데이터로 인접리스트 초기화
    for(int i = 0; i< M; i++){
        cin >> x >> y;
        arr[x].push(y);
        arr[y].push(x);
    }
    
    // 노드의 갯수만큼 반복
    for(int i=1; i<=N; i++){
        // 노드를 방문하지 않았다면 정답을 증가시키고 해당 노드와 연결된 모든 노드를 방문한다.
        if(!visited[i]){
            cnt ++;
            dfs(i);
            
        }
    }
    
    // 결과 출력
    cout << cnt << endl;

    return 0;
}


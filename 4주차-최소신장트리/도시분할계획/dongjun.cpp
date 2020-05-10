#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
using namespace std;
#define INF 99999999
int maxWeight = -9999999;
int edgeCnt = 0;

// 간선 정보를 저장할 구조체
struct edge{
    int u;
    int v;
    int w;
};

// 입력된 전체 간선 정보를 저장할 배열
vector<edge> edgeList;

// 연결된 노드의 집합에서 대표노드를 찾기 위해 사용되는 배열
int parent[100001];

// 노드가 속한 집합에서 대표노드를 찾기 위한 함수
int findSet(int x){
    if(parent[x] < 0)   return x;
    return parent[x] = findSet(parent[x]);
}

// 집합 초기화
void makeSet(int x){
    parent[x] = -1;
    return;
}

// 집합끼리 연결하는 함수
int unionSet(int u, int v){
    int first = findSet(u);
    int second = findSet(v);
    if(first == second) return false;
    else{
        parent[first] += parent[second];
        parent[second] = first;
    }
    return true;
}

// 크루스칼 알고리즘으로 최소신장 트리를 만든다.
int kruskal(int n){
    int sz = int(edgeList.size());
    int cnt = 0;
    for(int i=0; i < sz; i++){
        if(unionSet(edgeList[i].u, edgeList[i].v)){
            edgeCnt++;
            cnt += edgeList[i].w;
            
            // 최소신장트리가 완성되면 연결된 간선 중 가중치가 가장 큰 간선을 제거하고 리턴한다.
            // 제거하는 이유는 마을을 두개로 분리해야 하기 때문
            if(edgeCnt == n-1)  {
                maxWeight = edgeList[i].w;
                return cnt;
            }
        }
    }
    return cnt;
}
// 간선의 가중치로 정렬하기 위한 조건
bool cmp(const edge &a, const edge &b){
    return a.w < b.w ? true : false;
}


int main(){
    freopen("input.txt","r",stdin);
    int N, M;
    cin >> N >> M;
    edge t;
    
    for(int i=1; i <= N; i++){
        makeSet(i);
    }
    for(int i=0; i< M; i++){
        cin >> t.u >> t.v >> t.w;
        edgeList.push_back(t);
    }
    
    // 간선의 가중치로 간선들을 오름차순으로 정렬한다.
    sort(edgeList.begin(),edgeList.end(),cmp);
    
    // 결과 출력
    cout << kruskal(N)-maxWeight << endl;
}


#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
#include <cmath>
#include <cstring>
using namespace std;

// 간선 정보를 담을 배열 선언
typedef struct Edge{
    int u;
    int v;
    int w;
}edge;

// 입력간선을 받을 edge 배열 선언
vector<edge> edgeList;

// 연결된 노드의 집합을 표현할 배열 선언
int parent[200001];

// 집합 초기화 함수
void makeSet(int n){
    parent[n] = -1;
    return;
}

// 집합의 대표노드를 찾는 함수
int findSet(int n){
    if(parent[n] < 0)   return n;
    return parent[n] = findSet(parent[n]);
}

// 두 집합을 합치는 함수
int unionSet(int u, int v){
    int uSet = findSet(u);
    int vSet = findSet(v);
    if(uSet == vSet) return -1;
    
    parent[vSet] = uSet;
    return -parent[uSet];
}

// 최소비용을으로 마을을 연결하기 위한 크루스칼 알고리즘
long long kruskal(int m){
    int sz = int(edgeList.size());
    long long cost = 0; // 최소비용의 누적합
    int edgeCount = 0;
    
    for(int i=0; i<sz; i++){
        
        // u와 v가 연결되어 있지 않았으면 연결
        if(unionSet(edgeList[i].u, edgeList[i].v) > 0){
            cost += edgeList[i].w;      // 누적합에 현재 간선 가중치 더함
            if(++edgeCount == m-1)      // 연결간선이 노드 갯수-1 이면 연결간선의 누적합을 반환
                return cost;
        }
    }
    
    return 0;
}


bool cmp(const edge &a, const edge &b){
    return a.w < b.w ? true : false;
}

int main(){
    int n,m;
    // 전체 간선의 합을 구한다.
    int maxCount = 0;
    edge temp;
    
    while(cin >> m >> n){
        // 입력이 0 0 이면 종료
        if(m == 0 and n == 0)   break;
        edgeList.clear();
        maxCount = 0;
        
        for(int i=0; i<n; i++){
            cin >> temp.u >> temp.v >> temp.w;
            maxCount += temp.w;
            edgeList.push_back(temp);
            makeSet(i);
        }
        
        // 간선을 가중치를 기준으로 오름차순 정렬
        sort(edgeList.begin(), edgeList.end(),cmp);
        
        // 최대 절약비용 = 모든 간선의 합 - 최소비용 신장트리의 합
        cout << maxCount - kruskal(m) << endl;  // 결과 출력
    }
}


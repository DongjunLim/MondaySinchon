//
//  9205_js.cpp
//  Algo
//
//  Created by Jisus on 2020/05/04.
//  Copyright © 2020 Jisus. All rights reserved.
//

#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

typedef struct{
    int x,y;
} dim;


vector<bool> visited; // 방문 여부를 저장하는 배열

class Graph {
public:
    int N; // 정점의 개수
    vector<vector<int>> adj; // 인접 리스트
    int count;

    // 생성자
    Graph() : N(0) {}
    Graph(int n) : N(n + 1) {
        adj.resize(N + 1);
        visited.resize(N + 1);
        fill(visited.begin(), visited.end(), false);
        count = 0;
    }

    // 간선 추가 함수
    void addEdge(int u, int v) {
        adj[u].push_back(v);
        adj[v].push_back(u);
        //cout << "(" << u << "," << v << ")";
    }
    
    int chk_distance(dim a_pos, dim b_pos){
        return abs(a_pos.x-b_pos.x) + abs(a_pos.y-b_pos.y);
    }

    void dfs(int curr) {

        visited[curr] = true;
        //cout << curr << " " ;
        for (int next : adj[curr])
            if (!visited[next]) {
                dfs(next);
                count++;
            }
    }


private:

};




int main() {
    
    int t, n;
    dim temp_input;
    vector<dim> temp;
    //
    cin >> t;
    
    
    while (t--) {
        
        // 편의점 갯수 입력
        cin >> n;
        
        // 초기화
        Graph board(n+2);
        temp.assign(n,{0,0});
        
        // 편의점 좌표 입력
        for (int i = 0; i < n+2; i++){
            cin >> temp_input.x >> temp_input.y;
            temp.push_back(temp_input);
        }
        
        // 간선을 하나씩 추가한다.
        for (int i = 0; i < n+2; i++)
            for (int j=i+1; j < n+2; j++){
                // 맥주를 다 마시기 전에 도착할 수 있는 노드라면 추가한다.
                if (board.chk_distance(temp[i], temp[j])<=1000)
                    board.addEdge(i, j);
            }
        
        // 0 -> n+1 까지 탐색한다.
        board.dfs(0);
        
        // 페스티벌에 방문했다면 happy
        if (visited[n+1])
            cout << "happy" << endl;
        else
            cout << "sad" << endl;
    }
    return 0;
}

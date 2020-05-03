#include <iostream>
#include <vector>

using namespace std;


vector<bool> visited; // 방문 여부를 저장하는 배열


class Graph {
public:
	int N; // 정점의 개수
	vector<vector<int>> adj; // 인접 리스트	
	//int count;

	// 생성자
	Graph() : N(0) {}
	Graph(int n) : N(n + 1) {
		adj.resize(N + 1);
		visited.resize(N + 1);
		fill(visited.begin(), visited.end(), false);
		//count = 0;
	}

	// 간선 추가 함수
	void addEdge(int u, int v) {
		adj[u].push_back(v);
		adj[v].push_back(u);
		//cout << "(" << u << "," << v << ")";
	}

	void dfs(int curr) {
		visited[curr] = true;
		//cout << curr << " " ;
		for (int next : adj[curr])
			if (!visited[next]) {
				dfs(next);
				//count++;
			}
	}


private:

};


int main(void) {
	int N, node, L, R, ans = 0;
	cin >> N;
	Graph G(N);
	cin >> node;

	// 간선을 하나씩 추가한다.
	for (int i = 0; i < node; i++) {
		cin >> L >> R;
		G.addEdge(L, R);
	}
	// 간선 수만큼 연결 요소를 찾는다
	for (int i = 1; i <= N; i++) {
		if (visited[i] == false) {
			ans++;
			G.dfs(i);
		}
	}
	cout << ans;
	return 0;
}
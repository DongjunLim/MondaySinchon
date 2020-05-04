#include <iostream>
#include <vector>

using namespace std;


vector<bool> visited; // �湮 ���θ� �����ϴ� �迭


class Graph {
public:
	int N; // ������ ����
	vector<vector<int>> adj; // ���� ����Ʈ	
	//int count;

	// ������
	Graph() : N(0) {}
	Graph(int n) : N(n + 1) {
		adj.resize(N + 1);
		visited.resize(N + 1);
		fill(visited.begin(), visited.end(), false);
		//count = 0;
	}

	// ���� �߰� �Լ�
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

	// ������ �ϳ��� �߰��Ѵ�.
	for (int i = 0; i < node; i++) {
		cin >> L >> R;
		G.addEdge(L, R);
	}
	// ���� ����ŭ ���� ��Ҹ� ã�´�
	for (int i = 1; i <= N; i++) {
		if (visited[i] == false) {
			ans++;
			G.dfs(i);
		}
	}
	cout << ans;
	return 0;
}
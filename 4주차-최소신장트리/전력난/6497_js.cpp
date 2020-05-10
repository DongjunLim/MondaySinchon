#include <iostream>
#include <algorithm>
#include <vector>


using namespace std;

// 그래프의 간선정보를 입력 받음
struct node
{
	int from, to, cost;

};

// union find 용 계산 배열
int Union[200001] = { 0, };

// 유니온 '파인드' 
int find(int n)
{
	if (Union[n] == n) return n;
	return Union[n] = find(Union[n]);
}

bool is_large(node x, node y)
{
	return x.cost < y.cost;
}

int main()
{
	int N, M, temp_x, temp_y, total, result;
	while (true) {
		total = 0;
		result = 0;
		// 도로 그래프 정보 벡터
		vector<node> road;

		cin >> N >> M;
		// 둘다 0 일 경우 종료
		if (N == 0 && M == 0) break;

		for (int i = 0; i <= N; i++)
			Union[i] = i;

		// 간선 정보 저장
		for (int i = 0; i < M; i++) {
			node temp_node;
			cin >> temp_node.from >> temp_node.to >> temp_node.cost;
			road.push_back(temp_node);
			total += temp_node.cost;
		}

		// 순회를 위해 정렬한다.
		sort(road.begin(), road.begin() + M, is_large);

		// '유니온' 파인드 
		for (int i = 0; i < M; i++)
		{
			temp_x = find(road[i].from);
			temp_y = find(road[i].to);

			if (temp_x == temp_y) continue;

			Union[temp_x] = temp_y;

			result += road[i].cost;
		}

		cout << total - result << '\n';
	}

	return 0;
}

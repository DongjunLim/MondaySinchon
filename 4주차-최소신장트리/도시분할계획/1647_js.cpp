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
int Union[100001] = { 0, };

// 도시 그래프 정보 벡터
vector<node> city;

// 유니온 '파인드' 
int find(int n)
{
	if (Union[n] == 0) return n;
	return Union[n] = find(Union[n]);
}

bool is_large(node x, node y)
{
	return x.cost < y.cost;
}


int main()
{
	int N, M, temp_x, temp_y, last, result = 0;

	cin >> N >> M;

	// 간선 정보 저장
	for (int i = 0; i < M; i++) {
		node temp_node;
		cin >> temp_node.from >> temp_node.to >> temp_node.cost;
		city.push_back(temp_node);
	}

	// 순회를 위해 정렬한다.
	sort(city.begin(), city.begin() + M, is_large);


	// '유니온' 파인드 
	for (int i = 0; i < M; i++)
	{
		temp_x = find(city[i].from);
		temp_y = find(city[i].to);

		if (temp_x == temp_y) continue;

		Union[temp_y] = temp_x;

		result += city[i].cost;
		last = city[i].cost;

	}

	cout << result - last << '\n';

	return 0;
}

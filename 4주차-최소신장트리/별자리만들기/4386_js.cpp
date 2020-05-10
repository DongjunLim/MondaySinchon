#include <iostream>
#include <algorithm>
#include <cmath>
#include <vector>

using namespace std;

// 그래프의 간선 정보를 입력 받음
struct node
{
	double from, to, cost;
};

// union find 용 계산 배열
int Union[100001] = { 0, };

// 2차원 기록용 벡터
vector<node> pos;
// 그래프 저장 벡터
vector<node> dist;

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

void get_distance(int M) {
	for (int i = 0; i < M; i++)
	{
		double x1 = pos[i].from;
		double y1 = pos[i].to;

		for (int j = i + 1; j < M; j++)
		{
			node temp;
			double x2 = pos[j].from;
			double y2 = pos[j].to;

			temp = { (double)i,(double)j, sqrt(pow((x1 - x2),2) + pow((y1 - y2),2)) };
			
			dist.push_back(temp);
			
		}
	}
}

int main()
{
	int M, temp_x, temp_y; 
	double result = 0;

	// 출력 자리수 제한
	cout.precision(3);

	cin >> M;

	// 간선 정보 저장
	for (int i = 0; i < M; i++) {
		node temp_node;
		cin >> temp_node.from >> temp_node.to;
		temp_node.cost = 0;
		pos.push_back(temp_node);
	}

	for (int i = 0; i < M; i++)
		Union[i] = i;

	// 입력받은 2차원 값으로부터 거리를 구하고 간선을 제작
	// 이 때, 간선의 갯수는 M이 아님에 주의한다.  
	get_distance(M);

	// 순회를 위해 정렬한다.
	sort(dist.begin(), dist.end() , is_large);

	// '유니온' 파인드 
	for (int i = 0; i < dist.size() ; i++)
	{
		temp_x = find(dist[i].from);
		temp_y = find(dist[i].to);

		if (temp_x == temp_y) continue;

		Union[temp_y] = temp_x;

		result += dist[i].cost;

	}

	cout << result << '\n';
	return 0;
}

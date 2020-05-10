#include <iostream>
#include <algorithm>
#include <vector>


using namespace std;

// �׷����� ���������� �Է� ����
struct node
{
	int from, to, cost;

};

// union find �� ��� �迭
int Union[200001] = { 0, };

// ���Ͽ� '���ε�' 
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
		// ���� �׷��� ���� ����
		vector<node> road;

		cin >> N >> M;
		// �Ѵ� 0 �� ��� ����
		if (N == 0 && M == 0) break;

		for (int i = 0; i <= N; i++)
			Union[i] = i;

		// ���� ���� ����
		for (int i = 0; i < M; i++) {
			node temp_node;
			cin >> temp_node.from >> temp_node.to >> temp_node.cost;
			road.push_back(temp_node);
			total += temp_node.cost;
		}

		// ��ȸ�� ���� �����Ѵ�.
		sort(road.begin(), road.begin() + M, is_large);

		// '���Ͽ�' ���ε� 
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

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
int Union[100001] = { 0, };

// ���� �׷��� ���� ����
vector<node> city;

// ���Ͽ� '���ε�' 
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

	// ���� ���� ����
	for (int i = 0; i < M; i++) {
		node temp_node;
		cin >> temp_node.from >> temp_node.to >> temp_node.cost;
		city.push_back(temp_node);
	}

	// ��ȸ�� ���� �����Ѵ�.
	sort(city.begin(), city.begin() + M, is_large);


	// '���Ͽ�' ���ε� 
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

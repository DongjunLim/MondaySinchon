#include <iostream>
#include <algorithm>
#include <cmath>
#include <vector>

using namespace std;

// �׷����� ���� ������ �Է� ����
struct node
{
	double from, to, cost;
};

// union find �� ��� �迭
int Union[100001] = { 0, };

// 2���� ��Ͽ� ����
vector<node> pos;
// �׷��� ���� ����
vector<node> dist;

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

	// ��� �ڸ��� ����
	cout.precision(3);

	cin >> M;

	// ���� ���� ����
	for (int i = 0; i < M; i++) {
		node temp_node;
		cin >> temp_node.from >> temp_node.to;
		temp_node.cost = 0;
		pos.push_back(temp_node);
	}

	for (int i = 0; i < M; i++)
		Union[i] = i;

	// �Է¹��� 2���� �����κ��� �Ÿ��� ���ϰ� ������ ����
	// �� ��, ������ ������ M�� �ƴԿ� �����Ѵ�.  
	get_distance(M);

	// ��ȸ�� ���� �����Ѵ�.
	sort(dist.begin(), dist.end() , is_large);

	// '���Ͽ�' ���ε� 
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

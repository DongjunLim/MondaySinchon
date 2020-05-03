
#include <iostream>

using namespace std;
// ������ ������ ���ڸ� ���� �迭
int input_num[14];
// ����� ������ �迭
int result[6];
// K����ŭ�� ��� ���
int K;

void dfs(int start = 0, int count = 0)
{
	// count�� 6�� �Ǹ� ��� ���
	if (count == 6)
	{
		for (int i = 0; i < 6; i++)
		{
			cout << result[i] << " ";
		}
		cout << "\n";
	}
	else
	{
		// dfs�� ���� ���ڸ��� ���� �� �ݺ� �Ҵ�
		for (int i = start; i < K; i++)
		{
			result[count] = input_num[i];
			dfs(i + 1, count + 1);
		}

	}
}

int main() {

	while (true) {
		// �� ���� �Է�
		cin >> K;
		// 0�� �ԷµǸ� ����
		if (K == 0)
			break;
		// ������ �� �Է�
		for (int i = 0; i < K; i++)
			cin >> input_num[i];
		// dfs�� ���� ����
		dfs();
		// ��ĭ ���
		cout << "\n";
	}
}
#include <iostream>
#include <string>

using namespace std;

int main() {
	int end = 666;
	int N;
	cin >> N;
	int end_count = 0;
	string target;
	//���ڿ��� �ٲٰ� ���ӵ� 666 üũ�ϸ� break�� ��ŵ�Ѵ�.
	while (true)
	{
		target = to_string(end);
		for (int j = 0; j < target.length() - 2; j++)
			if (target[j] == '6' && target[j + 1] == '6' && target[j + 2] == '6')
			{
				end_count++;
				if (end_count == N) {
					cout << end;
					return 0;
				}
				// 6661666 ��� ���� �ݷʸ� �ذ��ϱ� ���� ����.
				break;
			}
		end++;
	}
}
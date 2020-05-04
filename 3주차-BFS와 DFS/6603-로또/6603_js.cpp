
#include <iostream>

using namespace std;
// 조합이 가능한 숫자를 받을 배열
int input_num[14];
// 결과를 저장할 배열
int result[6];
// K개만큼의 결과 출력
int K;

void dfs(int start = 0, int count = 0)
{
	// count가 6이 되면 결과 출력
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
		// dfs를 통해 한자리씩 저장 후 반복 할당
		for (int i = start; i < K; i++)
		{
			result[count] = input_num[i];
			dfs(i + 1, count + 1);
		}

	}
}

int main() {

	while (true) {
		// 수 개수 입력
		cin >> K;
		// 0이 입력되면 종료
		if (K == 0)
			break;
		// 조합할 수 입력
		for (int i = 0; i < K; i++)
			cin >> input_num[i];
		// dfs를 통해 구현
		dfs();
		// 한칸 띄기
		cout << "\n";
	}
}
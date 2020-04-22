#include <iostream>
#include <string>

using namespace std;

int main() {
	int end = 666;
	int N;
	cin >> N;
	int end_count = 0;
	string target;
	//문자열로 바꾸고 연속된 666 체크하면 break로 스킵한다.
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
				// 6661666 등과 같은 반례를 해결하기 위해 적용.
				break;
			}
		end++;
	}
}
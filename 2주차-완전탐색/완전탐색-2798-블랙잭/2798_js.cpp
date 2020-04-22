#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int N, M, result=123456789;
vector<int> card, sum_vec;

void blackjack(int count = -1, int num_true = -1, int rec_tf = -1) {

	// 3장이 모두 선택되었으면 더하고 최소 값과 비교한다.
	if (num_true == 3) {
		for (int i = 0; i < 3; i++) sum_vec[3] += sum_vec[i];
		// M을 넘지않는 최대 수이므로 계산 후 result를 갱신한다.
		if (sum_vec[3] <= M) result = min(result, abs(sum_vec[3] - M));
		sum_vec[3] = 0;
		return;
	}

	//N 장까지 진행했을 경우 종료
	if (count == N) return;

	// 카드를 선택하기로 했을 경우 sum_vec 카드 저장
	if (rec_tf == 1) sum_vec[num_true] = card[count];



	// count + 1 카드 O
	blackjack(count + 1, num_true + 1, 1);

	// count + 1 카드 X
	blackjack(count + 1, num_true, 0);

}

int main(void) {
	cin >> N >> M;

	// vector 초기화 
	card.assign(N,0);
	sum_vec.assign(4,0);

	// card 값 저장
	for (int i = 0; i < N; i++)
		cin >> card[i];

	// 재귀로 구현
	blackjack();

	// 계산된 결과 출력
	cout << M-result << "\n";
	return 0;
}
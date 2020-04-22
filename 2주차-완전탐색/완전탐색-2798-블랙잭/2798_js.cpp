#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int N, M, result=123456789;
vector<int> card, sum_vec;

void blackjack(int count = -1, int num_true = -1, int rec_tf = -1) {

	// 3���� ��� ���õǾ����� ���ϰ� �ּ� ���� ���Ѵ�.
	if (num_true == 3) {
		for (int i = 0; i < 3; i++) sum_vec[3] += sum_vec[i];
		// M�� �����ʴ� �ִ� ���̹Ƿ� ��� �� result�� �����Ѵ�.
		if (sum_vec[3] <= M) result = min(result, abs(sum_vec[3] - M));
		sum_vec[3] = 0;
		return;
	}

	//N ����� �������� ��� ����
	if (count == N) return;

	// ī�带 �����ϱ�� ���� ��� sum_vec ī�� ����
	if (rec_tf == 1) sum_vec[num_true] = card[count];



	// count + 1 ī�� O
	blackjack(count + 1, num_true + 1, 1);

	// count + 1 ī�� X
	blackjack(count + 1, num_true, 0);

}

int main(void) {
	cin >> N >> M;

	// vector �ʱ�ȭ 
	card.assign(N,0);
	sum_vec.assign(4,0);

	// card �� ����
	for (int i = 0; i < N; i++)
		cin >> card[i];

	// ��ͷ� ����
	blackjack();

	// ���� ��� ���
	cout << M-result << "\n";
	return 0;
}
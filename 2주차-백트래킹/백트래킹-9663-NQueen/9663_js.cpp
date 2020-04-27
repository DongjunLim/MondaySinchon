#include <iostream>
#include <vector>

#define MAX_SIZE 15

using namespace std;


vector<int> chess_board;
int result = 0;

bool chk_now_queen(int t_height) {
	// ����, �밢���� ���� ��ġ�ߴ��� Ȯ��
	for (int i_height = 1; i_height < t_height; i_height++) {
		// ���ο� ��ġ�ϴ��� Ȯ��
		if (chess_board[i_height] == chess_board[t_height]) 
			return 0;
		// �밢���� ��ġ�ϴ��� Ȯ��
		else if (abs(chess_board[i_height] - chess_board[t_height]) == abs(i_height - t_height)) 
			return 0;
	}
	return 1;
}


void chk_board(int now_queen_height, int max_width) {
	// ��� ���� ��ġ�� ��� ��� ���� �ϳ� �ø���.
	if (now_queen_height == max_width-1) {
		result++;
	}
	else {
		for (int i_width = 1; i_width < max_width; i_width++) {
			// �̸� ���Ƿ� ��ġ��Ų��.
			chess_board[now_queen_height+1] = i_width;
			// ��ġ�� �ùٸ��� Ȯ���Ѵ�.
			if (chk_now_queen(now_queen_height+1)) {
				// ���� ��ġ ���� ���
				chk_board(now_queen_height + 1, max_width);
			}
			else
				// ���� ��ġ���� ���� ���
				chess_board[now_queen_height + 1] = 0;
		}
	}
	// ��Ʈ��ŷ
	chess_board[now_queen_height] = 0;
}


void nQueen(int n) {
	// ���� queen ��ġ ���� �� �ݺ�
	for (int i = 1; i <= n; i++) {
		chess_board.resize(MAX_SIZE);
		chess_board[1] = i;

		chk_board(1, n+1);
	}
}


int main() {
	int n;
	cin >> n;

	nQueen(n);

	cout << result;

}
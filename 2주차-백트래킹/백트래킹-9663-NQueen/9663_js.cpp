#include <iostream>
#include <vector>

#define MAX_SIZE 15

using namespace std;


vector<int> chess_board;
int result = 0;

bool chk_now_queen(int t_height) {
	// 세로, 대각선에 퀸이 위치했는지 확인
	for (int i_height = 1; i_height < t_height; i_height++) {
		// 세로에 위치하는지 확인
		if (chess_board[i_height] == chess_board[t_height]) 
			return 0;
		// 대각선에 위치하는지 확인
		else if (abs(chess_board[i_height] - chess_board[t_height]) == abs(i_height - t_height)) 
			return 0;
	}
	return 1;
}


void chk_board(int now_queen_height, int max_width) {
	// 모든 퀸을 배치한 경우 결과 값을 하나 올린다.
	if (now_queen_height == max_width-1) {
		result++;
	}
	else {
		for (int i_width = 1; i_width < max_width; i_width++) {
			// 미리 임의로 위치시킨다.
			chess_board[now_queen_height+1] = i_width;
			// 배치가 올바른지 확인한다.
			if (chk_now_queen(now_queen_height+1)) {
				// 퀸이 배치 됬을 경우
				chk_board(now_queen_height + 1, max_width);
			}
			else
				// 퀸이 배치되지 않을 경우
				chess_board[now_queen_height + 1] = 0;
		}
	}
	// 백트래킹
	chess_board[now_queen_height] = 0;
}


void nQueen(int n) {
	// 최초 queen 위치 설정 후 반복
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
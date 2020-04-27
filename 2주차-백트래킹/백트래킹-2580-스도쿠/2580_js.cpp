#include <iostream>
#include <vector>

#define MAX_SIZE 9

using namespace std;
// ������ ���� �Է¹ޱ� ���� ����
int sudoku_board[MAX_SIZE][MAX_SIZE];
// 0�� ��츦 �����ϱ� ���� ����
vector<pair<int, int> > chk_input;

bool chk_x(int x, int input) {
	
	// x �� Ȯ��
	for (int j = 0; j < MAX_SIZE; j++) {
		if (sudoku_board[x][j]==input) return 1;
	}
	

	return 0;
}

bool chk_y(int y, int input) {
	
	// y �� Ȯ��
	for (int i = 0; i < MAX_SIZE; i++) {
		if (sudoku_board[i][y] == input) return 1;
	}

	return 0;
}

bool chk_cube(int x, int y, int input) {
	x = x / 3;
	y = y / 3;
	// 3 x 3 �ȿ� ���� �ִ��� Ȯ��
	for (int i_x = 3*x; i_x < 3*(x+1); i_x++) {
		for (int i_y = 3 * y; i_y < 3 * (y + 1); i_y++) {
			if (sudoku_board[i_x][i_y] == input) return 1;
		}
	}

	return 0;
}

bool chk_all(int x, int y, int input) {
	// �� ���� ��� ���̸� ���� ��ȯ
	if (chk_x(x,input)) return 0;
	if (chk_y(y, input)) return 0;
	if (chk_cube(x, y, input)) return 0;
	return 1;
}

void sudoku_print() {
	// ��� ���Ŀ� �°� �����
	for (int i = 0; i < 9; i++) {
		for (int j = 0; j < 9; j++)
			cout << sudoku_board[i][j] << ' ';
		cout << '\n';
	}	
	// �����ϴ� ���� ����� ���� ���� �� �����Ƿ� exit(0)���� ������Ŵ. (������ �ð�, ���� �ʰ�)
	exit(0);
}

void sudoku(int count) {
	// input��ŭ ĭ�� ä�� ��� ��� �� ������Ų��.
	if (count == chk_input.size())
		sudoku_print();

	for (int i = 1; i <= MAX_SIZE; i++) {
		int x = chk_input[count].first;
		int y = chk_input[count].second;
		// ���ǿ� �����ϴٸ� �ش� ������ �Ҵ� �� ���� �ܰ�� �Ѿ�� ��Ʈ��ŷ�Ѵ�.
		if (chk_all(x, y, i)) {
			sudoku_board[x][y] = i;
			sudoku(count + 1);
			// ��Ʈ��ŷ
			sudoku_board[x][y] = 0;
		}
	}
}

int main(void){
	for (int i = 0; i < MAX_SIZE; i++){
		for (int j = 0; j < MAX_SIZE; j++){
			cin >> sudoku_board[i][j];
			// 0�� �Է��� ��� ����� ���� vector�� ����ִ´�.
			if (!sudoku_board[i][j]){
				chk_input.push_back(make_pair(i, j));
			}
		}
	}

	sudoku(0); 

	return 0;

}
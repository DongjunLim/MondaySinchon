#include <iostream>
#include <vector>

#define MAX_SIZE 9

using namespace std;
// 스도쿠 판을 입력받기 위한 변수
int sudoku_board[MAX_SIZE][MAX_SIZE];
// 0일 경우를 저장하기 위한 변수
vector<pair<int, int> > chk_input;

bool chk_x(int x, int input) {
	
	// x 값 확인
	for (int j = 0; j < MAX_SIZE; j++) {
		if (sudoku_board[x][j]==input) return 1;
	}
	

	return 0;
}

bool chk_y(int y, int input) {
	
	// y 값 확인
	for (int i = 0; i < MAX_SIZE; i++) {
		if (sudoku_board[i][y] == input) return 1;
	}

	return 0;
}

bool chk_cube(int x, int y, int input) {
	x = x / 3;
	y = y / 3;
	// 3 x 3 안에 값이 있는지 확인
	for (int i_x = 3*x; i_x < 3*(x+1); i_x++) {
		for (int i_y = 3 * y; i_y < 3 * (y + 1); i_y++) {
			if (sudoku_board[i_x][i_y] == input) return 1;
		}
	}

	return 0;
}

bool chk_all(int x, int y, int input) {
	// 세 조건 모두 참이면 참을 반환
	if (chk_x(x,input)) return 0;
	if (chk_y(y, input)) return 0;
	if (chk_cube(x, y, input)) return 0;
	return 1;
}

void sudoku_print() {
	// 출력 형식에 맞게 출력함
	for (int i = 0; i < 9; i++) {
		for (int j = 0; j < 9; j++)
			cout << sudoku_board[i][j] << ' ';
		cout << '\n';
	}	
	// 만족하는 여러 경우의 수가 있을 수 있으므로 exit(0)으로 중지시킴. (없으면 시간, 형식 초과)
	exit(0);
}

void sudoku(int count) {
	// input만큼 칸을 채운 경우 출력 후 중지시킨다.
	if (count == chk_input.size())
		sudoku_print();

	for (int i = 1; i <= MAX_SIZE; i++) {
		int x = chk_input[count].first;
		int y = chk_input[count].second;
		// 조건에 부합하다면 해당 변수를 할당 후 다음 단계로 넘어가고 백트래킹한다.
		if (chk_all(x, y, i)) {
			sudoku_board[x][y] = i;
			sudoku(count + 1);
			// 백트래킹
			sudoku_board[x][y] = 0;
		}
	}
}

int main(void){
	for (int i = 0; i < MAX_SIZE; i++){
		for (int j = 0; j < MAX_SIZE; j++){
			cin >> sudoku_board[i][j];
			// 0이 입력됬을 경우 계산을 위한 vector에 집어넣는다.
			if (!sudoku_board[i][j]){
				chk_input.push_back(make_pair(i, j));
			}
		}
	}

	sudoku(0); 

	return 0;

}
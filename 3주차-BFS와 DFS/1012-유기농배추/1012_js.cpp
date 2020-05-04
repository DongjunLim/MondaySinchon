#include <iostream>

using namespace std;

typedef struct
{
	int x, y;
}Dim;

int map[50][50] = {0,};

Dim dim[4] = { {-1,0},{1,0},{0,-1},{0,1} };

void dfs(int x, int y) {
	// 값을 0으로 바꾸면서 탐색함. (인접한 배추를 모두 0으로 만듬)
	map[x][y] = 0;
	for (int i = 0; i < 4; ++i) {
		int now_x = x + dim[i].x;
		int now_y = y + dim[i].y;

		// 배추가 없을 경우 넘김
		if (map[now_x][now_y] != 1)
			continue;

		// 제한 범위를 넘어설 경우 넘김
		if (now_x < 0 || now_y < 0 || now_x >= n || now_y >= m)
			continue;

		dfs(now_x, now_y);
	}
}

int main() {

	int t, m, n, k, x, y, ans = 0;


	//반복 횟수 입력
	cin >> t;
	
	while (t--) {

		// 세부 항목 입력
		cin >> m >> n >> k;
		

		// 배추를 심는다.
		for (int i = 0; i < k; ++i) {
			cin >> y >> x;
			map[x][y] = 1;
		}

		// 배추가 심어저 있을 경우 탐색 시작
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < m; ++j) {
				if (map[i][j] == 1) {
					ans++;
					dfs(i, j);
				}
			}
		}

		cout << ans << endl;
	}
	return 0;
}

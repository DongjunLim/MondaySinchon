#include <iostream>

using namespace std;

typedef struct
{
	int x, y;
}Dim;

int map[50][50] = {0,};

Dim dim[4] = { {-1,0},{1,0},{0,-1},{0,1} };

void dfs(int x, int y) {
	// ���� 0���� �ٲٸ鼭 Ž����. (������ ���߸� ��� 0���� ����)
	map[x][y] = 0;
	for (int i = 0; i < 4; ++i) {
		int now_x = x + dim[i].x;
		int now_y = y + dim[i].y;

		// ���߰� ���� ��� �ѱ�
		if (map[now_x][now_y] != 1)
			continue;

		// ���� ������ �Ѿ ��� �ѱ�
		if (now_x < 0 || now_y < 0 || now_x >= n || now_y >= m)
			continue;

		dfs(now_x, now_y);
	}
}

int main() {

	int t, m, n, k, x, y, ans = 0;


	//�ݺ� Ƚ�� �Է�
	cin >> t;
	
	while (t--) {

		// ���� �׸� �Է�
		cin >> m >> n >> k;
		

		// ���߸� �ɴ´�.
		for (int i = 0; i < k; ++i) {
			cin >> y >> x;
			map[x][y] = 1;
		}

		// ���߰� �ɾ��� ���� ��� Ž�� ����
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

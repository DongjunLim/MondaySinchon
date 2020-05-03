
#include <cstdio>
#include <queue>
using namespace std;

const int roff[4] = { -1, 1, 0, 0 };
const int coff[4] = { 0, 0, -1, 1 };
// �̷� ��
bool board[100][100];
// �湮 ���� ����
bool visited[100][100] = { 0 };
// 1. 100x100 �迭�̹Ƿ� �� ���¸� "��*100+��"�� �ؽð����� ���
queue<int> Q;
// ����� ����
int result = 1;

void bfs(int N, int M) {
	while (true) {
		// ���� ť�� ���� ������ŭ ���� for���� ����
		int qSize = Q.size();
		for (int i = 0; i < qSize; i++) {
			// �ؽð����κ��� ���� ��ġ�� ��, �� ��ȣ�� ������
			int row = Q.front() / 100;
			int col = Q.front() % 100;
			Q.pop();
			// ������ ���, �̵� Ƚ�� ����ϰ� ���α׷� ����
			if (row == N - 1 && row == M - 1)
				return;

			// 2. offset �迭�� �� ���⸶���� ��, �� �̵� �Ÿ��� �����
			for (int d = 0; d < 4; d++) {
				// �̵��� ���� ��ġ
				int next_row = row + roff[d];
				int next_col = row + coff[d];
				// �̷� �ٱ����δ� �̵� �Ұ���
				if (next_row < 0 || next_row >= N || next_col < 0 || next_col >= M) continue;
				// ���̸� �湮 �Ұ���
				if (!board[next_row][next_col]) continue;
				// �̹� �湮�� ��ġ�� �̵����� ����
				if (visited[next_row][next_col]) continue;

				// �湮�� ������ �����ϰ�, ť�� ���� �־� ������ �湮
				visited[next_row][next_col] = true;
				Q.push(next_row * 100 + next_col);
			}
		}

		// ���� for���� ���� ������ �̵� Ƚ�� ����
		result++;
	}
}

int main() {
	int N, M;
	scanf("%d %d", &N, &M);

	for (int i = 0; i < N; i++)
		for (int j = 0; j < M; j++)
			scanf("%1d", &board[i][j]);

	visited[0][0] = true;

	Q.push(0);

	bfs(N, M);

	printf("%d", result);
}
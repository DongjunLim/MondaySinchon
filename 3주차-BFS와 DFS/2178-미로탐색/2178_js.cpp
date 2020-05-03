
#include <cstdio>
#include <queue>
using namespace std;

const int roff[4] = { -1, 1, 0, 0 };
const int coff[4] = { 0, 0, -1, 1 };
// 미로 판
bool board[100][100];
// 방문 여부 매핑
bool visited[100][100] = { 0 };
// 1. 100x100 배열이므로 각 상태를 "행*100+열"의 해시값으로 사용
queue<int> Q;
// 결과값 저장
int result = 1;

void bfs(int N, int M) {
	while (true) {
		// 현재 큐의 원소 개수만큼 안쪽 for문을 실행
		int qSize = Q.size();
		for (int i = 0; i < qSize; i++) {
			// 해시값으로부터 현재 위치의 행, 열 번호를 가져옴
			int row = Q.front() / 100;
			int col = Q.front() % 100;
			Q.pop();
			// 도착한 경우, 이동 횟수 출력하고 프로그램 종료
			if (row == N - 1 && row == M - 1)
				return;

			// 2. offset 배열로 각 방향마다의 행, 열 이동 거리를 계산함
			for (int d = 0; d < 4; d++) {
				// 이동한 후의 위치
				int next_row = row + roff[d];
				int next_col = row + coff[d];
				// 미로 바깥으로는 이동 불가능
				if (next_row < 0 || next_row >= N || next_col < 0 || next_col >= M) continue;
				// 벽이면 방문 불가능
				if (!board[next_row][next_col]) continue;
				// 이미 방문한 위치면 이동하지 않음
				if (visited[next_row][next_col]) continue;

				// 방문한 것으로 갱신하고, 큐에 새로 넣어 다음에 방문
				visited[next_row][next_col] = true;
				Q.push(next_row * 100 + next_col);
			}
		}

		// 안쪽 for문이 끝날 때마다 이동 횟수 증가
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
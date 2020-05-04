#include <iostream>
#include <queue>
using namespace std;

typedef struct
{
	int z, y, x;
}Dim;

Dim moveDim[6] = { { 1, 0, 0 }, { -1, 0, 0 }, { 0, 1, 0 }, { 0, -1, 0 }, { 0, 0, 1 }, { 0, 0, -1 } };

int N, M, H, empty_tom, t_count;
int tomato[100][100][100];
queue<Dim> que;

void bfs(){
	Dim D, D_next;
	int  current_size, day = 0;
	//처음부터 익힐 수 있는 토마토가 없는 경우
	if (que.empty()) {
		cout << 0 << endl;
		return;
	}
		
	while (!que.empty()){
		current_size = que.size();
		day++;
		// 큐 사이즈만큼 반복
		for (int i = 0; i < current_size; i++)
		{
			D.z = que.front().z;
			D.y = que.front().y;
			D.x = que.front().x;
			// x,y,z 방향으로 확인 ( 대각선 제외)
			for (int i = 0; i < 6; i++)
			{
				D_next.z = D.z + moveDim[i].z;
				D_next.y = D.y + moveDim[i].y;
				D_next.x = D.x + moveDim[i].x;
				// 다음 토마토를 익힐 수 있는 경우
				if (0 <= D_next.z && D_next.z < H && 0 <= D_next.y && D_next.y < N && 0 <= D_next.x && D_next.x < M && tomato[D_next.z][D_next.y][D_next.x] == 0)
				{
					tomato[D_next.z][D_next.y][D_next.x] = 1;
					// 익힌 갯수 확인
					t_count++;
					que.push({ D_next.z, D_next.y, D_next.x });
				}
			}
			que.pop();
			
		}
	}
	// 모든 토마토를 익혔을 경우 날짜 출력
	if (M * N * H - empty_tom == t_count){
		cout << day - 1 << endl;
	}
	// 남은 토마토가 있다면 -1 출력
	else { 
		cout << -1 << endl;
	}
	return;
}

int main(void)
{
	cin >> M >> N >> H;
	t_count = 0;
	empty_tom = 0;
	int temp;
	for (int i = 0; i < H; i++)
		for (int j = 0; j < N; j++)
			for (int k = 0; k < M; k++){
				cin >> temp;
				// 익은 토마토 넣기	
				if (temp == 1) {
					que.push({ i,j,k }); 		
					t_count++;
				}
				// 토마토를 넣지 못하는 갯수 세기
				else if (temp == -1)
					empty_tom++; 

				tomato[i][j][k] = temp;
				//cout << "tomato" << i << j << k << endl;
			}

	bfs();

	return 0;
}
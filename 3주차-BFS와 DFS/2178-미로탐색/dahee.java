package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// 실행 시간 152ms
public class BOJ_2178_미로탐색 {

	public static int N, M, map[][];
	public static int dx[] = {-1, 1, 0, 0};
	public static int dy[] = {0, 0, -1, 1};
	
	public static class Pair {
		int x, y;
		
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input[] = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		
		map = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			input = br.readLine().split("");
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(input[j]);
			}
		}
		
		bfs(0, 0);
		
		// 결과 출력
		System.out.println(map[N - 1][M - 1]);
	}
	
	private static void bfs(int x, int y) {
		Queue<Pair> q = new LinkedList<Pair>();
		q.offer(new Pair(x, y));
		
		while(!q.isEmpty()) {
			Pair cur = q.poll();
			
			// 상하좌우 탐색
			for(int d = 0; d < 4; d++) {
				int nx = cur.x + dx[d];
				int ny = cur.y + dy[d];
				
				// 처리하려는 점이 범위를 벗어나는지 체크
				if(checkRange(nx, ny)) continue;
				// 1인 경우 아직 처리가 안된 것이므로 처리
				if(map[nx][ny] == 1) {
					q.offer(new Pair(nx, ny));
					// 따로 visited을 두지 않고 거리를 더함.
					// 다음 방문하는 지점은 현재 지점에서부터 거리 + 1이므로 더해줌.
					map[nx][ny] = map[cur.x][cur.y] + 1;
				}
			}
		}
	}
	
	private static boolean checkRange(int x, int y) {
		return x < 0 || x >= N || y < 0 || y >= M;
	}
}

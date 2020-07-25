import java.io.BufferedReader;

//런타임 에러

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node {
		int x;
		int y;
		int cost;
		
		Node(int y, int x, int cost){
			this.y=y;
			this.x=x;
			this.cost=cost;
		}
	

		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.cost - o.cost;
		}
	}

public class Zelda2 {
	
	static int[][] map;
	static int[][] dist;
	static int[] dx;
	static int[] dy;
	static int N;
	static int MIN;

	public static void main(String[] args) throws  IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int num = 1;
		
		map = new int[125][125];
		dist = new int[125][125];
		MIN = Integer.MAX_VALUE;
		
		while(true) {
			N = Integer.parseInt(br.readLine());
			if(N == 0) {
				break;
			}
			
			map = new int[N][N];
			dist = new int[N][N];
			for(int i=0; i<N; i++) {
				st = new StringTokenizer( br.readLine(), " ");
				int idx = 0;
				while( st.hasMoreTokens() ) {
					map[i][idx] = Integer.parseInt( st.nextToken() );
					dist[i][idx] = MIN;
					idx ++;
				}
			}
			int ans = rupee();
			
			sb.append("Problem "+num+": "+ans+ "\n");
			num += 1;
		}
		System.out.println(sb.toString());
	}
	
	public static int rupee() {
		PriorityQueue<Node> pq  = new PriorityQueue<Node>();
		dist[0][0] = map[0][0];
		pq.add(new Node(0,0,map[0][0])); //첫번째 배열 대입
		
		int[] dx = { 1, -1, 0, 0 };
		int[] dy = { 0, 0, 1, -1 };
		
		while(!pq.isEmpty()) {
			Node p = pq.poll();
			int a = p.y;
			int b= p.x;
			int cost = p.cost;
			
			//꺼낼 때마다 현재보다 크면 무시
			if(dist[a][b] < cost) continue;
			
			for(int i=0; i<4; i++) {
				int yy = a+dy[i];
				int xx = b+dx[i];
				if( xx >= 0 && xx < N && yy >=0 && yy<N) {
					if(dist[yy][xx] > dist[a][b] + map[yy][xx]) {
						dist[yy][xx] = dist[a][b]+map[yy][xx];
						pq.offer(new Node(yy,xx,dist[yy][xx]));
					}
				}
			}
		}
		return dist[N-1][N-1];
	}
	
	public static void print() {
		for(int i = 0 ; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(dist[i][j] + " ");
			}
			System.out.println();
		}
	}

}

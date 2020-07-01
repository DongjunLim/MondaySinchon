
import java.util.LinkedList;
import java.util.Queue;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


class Node{ //?
	int x;
	int y;
	
	Node(int x, int y){
		this.x=x;
		this.y=y;
	}
}

public class SupplyRoute {
	
	static int N;
	static boolean[][] check;
	static int[][] tour ;
	static int[] dx = {  -1, 1, 0, 0  }; //x축 좌우 표시
    static int[] dy = {  0, 0, -1, 1  }; //y축 상하 표시
    static int[][] ans;
    static int min;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T;
		T=Integer.parseInt(br.readLine());
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

		for(int test_case = 1; test_case <= T; test_case++)
		{
			N = Integer.parseInt(br.readLine());
			tour = new int[N][N];
			
			for(int i =0; i<N; i++) { //입력받음
				String[] temp = br.readLine().split("");
				for(int j=0; j<N; j++) {
					tour[i][j] = Integer.parseInt(temp[j]);
				}
			}
			
			check = new boolean[N][N];
			ans = new int[N][N];
			
            min = Integer.MAX_VALUE;
		
			ans[0][0] = 0;
			bfs(0,0);
			
			System.out.println("#" + test_case + " " + min);
		}

	}
	
	private static void bfs(int x, int y) {
		Queue<Node> q= new LinkedList<>();
		
		q.offer(new Node(x,y));
		check[x][y] = true;
		while(!q.isEmpty()) {
			Node p = q.poll();
			int a = p.x;
			int b = p.y;
			if(a == N-1 && b == N-1) //min보다 더 작은 값이 존재하면 리턴
                min = min > ans[N-1][N-1] ? ans[N-1][N-1] : min;
            // 가지치기
            if(min <= ans[a][b])
                continue;
            for(int i=0; i<4; i++){ //노드 이동
                int xx = a + dx[i];
                int yy = b + dy[i];
                if(isValidPosition(xx, yy)){ //현재 노드가 유망할 때
                    if(!check[xx][yy] || ans[xx][yy] > ans[a][b] + tour[xx][yy]){ //아직 방문하지 않았고 이 길로 가는 것이 더 적은 시간이 걸린다면 
                        check[xx][yy] = true; //queue에 넣고 방문 처리
                        ans[xx][yy] = ans[a][b] + tour[xx][yy]; //현 위치에서의 값에 이동할 위치의 복구시간을 더해서 update
                        q.offer(new Node(xx, yy));
                        //현 위치까지 오는 복구시간(ans[a][b])에서 다음 이동할 위치까지 이동한 복구시간(tour[xx][yy])과 
                        //다른경로로 왔을때의 복구시간(ans[xx][yy])을 비교해서 전자가 더 작으면 이 길로 이동
                    }
                }
            }
        }
    }
 
    private static boolean isValidPosition(int x, int y){ //현재 노드가 유망하지 않은지 체크
        if(x < 0 || x >= N || y < 0 || y >= N)
            return false;
        return true;
    }
}

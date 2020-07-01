
import java.util.LinkedList;
import java.util.Queue;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV15QRX6APsCFAYD&categoryId=AV15QRX6APsCFAYD&categoryType=CODE&&&

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
	static int[] dx = {  -1, 1, 0, 0  }; //x�� �¿� ǥ��
    static int[] dy = {  0, 0, -1, 1  }; //y�� ���� ǥ��
    static int[][] ans;
    static int min;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T;
		T=Integer.parseInt(br.readLine());
		/*
		   ���� ���� �׽�Ʈ ���̽��� �־����Ƿ�, ������ ó���մϴ�.
		*/

		for(int test_case = 1; test_case <= T; test_case++)
		{
			N = Integer.parseInt(br.readLine());
			tour = new int[N][N];
			
			for(int i =0; i<N; i++) { //�Է¹���
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
			if(a == N-1 && b == N-1) //min���� �� ���� ���� �����ϸ� ����
                min = min > ans[N-1][N-1] ? ans[N-1][N-1] : min;
            // ����ġ��
            if(min <= ans[a][b])
                continue;
            for(int i=0; i<4; i++){ //��� �̵�
                int xx = a + dx[i];
                int yy = b + dy[i];
                if(isValidPosition(xx, yy)){ //���� ��尡 ������ ��
                    if(!check[xx][yy] || ans[xx][yy] > ans[a][b] + tour[xx][yy]){ //���� �湮���� �ʾҰ� �� ��� ���� ���� �� ���� �ð��� �ɸ��ٸ� 
                        check[xx][yy] = true; //queue�� �ְ� �湮 ó��
                        ans[xx][yy] = ans[a][b] + tour[xx][yy]; //�� ��ġ������ ���� �̵��� ��ġ�� �����ð��� ���ؼ� update
                        q.offer(new Node(xx, yy));
                        //�� ��ġ���� ���� �����ð�(ans[a][b])���� ���� �̵��� ��ġ���� �̵��� �����ð�(tour[xx][yy])�� �ٸ���η� �������� �����ð�(ans[xx][yy])�� ���ؼ� ���ڰ� �� ������ �� ��� �̵�
                    }
                }
            }
        }
    }
 
    private static boolean isValidPosition(int x, int y){ //���� ��尡 �������� ������ üũ
        if(x < 0 || x >= N || y < 0 || y >= N)
            return false;
        return true;
    }
}
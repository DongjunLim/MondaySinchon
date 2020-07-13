import java.util.*;

//https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5LwsHaD1MDFAXc
//시간초과 코드

public class Popping {
	
	static int N, T;
	static char[][] map;
	static Queue<Integer> q = new LinkedList<>();
	static int[] dx = {-1,-1,-1,0,0,1,1,1};
    static int[] dy = {-1,0,1,-1,1,-1,0,1}; //8방향으로 탐색
    static int cnt;
    static boolean[][] visited;
    
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		T=sc.nextInt();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

		for(int test_case = 1; test_case <= T; test_case++)
		{
		
			N = sc.nextInt();
			map = new char[N][N];
			
			for(int i=0; i<N; i++) {
				String str = sc.next();
				for(int j=0;j<N;j++) {
					map[i][j] = str.charAt(j);
				}
			}
			
			visited = new boolean[N][N];
			cnt = 0;
            
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
                    
					if(map[i][j] != '.') continue;
					else if(map[i][j] == '.') cnt++;
				
					int minepop = 0; //지뢰찾기
					
					for(int k=0; k<8; k++) {
						int xx = i + dx[k];
						int yy = j = dy[k];
						
						if(isValid(xx, yy) && map[xx][yy] == '*') { //해당 방향에 지뢰가 존재하면 지뢰 증가
							minepop++;
						}
					}
					
					 if(minepop == 0) {
	                        q.add(i);
	                        q.add(j);
	                        bfs();    
	                    }
				}
			}
			/*for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(map[i][j] == '.') cnt++;
                }
            }*/
			
			System.out.println("#" + test_case + " " + cnt);
			
		}
	}
	
	public static void bfs() {
		cnt += 1;
		while(!q.isEmpty()) {
			int x = q.poll();
			int y = q.poll();
			
			int minepop = 0;
			
			for(int k=0; k<8; k++) {
				int xx = x + dx[k];
				int yy = y = dy[k];
				
				if(isValid(xx, yy) && map[xx][yy] == '*') {
					minepop++;
				}
			}
			
			if(minepop == 0) {
				map[x][y] = 'x';
				
				for(int k=0; k<8; k++) {
					int xx = x + dx[k];
					int yy = y = dy[k];
					
					if(!isValid(xx,yy) || map[xx][yy] != '.' || visited[xx][yy]) continue;
					
					visited[xx][yy] = true;
					
					q.add(xx);
					q.add(yy);
				}
			}else {
				map[x][y] = 'x';
			}
			
		}
		
	}
	
	public static boolean isValid(int x, int y) {
		if( x < 0 || x >= N || y < 0 || y >= N) return false;
        return true;
	}

}


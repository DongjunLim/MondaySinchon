import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//https://www.acmicpc.net/problem/6593

class Node{
	int x;
	int y;
	int z;
	
	Node(int x, int y, int z){
		this.x=x;
		this.y=y;
		this.z=z;
	}
}

public class SangbumBuilding {
	static int L;
    static int R;
    static int C;
    static char[][][] map;
    static boolean[][][] visited;
    static int[] dx = {-1, 1, 0, 0, 0, 0};
    static int[] dy = {0, 0, -1, 1, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};
    static int m = 0;
	static int end_x, end_y, end_z;
	static int my_end_x =-1;
	static int my_end_y =-1;
	static int my_end_z =-1;
	
  

    
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
        while(true) {
        	
        	String str = br.readLine();
        	if(str.length() == 0) str = br.readLine();
        	String[] LRC = str.split(" ");
        	L = Integer.parseInt(LRC[0]);
        	R = Integer.parseInt(LRC[1]);
        	C = Integer.parseInt(LRC[2]);
        
        	int start_x = 0;
        	int start_y = 0;
        	int start_z = 0;
        	end_x = -1;
        	end_y=-1;
        	end_z=-1;
        	

            map = new char[L][R][C];
            visited = new boolean[L][R][C];
        	
            if(L==0 && R==0 && C==0) {
                break;
            }
            
        	for(int z=0; z<map.length; z++) {
			 for(int x=0; x<map[0].length; x++) { //행
				char[] arr = br.readLine().toCharArray();
                 if(arr.length == 0) {
                	 arr = br.readLine().toCharArray();
                 }
				 for(int y=0; y<map[0][0].length; y++) { //열
					map[z][x][y] = arr[y];
					
					if(map[z][x][y] == 'S') {
                        start_x = z;
                        start_y = x;
                        start_z = y;
                    } else if(map[z][x][y] == 'E') {
                        end_x = z;
                        end_y = x;
                        end_z= y;
                    }
				}
			 }
		  }
        bfs(new Node(start_x, start_y,start_z));
        //my_end = end가 같아야 탈출에 성공한 것이다.            
        if(my_end_x == end_x && my_end_y == end_y && my_end_z == end_z) {
            System.out.println("Escaped in "+ (m-1) +" minute(s).");
        } else {
            System.out.println("Trapped!");
        }
        //my_end와 m을 0으로 초기화시킨다.
        my_end_x = 0;
        my_end_y= 0;
        my_end_z = 0;
        m = 0;
        }
        
	}
	
	public static void bfs(Node d) {
		Queue<Node> q = new LinkedList<Node>();
		q.add(d);
		visited[d.x][d.y][d.z] = true;
		
		loop: while(!q.isEmpty()) {
			int size = q.size();
			
			for(int i=0; i<size; i++) {
				Node p=q.remove();
			
				//'E'에 도착하면 my_end를 현재 좌표로 설정해준다.
                //만약 'E'에 도착하지 못하면 계속 -1로 유지될 것이다.
				if(map[p.x][p.y][p.z] == 'E') {
	                m++;
	                my_end_x = p.x;
	                my_end_y= p.y;
	                my_end_z = p.z;
	                break loop;
				}
				
				for(int k=0; k<6; k++) {
					int a= p.x + dz[k];
					int b= p.y+ dx[k];
					int c= p.z+ dy[k];
					
					if(a >=0 && a<L && b>=0 && b<R && c>=0 && c<C 
						&& map[a][b][c] != '#' && !visited[a][b][c]) {
							q.add(new Node(a,b,c));
							visited[a][b][c] = true;
					}
			  }
			}
			m++;
		}
		
	}

}



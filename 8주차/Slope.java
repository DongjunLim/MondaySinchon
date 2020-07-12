import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//https://www.acmicpc.net/problem/14890

public class Slope {
	static int N,L;
	static int[][] arr;
	static int count; //갈수 있는 길 세기
	static int x,y,d;
	static int[] height;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		
		arr = new int[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 한 줄이 경사로인지 확인
		//d = 0 이면 행검사, d = 1 이면 열검사
		for (int i=0; i<N; i++) {
            if (goForward(i, 0, 0)) 
                count++;
            
            if (goForward(0, i, 1)) 
                count++;
        }
 
        System.out.println(count);
	}
	
	static boolean goForward(int x, int y, int d) {
		height = new int[N];
		visited = new boolean[N];
		
		for(int i=0; i<arr.length; i++) {
			if(d == 0) { //행을 복사
				height[i] = arr[x][y+i];
			}else { //열을 복사
				height[i] = arr[x+i][y];
			}
		}
		
		for (int i=0; i<N-1; i++) {
            // 조건1. 높이가 같으면 패스
            if (height[i] == height[i+1]) {
                continue;
            }
            
            //조건2. 경사 차이가 1보다 크면 패스
            if (Math.abs(height[i] - height[i+1]) > 1) { 
                return false;
            }
 
            // 조건3. 내려가야되는 경우
            if (height[i] - 1 == height[i+1]) {
                for (int j=i+1; j<=i+L; j++) {
                    // j가 범위를 벗어나거나 높이가 다르거나 이미 경사로가 있는 경우(방문했던 경우) false
                    if (j >= N || height[i+1] != height[j] || visited[j] == true) {
                        return false;
                    } 
                    visited[j] = true; //조건을 통과했다면 true
                }
            }
            
            // 조건 4. 올라가야되는 경우
            else if (height[i] + 1 == height[i+1]) {
                for (int j=i; j>i-L; j--) { //j가 0보다 작거나(범위를 벗어났거나) 높이가 다르거나 이미 방문했을때 false
                    if (j < 0 || height[i] != height[j] || visited[j] == true) {
                        return false;
                    }
                    visited[j] = true;
                }
            }            
        }
 
        return true;
    }

}

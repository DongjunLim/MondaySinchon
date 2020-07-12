import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//https://www.acmicpc.net/problem/14890

public class Slope {
	static int N,L;
	static int[][] arr;
	static int count; //���� �ִ� �� ����
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
		
		// �� ���� �������� Ȯ��
		//d = 0 �̸� ��˻�, d = 1 �̸� ���˻�
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
			if(d == 0) { //���� ����
				height[i] = arr[x][y+i];
			}else { //���� ����
				height[i] = arr[x+i][y];
			}
		}
		
		for (int i=0; i<N-1; i++) {
            // ����1. ���̰� ������ �н�
            if (height[i] == height[i+1]) {
                continue;
            }
            
            //����2. ��� ���̰� 1���� ũ�� �н�
            if (Math.abs(height[i] - height[i+1]) > 1) { 
                return false;
            }
 
            // ����3. �������ߵǴ� ���
            if (height[i] - 1 == height[i+1]) {
                for (int j=i+1; j<=i+L; j++) {
                    // j�� ������ ����ų� ���̰� �ٸ��ų� �̹� ���ΰ� �ִ� ���(�湮�ߴ� ���) false
                    if (j >= N || height[i+1] != height[j] || visited[j] == true) {
                        return false;
                    } 
                    visited[j] = true; //������ ����ߴٸ� true
                }
            }
            
            // ���� 4. �ö󰡾ߵǴ� ���
            else if (height[i] + 1 == height[i+1]) {
                for (int j=i; j>i-L; j--) { //j�� 0���� �۰ų�(������ ����ų�) ���̰� �ٸ��ų� �̹� �湮������ false
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

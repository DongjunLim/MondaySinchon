import java.util.Scanner;

//https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWqUzj0arpkDFARG&categoryId=AWqUzj0arpkDFARG&categoryType=CODE
public class SuzyTour {


	static int R,C;
	static int result; //<-여기에 0이라고 선언하면 에러남
	static int[] check;
	static char[][] tour ;
	static int[] dx = {  -1, 1, 0, 0  }; //x축 좌우 표시
    static int[] dy = {  0, 0, -1, 1  }; //y축 상하 표시
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

		for(int test_case = 1; test_case <= T; test_case++)
		{
		
			R = sc.nextInt();
			C = sc.nextInt();
			tour = new char[R][C];
			
			for(int i=0; i<R; i++) {
				String str = sc.next();
				for(int j=0;j<C;j++) {
					tour[i][j] = str.charAt(j);
				}
			}
			result = 0;
			check = new int[26];
			int cur = tour[0][0] - 'A';
			check[cur] = 1;
			dfs(0,0,1);
			
			System.out.println("#" + test_case + " " + result);
			

		}

	}
	public static void dfs(int i,int j, int max) {
		if(max > result) {
			result = max;
		}
		if(result == 26) return;
		for(int a=0; a<dy.length; a++ ) {
			int xx = i+dx[a];
			int yy= j+dy[a];
			if(isPossible(xx,yy) && check[tour[xx][yy] - 'A'] == 0) {
					check[tour[xx][yy] - 'A'] = 1;
					dfs(xx,yy,max+1);
					check[tour[xx][yy] - 'A'] = 0;
				
			}
		}
		
	}
	
	public static boolean isPossible(int xx, int yy) {
		if (0 <= xx && xx < R && 0 <= yy && yy < C)
            return true;
        return false;
	}
}
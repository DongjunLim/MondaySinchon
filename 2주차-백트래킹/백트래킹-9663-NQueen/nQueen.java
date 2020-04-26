package nQueen;

import java.util.Scanner;

//https://www.acmicpc.net/problem/9663

public class nQueen {

	public static int N; //입력 받을 행과 열의 수
    public static int count; //경우의 수
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); 
        
        //1열부터 N열까지 돌면서 [1][N]에 퀸을 놓았을 때 가능한 경우를 확인
        for(int i=1;i<N; i++) {
        	int[] col = new int[N+1]; //열이 N까지 갖을 수 있게 함
        	
        	col[1] = i; //1행 i열에 퀸을 놓음
        	
        	//1행 i열에 퀸이 존재 할 때 퀸이 존재할 수 있는 경우의 수를 dfs를 이용해 구함
        	dfs(col,1);
        }
        System.out.println(count);
    }
    // row 행까지는 퀸을 놓았다.    
    // row+1행에 퀸을 놓을수 있는지 확인한다.
    
    public static void dfs(int[] col, int row) { //dfs로 가능한 행과 열 탐색
        if(row == N) {
        	count++; // 만약 row 값이 N 과 같다면 N 행까지 퀸을 놓았다는 말이므로 count를 1 증가시켜준다.
        }else { //그게 아니라면 1열부터 N열까지 반복
        	for(int i=1; i<N;i++) {
        		col[row+1] = i; //row+1열 i행에 퀸을 놓을 수 있는지 확인한다.
        		if(isPossible(col, row+1)) { //isPossible에서 true값을 받으면 퀸을 놓을 수 있음
        			dfs(col, row+1); //가능하다면 dfs를 호출(재귀)
        		}
        	}
        	
        	//dfs는 1행부터 시작함
        	
        }
    	
    }
    
    public static boolean isPossible(int[] col, int row) { //퀸을 놓을 수 있는 조건
    	//row행까지 퀸이 놓이고 그 다음 행에 (1~N) 열에 퀸을 놓을 수 있는 열이 있는 지 확인하고 가능하면 다음행이 가능한지 계속 확인함
        for(int i=1;i<row;i++) { 
        	if(col[i] == col[row]) return false; //i행(초기값은 1)과 row행의 열 값이 같으면 퀸을 놓을 수 없음
        	
        	if(Math.abs(i -row) == Math.abs(col[i] - col[row])) return false; //퀸끼리 대각선에 놓여 있으면 퀸을 놓을 수 없음
        	
        }
        
        return true; //그 외 상황들은 가능
    }
}
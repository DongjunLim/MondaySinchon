package nQueen;

import java.util.Scanner;

//https://www.acmicpc.net/problem/9663

public class nQueen {

	public static int N; //�Է� ���� ��� ���� ��
    public static int count; //����� ��
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); 
        
        //1������ N������ ���鼭 [1][N]�� ���� ������ �� ������ ��츦 Ȯ��
        for(int i=1;i<N; i++) {
        	int[] col = new int[N+1]; //���� N���� ���� �� �ְ� ��
        	
        	col[1] = i; //1�� i���� ���� ����
        	
        	//1�� i���� ���� ���� �� �� ���� ������ �� �ִ� ����� ���� dfs�� �̿��� ����
        	dfs(col,1);
        }
        System.out.println(count);
    }
    // row ������� ���� ���Ҵ�.    
    // row+1�࿡ ���� ������ �ִ��� Ȯ���Ѵ�.
    
    public static void dfs(int[] col, int row) { //dfs�� ������ ��� �� Ž��
        if(row == N) {
        	count++; // ���� row ���� N �� ���ٸ� N ����� ���� ���Ҵٴ� ���̹Ƿ� count�� 1 ���������ش�.
        }else { //�װ� �ƴ϶�� 1������ N������ �ݺ�
        	for(int i=1; i<N;i++) {
        		col[row+1] = i; //row+1�� i�࿡ ���� ���� �� �ִ��� Ȯ���Ѵ�.
        		if(isPossible(col, row+1)) { //isPossible���� true���� ������ ���� ���� �� ����
        			dfs(col, row+1); //�����ϴٸ� dfs�� ȣ��(���)
        		}
        	}
        	
        	//dfs�� 1����� ������
        	
        }
    	
    }
    
    public static boolean isPossible(int[] col, int row) { //���� ���� �� �ִ� ����
    	//row����� ���� ���̰� �� ���� �࿡ (1~N) ���� ���� ���� �� �ִ� ���� �ִ� �� Ȯ���ϰ� �����ϸ� �������� �������� ��� Ȯ����
        for(int i=1;i<row;i++) { 
        	if(col[i] == col[row]) return false; //i��(�ʱⰪ�� 1)�� row���� �� ���� ������ ���� ���� �� ����
        	
        	if(Math.abs(i -row) == Math.abs(col[i] - col[row])) return false; //������ �밢���� ���� ������ ���� ���� �� ����
        	
        }
        
        return true; //�� �� ��Ȳ���� ����
    }
}
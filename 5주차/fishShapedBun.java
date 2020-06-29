package fishShapedBun_1860;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

//https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5LsaaqDzYDFAXc

public class fishShapedBun {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt(); 
		/*
		   ���� ���� �׽�Ʈ ���̽��� �־����Ƿ�, ������ ó���մϴ�.
		*/
		Integer N, M, K;

		for(int test_case = 1; test_case <= T; test_case++)
		{
		
			
			N = sc.nextInt();
			M = sc.nextInt();
			K = sc.nextInt();
			ArrayList <Integer> a = new ArrayList<>();
			String result = "Possible";

			for(int i=0; i<N; i++) {
				int tmp = sc.nextInt();		
				a.add(tmp);
			}
			
			Collections.sort(a); //�Էµ� N���� ����
			
			for(int i=0; i<N; i++) {
				int b  = a.get(i); //ArrayList���� ��Ҹ� �ϳ��� ������
				int sum = (b/M)*K - i; //�ش� ��ҿ� ���� �ؾ�� ���� �� �ִ�  ����
				if(sum <= 0) { //�ؾ ������ �ش� ���(��)���� ������ �մ� ������ ������ Ȯ�� (ù��° ����̸� 1�� ��, �ι�° �մ��� �� ������ �մ��� �θ��̾ 2�� ��)
					result = "Impossible";
					break;
				}
			}
			System.out.println("#" + test_case + " " + result);

		}
	}

}

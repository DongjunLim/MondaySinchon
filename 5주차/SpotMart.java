import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

//https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AW8Wj7cqbY0DFAXN


public class SpotMart {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		/*
		   ���� ���� �׽�Ʈ ���̽��� �־����Ƿ�, ������ ó���մϴ�.
		*/

		for(int test_case = 1; test_case <= T; test_case++)
		{
		
			int N,M;
			Integer available = 0;
			N = sc.nextInt();
			M = sc.nextInt();
			ArrayList <Integer> a = new ArrayList<>();
			ArrayList <Integer> v = new ArrayList<>();
			
			for(int i=0; i<N; i++) { //���Ե��� ����Ʈ�� �߰�
				int tmp = sc.nextInt();		
				a.add(tmp);
			}
			
			Collections.sort(a); //�Էµ� N���� ����
			
			for(int i=0; i<N; i++) { 
				for(int j=N-1; j>i; j--) { //���� 2���� ������, int j=1; j<N-1; j++ <-����
					if(a.get(i)+a.get(j) <=M) { //�ִ� ���Ժ��� �۰ų� ���� ��
						v.add(a.get(i)+a.get(j)); //v �� �߰�
						available = 1;
					}
				}
			}
			
			Collections.sort(v); //v ����
			
			if(available == 1) { //v�� ������ ����(���� ū ��) ���
				System.out.println("#" + test_case + " " + v.get(v.size()-1));
				
			}else { //�� ��
				System.out.println("#" + test_case + " -1") ;
			}
			

		}

	}

}

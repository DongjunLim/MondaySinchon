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
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

		for(int test_case = 1; test_case <= T; test_case++)
		{
		
			int N,M;
			Integer available = 0;
			N = sc.nextInt();
			M = sc.nextInt();
			ArrayList <Integer> a = new ArrayList<>();
			ArrayList <Integer> v = new ArrayList<>();
			
			for(int i=0; i<N; i++) { //무게들을 리스트에 추가
				int tmp = sc.nextInt();		
				a.add(tmp);
			}
			
			Collections.sort(a); //입력된 N개를 정렬
			
			for(int i=0; i<N; i++) { 
				for(int j=N-1; j>i; j--) { //원소 2개를 선택함, int j=1; j<N-1; j++ <-오류
					if(a.get(i)+a.get(j) <=M) { //최대 무게보다 작거나 같을 때
						v.add(a.get(i)+a.get(j)); //v 에 추가
						available = 1;
					}
				}
			}
			
			Collections.sort(v); //v 정렬
			
			if(available == 1) { //v의 마지막 원소(제일 큰 값) 출력
				System.out.println("#" + test_case + " " + v.get(v.size()-1));
				
			}else { //그 외
				System.out.println("#" + test_case + " -1") ;
			}
			

		}

	}

}

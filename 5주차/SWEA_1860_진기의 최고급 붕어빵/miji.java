import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class fishShapedBun {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt(); 
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
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
			
			Collections.sort(a); //입력된 N개를 정렬
			
			for(int i=0; i<N; i++) {
				int b  = a.get(i); //ArrayList에서 요소를 하나씩 가져옴
				int sum = (b/M)*K - i; //해당 요소에 대해 붕어빵을 만들 수 있는  개수
				if(sum <= 0) { //붕어빵 개수가 해당 요소(초)까지 도착한 손님 수보다 작은지 확인 (첫번째 요소이면 1만 뺌, 두번째 손님은 총 도착한 손님이 두명이어서 2를 뺌)
					result = "Impossible";
					break;
				}
			}
			System.out.println("#" + test_case + " " + result);

		}
	}

}

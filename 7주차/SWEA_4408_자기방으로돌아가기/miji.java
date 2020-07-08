import java.io.IOException;
import java.util.Scanner;

//https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWNcJ2sapZMDFAV8

public class ReturningRoom {

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
		
			int N = sc.nextInt(); //돌아가야 할 학생들의 수
			int[] rooms = new int[201];
			int max = 0; //이동 횟수
			
			for(int i=0; i<N; i++) {
				int room1 = sc.nextInt(); //현재 방 입력
				int room2 = sc.nextInt(); //목표 방 입력
				if(room1 > room2) { //? ->이 부분이 없으면 런타임 에러
                    int temp = room1;
                    room1 = room2;
                    room2 = temp;
                }
				if(room1%2 != 0)room1++; 
                if(room2%2 != 0)room2++; //room1과 2를 모두 짝수로 바꿔놓기
                room1 = room1/2; //?
                room2 = room2/2;
                for(int move = room1; move<=room2; move++) //움직인 횟수 세기
                    rooms[move]++;
                for(int k = 0; k < rooms.length; k++)
                    max = Math.max(max, rooms[k]); //최대로 움직인 횟수 구하기
			}
			
			
			System.out.println("#" + test_case + " " + max);

		}

	}

}

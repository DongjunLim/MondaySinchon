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
		   ���� ���� �׽�Ʈ ���̽��� �־����Ƿ�, ������ ó���մϴ�.
		*/

		for(int test_case = 1; test_case <= T; test_case++)
		{
		
			int N = sc.nextInt(); //���ư��� �� �л����� ��
			int[] rooms = new int[201];
			int max = 0; //��ġ�� ����
			
			for(int i=0; i<N; i++) {
				int room1 = sc.nextInt(); //���� �� �Է�
				int room2 = sc.nextInt(); //��ǥ �� �Է�
				if(room1 > room2) { //? ->�� �κ��� ������ ��Ÿ�� ����
                    int temp = room1;
                    room1 = room2;
                    room2 = temp;
                }
				if(room1%2 != 0)room1++; 
                if(room2%2 != 0)room2++; //room1�� 2�� ��� ¦���� �ٲ����
                room1 = room1/2; //?
                room2 = room2/2;
                for(int move = room1; move<=room2; move++) //������ Ƚ�� ����
                    rooms[move]++;
                for(int k = 0; k < rooms.length; k++)
                    max = Math.max(max, rooms[k]); //�ִ�� ������ Ƚ�� ���ϱ�
			}
			
			
			System.out.println("#" + test_case + " " + max);

		}

	}

}

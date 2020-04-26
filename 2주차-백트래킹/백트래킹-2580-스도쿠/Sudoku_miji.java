import java.util.ArrayList;
import java.util.Scanner;

//https://www.acmicpc.net/problem/2580

public class Sudoku_miji {
	
	static int[][] map = new int[9][9]; //�Է¹޴� �࿭�� ũ��
	static ArrayList<int[]> list = new ArrayList<>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scanner = new Scanner(System.in);
		
		for(int i=0; i<9; i++) {
			for(int j=0; j<9; j++) { //�Էµ� �࿭ ��ȯ
				if((map[i][j] = scanner.nextInt()) == 0) { // �Է°��� 0�̸�
					list.add(new int[] {i,j}); //�ش� ���� ����Ʈ�� ����
				}
			}
		}
		sudoku(0); //�޼ҵ� ȣ��
	}
	
	public static void sudoku(int count) {
		if(count == list.size()) {//���� ������ ���ڰ� �࿭�� ũ��� ���� ���(�� ĭ�� �� ä������ ���)
			for(int i=0; i<9; i++) {
				for(int j=0; j<9; j++) { //��� ���ҵ� ��ĭ�� ���̿� �ΰ� ���
					System.out.print(map[i][j]+" ");
				}System.out.println(); //�� �ٿ� 9���� ���Ұ� ��µǸ� ���� ���Ҵ� �ٿ� �ٺ��� ���
			}
			System.exit(0); // ��� �� ����(���ϸ� ������� ��)
		}
			int x = list.get(count)[0];
			int y = list.get(count)[1];
			for(int i=1; i<=9; i++) {//�־��� �࿭�� �ݺ��ϸ鼭
				if(isPossible(x,y,i)) { //���Ҹ� �˻��ϴ� �޼ҵ带 ����ߴٸ�
					map[x][y] = i; //�ش� ���ڸ� �� �ڸ��� ����
					sudoku(count+1); // ��ͷ� ���� ��ҷ� �Ѿ
					map[x][y] = 0;//���� �ش��� ���� �ʴ´ٸ� �ٽ� 0���� ������Ŵ
				}
				
			}
		
	}
	
	public static boolean isPossible(int x, int y, int num) { //���� �˻� �޼ҵ�
		for(int i=0; i<9; i++) { //x��(��)�� ���� ���ڰ� �����Ѵٸ� false
			if(num == map[i][y]) return false;
		}
		for(int j=0; j<9; j++) { //y��(��)�� ���� ���ڰ� �����Ѵٸ� false
			if(num  == map[x][j]) return false;
		}
		
		//3*3 �簢�� �˻�
		int xx = x/3*3;
		int yy = y/3*3;
		
		for(int i=xx; i<xx+3; i++) {
			for(int j=yy; j<yy+3; j++) { //3*3 �簢�� �������� ��
				if(num == map[i][j]) return false; //�簢�� �ȿ� ���� ���Ұ� �����Ѵٸ� false
			}
		}
		return true; //�� �� ���� true ��ȯ
	}

}

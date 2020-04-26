import java.util.ArrayList;
import java.util.Scanner;

//https://www.acmicpc.net/problem/2580

public class Sudoku_miji {
	
	static int[][] map = new int[9][9]; //입력받는 행열의 크기
	static ArrayList<int[]> list = new ArrayList<>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scanner = new Scanner(System.in);
		
		for(int i=0; i<9; i++) {
			for(int j=0; j<9; j++) { //입력된 행열 순환
				if((map[i][j] = scanner.nextInt()) == 0) { // 입력값이 0이면
					list.add(new int[] {i,j}); //해당 값을 리스트에 삽입
				}
			}
		}
		sudoku(0); //메소드 호출
	}
	
	public static void sudoku(int count) {
		if(count == list.size()) {//만약 들어오는 인자가 행열의 크기와 같을 경우(빈 칸이 다 채워졌을 경우)
			for(int i=0; i<9; i++) {
				for(int j=0; j<9; j++) { //모든 원소들 빈칸을 사이에 두고 출력
					System.out.print(map[i][j]+" ");
				}System.out.println(); //한 줄에 9개의 원소가 출력되면 다음 원소는 다움 줄부터 출력
			}
			System.exit(0); // 출력 후 종료(안하면 무한출력 됨)
		}
			int x = list.get(count)[0];
			int y = list.get(count)[1];
			for(int i=1; i<=9; i++) {//주어진 행열을 반복하면서
				if(isPossible(x,y,i)) { //원소를 검사하는 메소드를 통과했다면
					map[x][y] = i; //해당 숫자를 그 자리에 대입
					sudoku(count+1); // 재귀로 다음 요소로 넘어감
					map[x][y] = 0;//만약 해당이 되지 않는다면 다시 0으로 복구시킴
				}
				
			}
		
	}
	
	public static boolean isPossible(int x, int y, int num) { //원소 검사 메소드
		for(int i=0; i<9; i++) { //x축(행)에 같은 숫자가 존재한다면 false
			if(num == map[i][y]) return false;
		}
		for(int j=0; j<9; j++) { //y축(열)에 같은 숫자가 존재한다면 false
			if(num  == map[x][j]) return false;
		}
		
		//3*3 사각형 검사
		int xx = x/3*3;
		int yy = y/3*3;
		
		for(int i=xx; i<xx+3; i++) {
			for(int j=yy; j<yy+3; j++) { //3*3 사각형 생성했을 때
				if(num == map[i][j]) return false; //사각형 안에 같은 원소가 존재한다면 false
			}
		}
		return true; //그 외 값은 true 반환
	}

}

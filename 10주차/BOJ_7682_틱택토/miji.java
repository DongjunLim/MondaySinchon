import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//https://www.acmicpc.net/problem/7682

/* 
 * 

	- O,X,.의 개수를 각각 구한다
	- .가 없다면 -> 아래의 조건을 만족 안하면  isValid = False
		1) X가 O보다 개수가 1개가 많은지 확인한다. 아니라면
		2) 3개의 연속된 O가 있다면

	- .가 짝수개 && 0이 아니라면 -> X가 이겨야 한다. 아래의 조건을 만족 안하면 isValid = False
	1) X가 O보다 개수가 1개 많은지 확인
	2) 연속된 3개의 X가 1개 있는지 확인
	3) 연속된 3개의 O가 0개 인지 확인
  
	- .가 홀개 -> O가 이겨야 한다. 아래의 조건을 만족 안하면 isValid = False
	1) O와 X의 개수가 같은지 확인
	2) 연속된 3개의 O가 1개 있는지 확인
	3) 연속된 3개의 X가 0개 인지 확인
 	* 
 	* 
 * */

public class Tictactoe {

	static boolean isValid;
	static char tictac[][];
	static int Xs; //X의 개수 
	static int Os; //O의 개수
	static char[] ch;
	static int remain;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		loop: while(true) { 
			String s = br.readLine(); 
			if(s.equals("end")) break loop; 
			ch = s.toCharArray();
			
			tictac = new char[3][3];
			Xs = 0;
			Os = 0;
			remain = 0;
			isValid = true;
			int count = 0;

			
			for(int i=0; i<3; i++) { //입력받기
				for(int j=0; j<3; j++) {
					tictac[i][j] = ch[count++];
					if(tictac[i][j] == 'X') Xs++; 
					else if(tictac[i][j] == 'O') Os++;
					else if (tictac[i][j] == '.') remain++;

				}
			}
			if(Math.abs(Xs - Os) > 1 || Os > Xs) { //없으면 런타임 에러 발생
				System.out.println("invalid"); 
				continue; 
			}

			
			if(remain == 0) { //맨 마지막수까지 둔 경우, 'O'3개가 연속되면 안됨
				if(Xs - 1 != Os) {
					isValid = false; //개수 비교
				}
				int result = check('O');
				if(result > 0) isValid = false;
			}else if(remain % 2 == 0 && remain!=0){ //X가 O보다 1개 더 많아야 하고 X가 이겨야함
				if(Xs - 1 != Os) { //개수 비교
					isValid = false;
				}
				int result = check('O');
				if (result > 0) isValid = false;
				result = check('X');
				if (result == 0) isValid = false;
			}else { //X와 O의 개수가 같을 때 O가 이김
				if(Xs != Os) isValid = false; //개수 비교
				int result = check('X');
				if (result > 0) isValid = false;
				result = check('O');
				if (result == 0) isValid = false;
			}
			
			if(isValid) { //출력
				System.out.println("valid"); 
			}
			else {
				System.out.println("invalid"); 
			}
		}
		
		

	}
	public static int check(char a) {
		int count = 0;
		
		for (int i = 0; i < 3; i++) { 
			//연속적으로 가로 3개가 같을 때
			if (tictac[i][0] == tictac[i][1] && tictac[i][1] == tictac[i][2]) {		//가로 3개 확인
				if (tictac[i][0] == a) count++;	
			}
			//연속적으로 세로 3개가 같을 때
			if (tictac[0][i] == tictac[1][i] && tictac[1][i] == tictac[2][i]) {		//세로 3개 확인
				if (tictac[0][i] == a) count++;
			}
		}
		//대각선 2개 확인
		if (tictac[0][0] == tictac[1][1] && tictac[1][1] == tictac[2][2]) {
			if (tictac[1][1] == a) count++;
		}
		
		if (tictac[0][2] == tictac[1][1] && tictac[1][1] == tictac[2][0]) {
			if (tictac[1][1] == a) count++;
		}
		
		return count;
	}

}

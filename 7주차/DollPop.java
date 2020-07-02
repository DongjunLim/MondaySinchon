import java.util.Stack;

//https://programmers.co.kr/learn/courses/30/lessons/64061

public class DollPop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//원소 선언
		int[][]board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
		int[] moves = {1,5,3,5,1,2,1,4}; //이동한 원소들의 배열
		int answer = 0; //사라진 인형의 개수
		Stack<Integer> stack = new Stack<>(); //옮겨진 원소들을 모아놓는 스택




		for(int j=0; j<moves.length; j++) { //열
			for(int i=0; i<board.length; i++) { //행
				if(board[i][moves[j]-1] != 0) {
					if(!stack.isEmpty() && stack.peek() == board[i][moves[j]-1] ) { //팝
						stack.pop(); 
						answer += 2;
					}else {
						stack.push(board[i][moves[j]-1]);
					}
					board[i][moves[j]-1] = 0;
					break;
				}
				
			}
		}
		System.out.println(answer);
	}
	
}





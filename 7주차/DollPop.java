import java.util.Stack;

//https://programmers.co.kr/learn/courses/30/lessons/64061

public class DollPop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//���� ����
		int[][]board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
		int[] moves = {1,5,3,5,1,2,1,4}; //�̵��� ���ҵ��� �迭
		int answer = 0; //����� ������ ����
		Stack<Integer> stack = new Stack<>(); //�Ű��� ���ҵ��� ��Ƴ��� ����




		for(int j=0; j<moves.length; j++) { //��
			for(int i=0; i<board.length; i++) { //��
				if(board[i][moves[j]-1] != 0) {
					if(!stack.isEmpty() && stack.peek() == board[i][moves[j]-1] ) { //��
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





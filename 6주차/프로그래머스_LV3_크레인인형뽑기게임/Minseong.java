package Algorithm.MondaySinchon.ProgrammersCrain;

import java.util.Stack;

class Solution {

    static Stack<Integer> stack;

    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        stack = new Stack<>();

        for (int i = 0; i < moves.length; i++) {

            for (int j = 0; j < board.length; j++) {

                if (board[j][moves[i] - 1] != 0) {

                    if (!stack.isEmpty()) {

                        if (stack.peek() == board[j][moves[i] - 1]) {

                            stack.pop();
                            answer += 2;
                        } else {
                            stack.push(board[j][moves[i] - 1]);
                        }
                    } else {
                        stack.push(board[j][moves[i] - 1]);
                    }
                    board[j][moves[i] - 1] = 0;
                    break;
                }
            }
        }
        return answer;
    }
}
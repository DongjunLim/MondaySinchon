/**
 *  @문제접근
 *  유효한 스도쿠인지 각각의 인덱스에서 조사했습니다.
 *
 *  @성능
 *  Runtime: 1 ms
 *  Memory Usage: 39.1 MB
 *  시간복잡도: O(N^2)
 */

class Solution36 {
    public boolean isValidSudoku(char[][] board) {

        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] != '.' && !isPossibleNumber(0, i, j, board))
                    return false;
            }
        }

        return true;
    }


    public boolean isPossibleNumber(int num, int row, int col, char[][] board){
        int r = -1, c = -1;

        int[] numberCnt = new int[10];

        while(++r < 9){
            if(board[r][col] != '.' && ++numberCnt[board[r][col]-'0'] > 1)
                return false;
        }

        Arrays.fill(numberCnt, 0);

        while(++c < 9){
            if(board[row][c] != '.' && ++numberCnt[board[row][c]-'0'] > 1)
                return false;
        }

        int rowRange = (row / 3) * 3, colRange = (col / 3) * 3;


        Arrays.fill(numberCnt, 0);

        for(int i = rowRange; i < rowRange + 3; i++){
            for(int j = colRange; j < colRange + 3; j++){
                if(board[i][j] != '.' && ++numberCnt[board[i][j]-'0'] > 1)
                    return false;
            }
        }

        return true;
    }
}

package Algorithm.MondaySinchon.ProgrammersChange;

class Solution {

    static long dp[][];

    public int solution(int n, int[] money) {

        dp = new long[101][100001];
        dp[0][0] = 1;

        for (int i = money[0]; i <= n; i+= money[0]){
            dp[0][i] = 1;
        }

        for (int i = 0 ; i < money.length; i++){
            for (int j = 0; j <= n; j++){
                if (j >= money[i]){
                    dp[i][j] += dp[i][j - money[i]] % 1000000007;
                }
            }
        }
        int answer = (int) dp[money.length - 1][n];
        return answer;
    }
}
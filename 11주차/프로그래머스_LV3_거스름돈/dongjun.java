/**
 *  @문제접근
 *  동적계획법으로 풀었습니다.
 *  각각의 거스름돈을 줄때의 경우의 수를 구해
 *  순서대로 더했습니다.
 *
 */

package ps.programmers;

import java.util.Arrays;

public class LV3_거스름돈 {
    public static void main(String[] args){
        int n = 10;
        int[] money = {2, 1};

        System.out.println(solve(n, money));
    }

    private static int solve(int n, int[] money) {
        int[] dp = new int[n+1];

        dp[0] = 1;

        for(int m: money){
            for(int i = 1; i <= n; i++){
                if(i >= m)
                    dp[i] += dp[i-m] % 1000000007;
            }
        }

        return dp[n];
    }
}

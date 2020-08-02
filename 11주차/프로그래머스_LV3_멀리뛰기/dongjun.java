/**
 * @문제접근
 * 동적계획법으로 풀었습니다.
 * 2칸을 뛰거나, 1칸을 뛸 수 있기 때문에,
 * n번째 칸에서의 경우의 수는
 * n-2번째 칸에서의 경우의 수 + n-1번째 칸에서의 경우의 수 입니다.
 * 
 */
package ps.programmers;

public class LV3_멀리뛰기 {
    public static void main(String[] args){
        int n = 200;

        System.out.println(solve(n));
    }

    private static long solve(int n) {
        final int MOD = 1234567;
        int[] dp = new int[n+3];
        
        // 기저사례
        dp[1] = 1;
        dp[2] = 2;

        for(int i=3; i<dp.length; i++)
            dp[i] = dp[i-1] % MOD + dp[i-2] % MOD;

        return dp[n] % MOD;
    }
}

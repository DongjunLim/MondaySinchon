/**
 * @��������
 * ������ȹ������ Ǯ�����ϴ�.
 * 2ĭ�� �ٰų�, 1ĭ�� �� �� �ֱ� ������,
 * n��° ĭ������ ����� ����
 * n-2��° ĭ������ ����� �� + n-1��° ĭ������ ����� �� �Դϴ�.
 * 
 */
package ps.programmers;

public class LV3_�ָ��ٱ� {
    public static void main(String[] args){
        int n = 200;

        System.out.println(solve(n));
    }

    private static long solve(int n) {
        final int MOD = 1234567;
        int[] dp = new int[n+3];
        
        // �������
        dp[1] = 1;
        dp[2] = 2;

        for(int i=3; i<dp.length; i++)
            dp[i] = dp[i-1] % MOD + dp[i-2] % MOD;

        return dp[n] % MOD;
    }
}

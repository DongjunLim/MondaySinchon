/**
 *  @��������
 *  ������ȹ������ Ǯ�����ϴ�.
 *  ������ �Ž������� �ٶ��� ����� ���� ����
 *  ������� ���߽��ϴ�.
 *
 */

package ps.programmers;

import java.util.Arrays;

public class LV3_�Ž����� {
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

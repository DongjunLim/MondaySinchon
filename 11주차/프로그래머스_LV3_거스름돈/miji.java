import java.util.*;

class Solution {
    public int solution(int n, int[] money) {
     
        int[] dp = new int[n+1];
        Arrays.sort(money);
        
        //처음에는 거스름돈을 내어주는 방법은 모두 1원으로 주는 1가지 방법
        dp[0] = 1;

        //그 다음부턴 j%money[i] = 0인 방법에 자기 j-money[i]를 만드는 경우의 수를 더해줌
        for(int i=0; i<money.length; i++){
            for(int j=money[i]; j<=n; j++){
                dp[j] = dp[j]+dp[j-money[i]];
            }
        }
        //?
        return dp[n] % 1000000007;
    }
}

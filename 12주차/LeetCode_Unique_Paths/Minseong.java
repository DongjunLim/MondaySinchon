package Algorithm.MondaySinchon.LeetUniquePaths;

import java.math.BigInteger;

class Solution {

    static public int uniquePaths(int m, int n) {

        BigInteger temp;

        BigInteger divider1;
        BigInteger divider2;

        BigInteger dividedNum = fact(m + n - 2);
        if (m == 1) {
            divider1 = BigInteger.valueOf(1);
        } else {
            divider1 = fact(m - 1);
        }

        if (n == 1) {
            divider2 = BigInteger.valueOf(1);
        } else {
            divider2 = fact(n - 1);
        }

        if (m + n - 2 == 0) {
            return 1;
        }

        dividedNum = dividedNum.divide(divider1);
        dividedNum = dividedNum.divide(divider2);

        return dividedNum.intValue();
    }

    static public BigInteger fact(int l) {
        BigInteger fac = BigInteger.ONE;

        for (int i = 1; i <= l; i++){
            fac = fac.multiply(BigInteger.valueOf(i));
        }
        return fac;
    }

}

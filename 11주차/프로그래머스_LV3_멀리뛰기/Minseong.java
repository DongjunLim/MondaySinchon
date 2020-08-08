package Algorithm.MondaySinchon.ProgrammersLongJump;

class Solution {

    static long a;
    static long b;

    public long solution(int n) {

        a = 1;
        b = 1;

        long temp;

        if (n == 1){
            return 1;
        }
        else {
            for (int i = 2; i <= n; i++){

                temp = (a + b) % 1234567;
                a = b;
                b = temp;
            }
        }

        return b % 1234567;
    }
}
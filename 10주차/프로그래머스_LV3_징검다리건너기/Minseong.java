package Algorithm.MondaySinchon.ProgrammersStepStone;

//1. 처음부터 k개
//2. 두번째부터 k개
//....
//3. n-k개부터 k개
// 각 최대값을 구한뒤 최대값끼리 비교한뒤 최소값을 구하기
class Solution {

    public int solution(int[] stones, int k) {

        int min = Integer.MAX_VALUE;

        for (int i = 0; i <= stones.length - k;) {

            int max = stones[i];
            int idx = 0;

            for (int j = i + 1; j < i + k; j++) {
                if (stones[j] >= max) {
                    idx = j;
                    max = stones[j];
                }
            }

            if (idx == 0) {
                i++;
            } else {
                i = (idx + 1);
            }
            min = Math.min(min, max);
        }
        return min;
    }
}
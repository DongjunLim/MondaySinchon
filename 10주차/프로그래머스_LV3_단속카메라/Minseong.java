package Algorithm.MondaySinchon.ProgrammersSpeedCamera;

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int solution(int[][] routes) {


        int answer = 0;

        Arrays.sort(routes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int min = routes[0][0];
        int max = routes[0][1];

        for (int i = 0; i < routes.length; i++){
            int in = routes[i][0];
            int out = routes[i][1];

            if (in > max || out < min){

                answer++;
                min = in;
                max = out;
            }
            else {
                min = in > min ? in : min;
                max = max > out ? out : max;
            }
        }

        return (answer + 1);
    }
}
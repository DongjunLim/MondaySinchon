package Algorithm.Spring.SWEA9088;

import java.io.*;
import java.util.StringTokenizer;

public class Solution {

    static BufferedReader bufferedReader;
    static BufferedWriter bufferedWriter;
    static StringTokenizer stringTokenizer;
    static int TC, N, K, max, min, current, answer;
    static int array[];

    public static void main(String[] args) throws IOException {

        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        TC = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < TC; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            N = Integer.parseInt(stringTokenizer.nextToken());
            K = Integer.parseInt(stringTokenizer.nextToken());

            array = new int[10001];
            max = Integer.MIN_VALUE;
            min = Integer.MAX_VALUE;

            for (int j = 0; j < N; j++) {

                current = Integer.parseInt(bufferedReader.readLine());

                if (current < min) {
                    min = current;
                }
                if (current > max) {
                    max = current;
                }
                array[current]++;

            }

            answer = 0;
            for (int j = min; j < max + 1; ++j) {
                int sum = 0;
                for (int k = j; k < (j + N + 1 > 10001 ? 10001 : i + N + 1); ++k) {
                    sum += array[k];
                }
                if (sum > answer) {
                    answer = sum;
                }
            }
            bufferedWriter.write("#" + (i + 1) + " " + answer + "\n");
        }
        bufferedWriter.flush();
    }
}

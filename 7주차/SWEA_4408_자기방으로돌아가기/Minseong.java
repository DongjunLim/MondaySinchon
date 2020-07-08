package Algorithm.MondaySinchon.SWEA4408;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

    static int corridor[];

    static BufferedReader bufferedReader;
    static BufferedWriter bufferedWriter;
    static StringTokenizer stringTokenizer;

    static int T, N, start, end, time = 0;
    public static void main(String[] args) throws IOException {

        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        T = Integer.parseInt(bufferedReader.readLine().trim());


        for (int i = 0 ; i < T; i++) {

            corridor = new int[201];
            Arrays.fill(corridor, 0);
            N = Integer.parseInt(bufferedReader.readLine().trim());

            for (int j = 0; j < N ; j++){
                stringTokenizer = new StringTokenizer(bufferedReader.readLine());

                start = Integer.parseInt(stringTokenizer.nextToken()) / 2;
                end = Integer.parseInt(stringTokenizer.nextToken()) / 2;

                if (start % 2 != 0){
                    start++;
                }
                if (end % 2 != 0){
                    end++;
                }
                for (int k = 0 ; k <= Math.abs(start - end); k++){
                    corridor[start + k] += 1;
                }
            }
            for (int j = 0; j < corridor.length; j++){
                time = Math.max(time, corridor[j]);
            }
            bufferedWriter.write("#" + (i + 1) + " " + time + "\n");
        }
        bufferedWriter.flush();
    }
}

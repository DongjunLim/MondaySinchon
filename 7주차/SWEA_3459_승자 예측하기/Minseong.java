package Algorithm.MondaySinchon.SWEA3459;

import java.io.*;

public class Solution {


    static BufferedReader bufferedReader;
    static BufferedWriter bufferedWriter;

    static int T;
    static long N, temp, sum;
    static boolean flag;


    public static void main(String[] args) throws IOException {


        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        T = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < T; i++){

            N = Long.parseLong(bufferedReader.readLine());

            temp = 1;
            sum = 1;
            flag = false;
            while (sum < N){
                if (!flag){
                    temp *= 4;

                }

                sum += temp;
                flag = !flag;
            }

            bufferedWriter.write("#" + (i + 1) + " " + (flag ? "Alice" : "Bob") + "\n");
        }
        bufferedWriter.flush();
    }
}

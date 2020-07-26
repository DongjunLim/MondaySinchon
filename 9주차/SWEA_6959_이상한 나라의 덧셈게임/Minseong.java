package Algorithm.MondaySinchon.SWEA6959;

import java.io.*;
import java.util.Stack;

public class Solution {

    static Stack<Integer> stack;

    static BufferedReader bufferedReader;
    static BufferedWriter bufferedWriter;


    static int T, current, next, sum, answer;
    static String num;

    public static void main(String[] args) throws IOException {

        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        T = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < T; i++) {

            answer = 0;

            stack = new Stack<>();
            num = bufferedReader.readLine();

            for (int j = 0; j < num.length(); j++) {
                stack.push(Integer.parseInt(num.substring(j, j + 1)));
            }

            while (stack.size() != 1) {

                current = stack.pop();
                next = stack.pop();
                sum = current + next;

                while (true) {
                    answer++;
                    if (sum < 10) {
                        break;
                    }
                    sum = Integer.parseInt((sum + "").substring(0, 1))
                            + Integer.parseInt((sum + "").substring(1, 2));
                }
                stack.push(sum);

            }
            if (answer % 2 != 0) {
                bufferedWriter.write("#" + (i + 1) + " A\n");
            } else {
                bufferedWriter.write("#" + (i + 1) + " B\n");
            }
        }
        bufferedWriter.flush();

    }
}

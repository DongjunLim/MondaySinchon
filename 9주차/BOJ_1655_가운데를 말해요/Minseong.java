package Algorithm.MondaySinchon.BOJ1655;

import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {

    static int N, num, temp;


    static PriorityQueue<Integer> left;
    static PriorityQueue<Integer> right;

    static BufferedReader bufferedReader;
    static BufferedWriter bufferedWriter;


    public static void main(String[] args) throws IOException {

        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        left = new PriorityQueue<>();
        right = new PriorityQueue<>(Collections.reverseOrder());

        N = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < N; i++) {

            num = Integer.parseInt(bufferedReader.readLine());

            if (left.size() == right.size()) {
                right.offer(num);
            } else {
                left.offer(num);
            }

            if (!left.isEmpty() && !right.isEmpty()) {
                if (left.peek() < right.peek()) {
                    temp = left.poll();
                    left.offer(right.poll());
                    right.offer(temp);
                }

            }
            bufferedWriter.write(right.peek() + "\n");

        }
        bufferedWriter.flush();
    }
}

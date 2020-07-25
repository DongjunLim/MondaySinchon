package Algorithm.MondaySinchon.SWEA1808;

//말도 안되게 어려움....
//dfs로 이정도까지...????
//https://hoho325.tistory.com/123


import java.io.*;
import java.util.StringTokenizer;

public class Solution {

    static BufferedReader bufferedReader;
    static BufferedWriter bufferedWriter;
    static StringTokenizer stringTokenizer;

    static int T, num, x, min;
    static int array[];

    public static void main(String[] args) throws IOException {

        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        T = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < T; i++) {

            array = new int[10];
            min = Integer.MAX_VALUE;

            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < 10; j++) {
                array[j] = Integer.parseInt(stringTokenizer.nextToken());

            }
            num = Integer.parseInt(bufferedReader.readLine());

            x = check(num);

            if (x != 0) {
                x += 1;
                bufferedWriter.write("#" + (i + 1) + " " + x + "\n");
                continue;
            }

            dfs(num, 0);

            if (min == Integer.MAX_VALUE) {
                min = -1;
            } else {
                min += 1;
            }
            bufferedWriter.write("#" + (i + 1) + " " + min + "\n");
        }

        bufferedWriter.flush();
        bufferedWriter.close();
    }

    public static int check(int num) {

        int cipher = 0;
        int length = 1;

        if (num >= 10) {
            while (true) {
                cipher = num % 10;
                num /= 10;
                length++;

                if (array[cipher] == 0) {
                    return 0;
                }
                if (num < 10) {
                    break;
                }
            }

        }
        if (array[num] == 0) {
            return 0;
        }

        return length;
    }

    public static int dfs(int num, int d) {

        int answer = Integer.MAX_VALUE;
        int x = check(num);

        if (x != 0) {
            return x;
        }

        for (int i = 2, last = (int) Math.sqrt(num) + 1; i < last; i++) {

            if (num % i == 0) {
                int y = check(i);

                if (y != 0) {

                    y = y + 1;
                    x = dfs(num / i, d + 1);

                    if (x != Integer.MAX_VALUE) {

                        int z = x + y;

                        if (z < answer) {
                            answer = z;
                        }

                        if (answer < min && num == Solution.num) {
                            min = answer;
                        }
                    }
                }
            }
        }
        return answer;
    }
}

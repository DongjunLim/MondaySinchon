package Algorithm.MondaySinchon.SWEA1868_2;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    static Queue<Integer> queue;

    static int dx[] = {1, 1, 1, -1, -1, -1, 0, 0};
    static int dy[] = {-1, 1, 0, 0, -1, 1, -1, 1};

    static BufferedReader bufferedReader;
    static BufferedWriter bufferedWriter;

    static int T, N, count;
    static char map[][];
    static boolean visited[][];

    public static void main(String[] args) throws IOException {

        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        T = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(bufferedReader.readLine());

            queue = new LinkedList<>();
            map = new char[N][N];
            visited = new boolean[N][N];

            for (int j = 0; j < N; j++) {
                map[j] = bufferedReader.readLine().toCharArray();
            }

            for (int j = 0; j < N; j++) {

                for (int k = 0; k < N; k++) {
                    if (map[j][k] != '.') {
                        continue;
                    }
                    int mine = 0;

                    for (int l = 0; l < dx.length; l++) {

                        int xx = j + dx[l];
                        int yy = k + dy[l];

                        if (isRange(xx, yy) && map[xx][yy] == '*') {
                            mine++;
                        }
                    }
                    if (mine == 0) {
                        queue.add(j);
                        queue.add(k);
                        solve();
                    }
                }

            }
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (map[j][k] == '.') {
                        count++;
                    }
                }
            }


            bufferedWriter.write("#" + (i + 1) + " " + count + "\n");
            count = 0;
        }
        bufferedWriter.flush();
    }


    static void solve() {
        count++;
        while (!queue.isEmpty()) {

            int x = queue.poll();
            int y = queue.poll();

            int mine = 0;

            for (int i = 0; i < dx.length; i++) {

                int xx = x + dx[i];
                int yy = y + dy[i];

                if (isRange(xx, yy)) {
                    if (map[xx][yy] == '*') {
                        mine++;
                    }
                }
            }

            if (mine == 0) {
                map[x][y] = 'x';

                for (int i = 0; i < dx.length; i++) {
                    int xx = x + dx[i];
                    int yy = y + dy[i];

                    if (!isRange(xx, yy) ||
                            map[xx][yy] != '.' | visited[xx][yy]) {
                        continue;
                    }
                    visited[xx][yy] = true;

                    queue.add(xx);
                    queue.add(yy);
                }
            } else {
                map[x][y] = 'x';
            }
        }
    }

    static boolean isRange(int x, int y){
        if (x < 0 || x >= N || y < 0 || y >= N){
            return false;
        }
        return true;
    }
}

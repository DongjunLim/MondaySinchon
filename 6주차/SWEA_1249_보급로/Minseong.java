package Algorithm.MondaySinchon.SWEA1249;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

class Node {

    int x, y;

    Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Solution {

    static Queue<Node> queue;

    static int T, N, min;
    static String s[];

    static int dx[] = {1, -1, 0, 0};
    static int dy[] = {0, 0, 1, -1};

    static int map[][];
    static int time[][];
    static boolean visited[][];

    static BufferedReader bufferedReader;
    static BufferedWriter bufferedWriter;


    public static void main(String[] args) throws IOException {

        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        T = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(bufferedReader.readLine());

            map = new int[N][N];
            time = new int[N][N];
            visited = new boolean[N][N];

            for (int j = 0; j < N; j++) {
                s = bufferedReader.readLine().split("");
                for (int k = 0; k < N; k++) {
                    map[j][k] = Integer.parseInt(s[k]);
                }
            }

            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    time[j][k] = Integer.MAX_VALUE;
                }
            }

            time[0][0] = 0;

            bfs(0, 0);

            System.out.println(min);
        }

    }

    public static void bfs(int x, int y) {
        queue = new LinkedList<>();

        queue.offer(new Node(0, 0));
        visited[x][y] = true;

        while (!queue.isEmpty()) {

            Node node = queue.poll();
            int a = node.x;
            int b = node.y;

            if (a == N - 1 && b == N - 1) {
                min = min > time[N - 1][N - 1] ? time[N - 1][N - 1] : min;
            }

            if (min <= time[a][b]) {
                continue;
            }

            for (int j = 0; j < dx.length; j++) {

                int xx = a + dx[j];
                int yy = b + dy[j];

                if (xx >= 0 && xx < N && yy >= 0 && yy < N) {

                    if (!visited[xx][yy] || time[xx][yy] > time[a][b] + map[xx][yy]) {

                        visited[xx][yy] = true;
                        time[xx][yy] = time[x][y] + map[xx][yy];

                        queue.offer(new Node(xx, yy));
                    }
                }
            }
        }
    }

}

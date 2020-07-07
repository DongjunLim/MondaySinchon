package Algorithm.MondaySinchon.SWEA1861;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


class Node {

    int x, y;

    Node(int x, int y) {
        this.x = x;
        this.y = y;

    }
}

public class Solution {

    static Queue<Node> queue;

    static BufferedReader bufferedReader;
    static BufferedWriter bufferedWriter;
    static StringTokenizer stringTokenizer;

    static int TC, N, length, max, min;
    static int dx[] = {1, -1, 0, 0};
    static int dy[] = {0, 0, 1, -1};
    static int map[][];

    static boolean visited[][];


    public static void main(String[] args) throws IOException {

        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        TC = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < TC; i++) {

            max = Integer.MIN_VALUE;
            min = Integer.MAX_VALUE;
            N = Integer.parseInt(bufferedReader.readLine());
            map = new int[N][N];

            for (int j = 0; j < N; j++) {
                stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                for (int k = 0; k < N; k++) {
                    map[j][k] = Integer.parseInt(stringTokenizer.nextToken());
                }
            }

            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    length = 0;
                    visited = new boolean[N][N];
                    bfs(j, k);

                    if (max < length) {
                        max = length;
                        min = map[j][k];
                    }
                    if (max == length && min > map[j][k]) {
                        min = map[j][k];
                    }
                }
            }

            bufferedWriter.write("#" + (i + 1) + " " + min + " " + max + " \n");
        }
        bufferedWriter.flush();


    }

    public static void bfs(int x, int y) {

        queue = new LinkedList<>();
        visited[x][y] = true;

        queue.offer(new Node(x, y));

        while (!queue.isEmpty()) {

            length++;
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                x = node.x;
                y = node.y;

                for (int j = 0; j < dx.length; j++) {

                    int xx = x + dx[j];
                    int yy = y + dy[j];

                    if (xx >= 0 && xx < N && yy >= 0 && yy < N) {

                        if (!visited[xx][yy] && map[xx][yy] == map[x][y] + 1) {
                            queue.offer(new Node(xx, yy));
                            visited[xx][yy] = true;
                        }
                    }
                }
            }

        }

    }
}

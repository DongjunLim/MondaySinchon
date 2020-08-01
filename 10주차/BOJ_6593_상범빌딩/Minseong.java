package Algorithm.MondaySinchon.BOJ6593;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {

    int x, y, z, count;

    public Node(int z, int x, int y, int count) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.count = count;
    }

}

public class Main {

    static Queue<Node> queue;

    static BufferedReader bufferedReader;
    static BufferedWriter bufferedWriter;
    static StringTokenizer stringTokenizer;

    static int L, R, C;
    static char map[][][];
    static boolean flag;
    static boolean visited[][][];

    static int dx[] = {1, -1, 0, 0, 0, 0};
    static int dy[] = {0, 0, 1, -1, 0, 0};
    static int dz[] = {0, 0, 0, 0, 1, -1};

    static String s;

    public static void main(String[] args) throws IOException {

        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        while (true) {
            queue = new LinkedList<>();
            flag = false;


            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            L = Integer.parseInt(stringTokenizer.nextToken());
            R = Integer.parseInt(stringTokenizer.nextToken());
            C = Integer.parseInt(stringTokenizer.nextToken());

            if (L == 0 && R == 0 && C == 0) {
                bufferedWriter.flush();
                break;
            }

            map = new char[L][R][C];
            visited = new boolean[L][R][C];

            for (int i = 0; i < L; i++) {
                for (int j = 0; j < R; j++) {
                    s = bufferedReader.readLine();
                    for (int k = 0; k < C; k++) {
                        map[i][j][k] = s.charAt(k);
                        if (s.charAt(k) == 'S') {
                            queue.offer(new Node(i, j, k, 0));
                        }
                    }
                }
                bufferedReader.readLine();
            }
            bfs();
            if (flag == false) {
                bufferedWriter.write("Trapped!\n");
            }
        }
    }

    public static void bfs() throws IOException {

        while (!queue.isEmpty()) {

            Node node = queue.poll();
            int z = node.z;
            int x = node.x;
            int y = node.y;
            int count = node.count;

            for (int i = 0; i < dx.length; i++) {
                int zz = z + dz[i];
                int yy = y + dy[i];
                int xx = x + dx[i];

                if (zz >= 0 && zz < L && xx >= 0 && xx < R && yy >= 0 && yy < C) {
                    if (map[zz][xx][yy] == '.' && !visited[zz][xx][yy]) {
                        node = new Node(zz, xx, yy, count + 1);
                        visited[zz][xx][yy] = true;
                        queue.offer(node);
                    } else if (map[zz][xx][yy] == 'E') {
                        flag = true;
                        bufferedWriter.write("Escaped in " + String.valueOf(count + 1) + " minute(s).\n");
                        queue.clear();
                        break;
                    }
                }
            }

        }


    }
}

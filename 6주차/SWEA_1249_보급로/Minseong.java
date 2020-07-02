package Algorithm.MondaySinchon.SWEA7699;

import java.io.*;
import java.util.StringTokenizer;

public class Solution {

    static final int ALPHABET_NUM = 26;

    static boolean aVisited[];
    static boolean visited[][];
    static char map[][];
    static int dx[] = {1, -1, 0, 0};
    static int dy[] = {0, 0, 1, -1};

    static int T, R, C, count;
    static String s;

    static BufferedReader bufferedReader;
    static BufferedWriter bufferedWriter;
    static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {

        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        T = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < T; i++) {

            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            R = Integer.parseInt(stringTokenizer.nextToken());
            C = Integer.parseInt(stringTokenizer.nextToken());

            count = 0;
            map = new char[R][C];
            visited = new boolean[R][C];
            aVisited = new boolean[ALPHABET_NUM];


            for (int j = 0; j < R; j++) {

                s = bufferedReader.readLine();

                for (int k = 0; k < C; k++) {

                    map[j][k] = s.charAt(k);

                }
            }

            visited[0][0] = true;
            aVisited[map[0][0] - 'A'] = true;
            dfs(0, 0, 1);
            System.out.println("#" + (i + 1) + " " + count);

        }
    }

    public static void dfs(int x, int y, int depth) {

        for (int i = 0; i < dx.length; i++) {

            int xx = x + dx[i];
            int yy = y + dy[i];

            if (xx >= 0 && xx < R && yy >= 0 && yy < C){
                if (visited[xx][yy]){
                    continue;
                }
                if (!aVisited[map[xx][yy] - 'A']){
                    visited[xx][yy] = true;
                    aVisited[map[xx][yy] - 'A'] = true;
                    dfs(xx, yy, depth + 1);
                    visited[xx][yy] = false;
                    aVisited[map[xx][yy] - 'A'] = false;

                }
            }

        }

        count = count < depth ? depth : count;

    }
}
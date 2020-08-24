package Algorithm.MondaySinchon.BOJ1238;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static PriorityQueue<Integer> priorityQueue;

    static BufferedReader bufferedReader;
    static BufferedWriter bufferedWriter;
    static StringTokenizer stringTokenizer;

    static int N, M, X, start, end, weigh, maxDist;
    static int[][] map;
    static int[][] revMap;
    static int[] dist;
    static int[] revDist;

    public static void main(String[] args) throws IOException {

        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());
        X = Integer.parseInt(stringTokenizer.nextToken()) - 1;


        maxDist = Integer.MIN_VALUE;

        map = new int[N][N];
        revMap = new int[N][N];
        dist = new int[N];
        revDist = new int[N];
        maxInt(map, revMap, dist, revDist, N);

        for (int i = 0; i < M; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            start = Integer.parseInt(stringTokenizer.nextToken()) - 1;
            end = Integer.parseInt(stringTokenizer.nextToken()) - 1;
            weigh = Integer.parseInt(stringTokenizer.nextToken());
            map[start][end] = revMap[end][start] = weigh;
        }

        dijk(X, map, dist, N);
        dijk(X, revMap, revDist, N);

        for (int i = 0; i < N; i++) {
            if (maxDist < dist[i] + revDist[i]) {
                maxDist = dist[i] + revDist[i];
            }
        }

        bufferedWriter.write(String.valueOf(maxDist));
        bufferedWriter.flush();
    }

    public static void dijk(int start, int map[][], int dist[], int n) {

        priorityQueue = new PriorityQueue<>();

        priorityQueue.offer(start);
        map[start][start] = 0;
        dist[start] = 0;

        while (!priorityQueue.isEmpty()) {
            int x = priorityQueue.poll();
            for (int i = 0; i < n; i++) {
                if (dist[i] > map[x][i] + dist[x]) {
                    dist[i] = map[x][i] + dist[x];
                    priorityQueue.offer(i);
                }
            }
        }

    }

    public static void maxInt(int map[][], int revMap[][], int dist[], int revDist[], int N) {
        for (int i = 0; i < N; i++) {
            dist[i] = revDist[i] = 10000001;
            for (int j = 0; j < N; j++) {
                map[i][j] = revMap[i][j] = 10000001;
            }
        }
    }
}

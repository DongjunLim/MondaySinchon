package Algorithm.MondaySinchon.BOJ14890;

import java.io.*;
import java.util.StringTokenizer;

public class Main {


    static BufferedReader bufferedReader;
    static BufferedWriter bufferedWriter;
    static StringTokenizer stringTokenizer;

    static int N, L;
    static int map[][];
    static int count = 0;



    public static void main(String[] args) throws IOException {

        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        N = Integer.parseInt(stringTokenizer.nextToken());
        L = Integer.parseInt(stringTokenizer.nextToken());

        map = new int[N][N];

        for (int i = 0; i < N; i++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            for (int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(stringTokenizer.nextToken());

            }
        }

        for (int i = 0; i < N; i++){
            if (check(i, 0, 0)) {
                count++;
            }
            if (check(0, i ,1)){
                count++;
            }
        }

        System.out.println(count);
    }

    public static boolean check(int x, int y, int d){

        boolean visited[] = new boolean[N];
        int height[] = new int[N];

        for (int i = 0; i < N; i++){

            height[i] = (d == 0) ? map[x][y + i] : map[x + i][y];
        }

        for (int i = 0; i < N - 1; i++){
            if (height[i] == height[i + 1]){
                continue;
            }
            if (Math.abs(height[i] - height[i + 1]) > 1){
                return false;
            }

            if (height[i] - 1 == height[i + 1]){
                for (int j = i + 1; j <= i + L; j++){
                    if (j >= N || visited[j] || height[j] != height[i + 1]){
                        return false;
                    }
                    visited[j] = true;
                }
            }
            else if (height[i] + 1 == height[i + 1]){
                for (int j = i; j > i - L; j--){
                    if (j < 0 || visited[j] || height[j] != height[i]){
                        return false;
                    }
                    visited[j] = true;
                }
            }
        }

        return true;
    }
}

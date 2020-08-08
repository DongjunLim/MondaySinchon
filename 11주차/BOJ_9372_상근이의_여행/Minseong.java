package Algorithm.MondaySinchon.BOJ9372;

import java.io.*;
import java.util.StringTokenizer;

//MST : 최소 신장 트리
//MST에선 노드의 간선의 가중치에 따라 탐색 우선순위를 둔다
//단, 이번 문제에선 간선(비행기 경로)의 가중치가 없으며,
//문제 조건에서 "항상 연결 그래프를 이룬다" 라는 조건이 있다.
//즉, MST의 알고리즘에서 간선의 갯수는 Node-1 라는 걸 이용하면
//이 문제는 알고리즘을 사용하지 않고, 단순히 node의 갯수에서 1을 빼면 된다.


public class Main {

    static BufferedReader bufferedReader;
    static BufferedWriter bufferedWriter;
    static StringTokenizer stringTokenizer;

    static int T, N, M, node1, node2;

    public static void main(String[] args) throws IOException {


        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        T = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < T; i++){

            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            N = Integer.parseInt(stringTokenizer.nextToken());
            M = Integer.parseInt(stringTokenizer.nextToken());

            for (int j = 0; j < M; j++){
                stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                node1 = Integer.parseInt(stringTokenizer.nextToken());
                node2 = Integer.parseInt(stringTokenizer.nextToken());

            }

            bufferedWriter.write((N - 1) + "\n");
        }
        bufferedWriter.flush();
    }
}

// https://blog.naver.com/PostView.nhn?blogId=1ilsang&logNo=221470205431&categoryNo=0&parentCategoryNo=0&viewDate=&currentPage=1&postListTopCurrentPage=1&from=postView
// 참고해도 어려움...

package Algorithm.MondaySinchon.SWEA1251;

import java.io.*;
import java.util.Arrays;


public class Solution {

    static class Node implements Comparable<Node> {

        int x, y;
        long z;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Node o) {
            return Long.compare(this.z, o.z);
        }
    }

    public static int find(int a) {
        if (parents[a] < 0) {
            return a;
        }
        return parents[a] = find(parents[a]);
    }

    static boolean union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);

        if (aRoot != bRoot) {
            parents[bRoot] = aRoot;
            return true;
        }
        return false;
    }

    static BufferedReader bufferedReader;
    static BufferedWriter bufferedWriter;

    static String tempX[], tempY[];
    static int parents[];
    static Node nodes[], lines[];

    static int TC, N;


    public static void main(String[] args) throws IOException {

        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        TC = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < TC; i++) {

            double answer = 0;
            N = Integer.parseInt(bufferedReader.readLine());

            parents = new int[N];
            nodes = new Node[N];
            lines = new Node[N * N];

            tempX = bufferedReader.readLine().split(" ");
            tempY = bufferedReader.readLine().split(" ");

            for (int j = 0; j < N; j++) {
                nodes[j] = new Node(Integer.parseInt(tempX[j]), Integer.parseInt(tempY[j]));

            }
            double z = Double.parseDouble(bufferedReader.readLine());

            int count = 0;
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {

                    lines[count] = new Node(j, k);
                    lines[count++].z = (long) (nodes[j].x - nodes[k].x) * (nodes[j].x - nodes[k].x)
                            + (long) (nodes[j].y - nodes[k].y) * (nodes[j].y - nodes[k].y);
                }
            }

            Arrays.sort(lines);
            Arrays.fill(parents, -1);

            for (int j = 0; j < lines.length; j++) {
                Node node = lines[j];

                if (node.z == 0) {
                    continue;
                }
                if (union(node.x, node.y)) {
                    answer += node.z;
                }
            }

            answer *= z;
            bufferedWriter.write("#" + (i + 1) + " " + Math.round(answer) + "\n");
        }
        bufferedWriter.flush();
    }
}

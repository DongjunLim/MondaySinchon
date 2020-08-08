package Algorithm.MondaySinchon.BOJ2887;

// MST, 크루스칼
//어렵다....
//https://toastfactory.tistory.com/215 참조
//워스트케이스인 N이 10만개일때 시간초과가 발생
//간선을 최소화해야함
//간선의 가중치를 직접 계산해가야함

//입력받은 값을 nodes 배열에 넣고
//x, y, z를 각 Comparator 에 맞게 정렬
//간선정보를 담는 edges ArrayList에 넣음
//거리를 오름차순으로 정렬
//크루스칼 알고리즘으로 최소경로를 이어가면서 result에 누

import java.io.*;
import java.util.*;

class Node {

    int x, y, z, idx;

    public Node(int x, int y, int z, int idx) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.idx = idx;
    }

}

class Edge {

    public Edge(int s, int e, int v) {
        this.s = s;
        this.e = e;
        this.v = v;
    }

    int s, e, v;

}

public class Main {

    static BufferedReader bufferedReader;
    static BufferedWriter bufferedWriter;
    static StringTokenizer stringTokenizer;

    static int N;
    static int x, y, z;
    static int answer[];
    static Node[] nodes;
    static ArrayList<Edge> edges;


    public static void main(String[] args) throws IOException {

        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(bufferedReader.readLine());

        nodes = new Node[N];
        edges = new ArrayList<>();
        answer = new int[N + 1];

        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            x = Integer.parseInt(stringTokenizer.nextToken());
            y = Integer.parseInt(stringTokenizer.nextToken());
            z = Integer.parseInt(stringTokenizer.nextToken());

            nodes[i] = new Node(x, y, z, i);

        }


        //x정렬
        Comparator<Node> xComparator = (o1, o2) -> o1.x - o2.x;
        Arrays.sort(nodes, xComparator);
        for (int i = 1; i < N; i++) {
            edges.add(new Edge(nodes[i - 1].idx, nodes[i].idx, Math.abs(nodes[i].x - nodes[i - 1].x)));
        }

        //y정렬
        Comparator<Node> yComparator = (o1, o2) -> o1.y - o2.y;
        Arrays.sort(nodes, yComparator);
        for (int i = 1; i < N; i++) {
            edges.add(new Edge(nodes[i - 1].idx, nodes[i].idx, Math.abs(nodes[i].y - nodes[i - 1].y)));
        }

        //z정렬
        Comparator<Node> zComparator = (o1, o2) -> o1.z - o2.z;
        Arrays.sort(nodes, zComparator);
        for (int i = 1; i < N; i++) {
            edges.add(new Edge(nodes[i - 1].idx, nodes[i].idx, Math.abs(nodes[i].z - nodes[i - 1].z)));
        }


        Comparator<Edge> edgeComparator = (o1, o2) -> o1.v - o2.v;
        Collections.sort(edges, edgeComparator);

        for (int i = 1; i <= N; i++) {
            answer[i] = i;
        }

        long result = 0;

        for (Edge ed : edges) {
            if (union(ed.s, ed.e)) {
                result += ed.v;
            }
        }

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.flush();
    }

    public static int find(int n) {
        if (n == answer[n]) {
            return n;
        } else {
            return answer[n] = find(answer[n]);
        }
    }

    public static boolean union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a == b) {
            return false;
        }
        answer[b] = a;

        return true;
    }

}

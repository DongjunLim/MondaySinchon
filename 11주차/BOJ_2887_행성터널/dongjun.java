/**
 * @��������
 * ũ�罺Į �˰����� ����� Ǯ�����ϴ�.
 * ��� ������ ������ �� ������ N^2�� ������ ����� ������
 * x, y, z�� �������� ���� �����Ͽ� ���� N*3 ���� ����������
 * ũ�罺Į �˰����� �����߽��ϴ�.
 * https://dev-jk.tistory.com/29 ����
 */

package ps.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;



public class BOJ_2887_�༺�ͳ� {
    public static int N;
    public static ArrayList<Planet> planets;
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        planets = new ArrayList<>(N);
        for(int i = 1; i <= N; i++){
            String[] input = br.readLine().split(" ");
            planets.add(new Planet(i, Integer.parseInt(input[0]), Integer.parseInt(input[1]), Integer.parseInt(input[2])));
        }
        System.out.println(solve());
    }

    private static int solve() {
        ArrayList<Edge> edgeList = new ArrayList<>();

        planets.sort((p1, p2) -> {return Integer.compare(p1.x, p2.x);});
        addEdgeList(edgeList);

        planets.sort((p1, p2) -> {return Integer.compare(p1.y, p2.y);});
        addEdgeList(edgeList);

        planets.sort((p1, p2) -> {return Integer.compare(p1.z, p2.z);});
        addEdgeList(edgeList);

        return kruskal(edgeList);
    }

    private static void addEdgeList(ArrayList<Edge> edgeList) {
        for(int i = 1; i < planets.size(); i++){
            Planet u = planets.get(i-1), v = planets.get(i);
            edgeList.add(new Edge(u.u, v.u, calcCost(u, v)));
        }
    }

    private static int calcCost(Planet planet1, Planet planet2) {
        return Math.min(Math.abs(planet1.z - planet2.z),
                Math.min(Math.abs(planet1.x - planet2.x),
                        Math.abs(planet1.y - planet2.y)));
    }

    private static int kruskal(ArrayList<Edge> edgeList) {
        edgeList.sort((e1, e2) -> {return Integer.compare(e1.cost, e2.cost);});
        int[] disjointSet = new int[N+1];
        Arrays.fill(disjointSet, -1);
        int cost = 0, cnt = 0;
        for(Edge edge: edgeList) {
            if(findSet(edge.u, disjointSet) == findSet(edge.v, disjointSet))
                continue;
            cost += edge.cost;
            cnt += 1;
            if(cnt == N-1)
                return cost;
            unionSet(edge.u, edge.v, disjointSet);
        }

        return cost;
    }

    private static int findSet(int u, int[] set){
        if(set[u] < 0){
            return u;
        }
        return set[u] = findSet(set[u], set);
    }

    private static void unionSet(int u, int v, int[] set){
        int parent1 = findSet(u, set);
        int parent2 = findSet(v, set);

        if(parent1 == parent2)
            return;

        set[parent2] = parent1;
    }
}

class Planet {
    public int u;
    public int x;
    public int y;
    public int z;
    public Planet(int u, int x, int y, int z){
        this.u = u;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public String toString(){
        return "x: " + this.x + " y: " + this.y + " z: " + this.z;
    }
}


class Edge {
    public int u;
    public int v;
    public int cost;
    public Edge(int u, int v, int cost){
        this.u = u;
        this.v = v;
        this.cost = cost;
    }

    @Override
    public String toString(){
        return "u: " + this.u + " v: " + this.v + " cost: " + this.cost;
    }
}

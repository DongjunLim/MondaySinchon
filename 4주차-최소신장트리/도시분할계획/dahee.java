package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class BOJ_1647_도시분할계획 {

	public static int N, M, parents[];
	public static PriorityQueue<Edge> adjList; 
	
	public static class Edge implements Comparable<Edge> {
		int node1, node2, weight;
		
		public Edge(int node1, int node2, int weight) {
			this.node1 = node1;
			this.node2 = node2;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			// 건설 비용(가중치) 오름차순으로 정렬
			return this.weight - o.weight;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input[] = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		adjList = new PriorityQueue<Edge>();
		
		for(int i = 0; i < M; i++) {
			input = br.readLine().split(" ");
			int to = Integer.parseInt(input[0]);
			int from = Integer.parseInt(input[1]);
			int weight = Integer.parseInt(input[2]);
			
			// 간선리스트 생성
			adjList.add(new Edge(to, from, weight));
		}

		parents = new int[N + 1];
		Arrays.fill(parents, -1);
		
		int cnt = 0;
		int result = 0;
		while(!adjList.isEmpty()) {
			Edge e = adjList.poll();
			
			// union 연산으로 정점 연결
			if(union(e.node1, e.node2)) {
				result += e.weight;
				cnt++;
			}
			// 연결된 정점 수가 전체 집의 수 - 2면 종료
			if(cnt == N - 2) break;
		}
		System.out.println(result);
	}
	
	private static int find(int x) {
		if(parents[x] < 0) return x;
		return parents[x] = find(parents[x]);
	}
	
	private static boolean union(int x, int y) {
		int xRoot = find(x);
		int yRoot = find(y);
		
		if(xRoot != yRoot) {
			parents[yRoot] = xRoot;
			return true;
		}
		return false;
	}
}

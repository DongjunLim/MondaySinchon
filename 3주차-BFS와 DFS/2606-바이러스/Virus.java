import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//https://www.acmicpc.net/problem/2606

public class Virus {
	static int N, M, ans;
    static int[][] computer;
    static boolean[] check;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scanner = new Scanner(System.in);
		N = scanner.nextInt(); //컴퓨터의 수
		M = scanner.nextInt(); //직접 연결되어 있는 컴퓨터 쌍의 수
		computer  = new int[N + 1][N + 1];
		check = new boolean[N+1];
		
		for(int i=0; i<M; i++) {
			int a=scanner.nextInt(); //노드들 입력받음
			int b = scanner.nextInt();
			computer[a][b] = computer[b][a] = 1; //입력된 노드들은 서로 인접함
		}

		
        System.out.println(bfs(1)); //정답 출력(출발노드와 인접한 다음 노드부터 검사)
	}
	
	public static int bfs(int v) {
		int ans = 0; //감염된 컴퓨터 수
		Queue<Integer> q = new LinkedList<Integer>(); //링크드 리스트로 큐 생성
		q.offer(v);//큐에 현재 노드 대입
		check[v] = true; //노드 방문함(true)
		
		while(!q.isEmpty()) { //큐가 비어있지 않는 동안
			int tmp = q.poll(); //tmp에 q의 제일 앞 요소를 팝 시킴 
			for(int i=1; i<=N; i++) { //노드 개수만큼 도는 동안
				if(!check[i]&& computer[tmp][i] == 1) { //현재 노드에서 인접한 노드을 방문하지 않았다면
					check[i] = true; //i 노드 방문
					q.offer(i);//큐에 추가
					ans++;//인접한 노드이기 때문에 감염된 컴퓨터의 수 증가
				}
				
			}
		}
		
		return ans;
	}

}

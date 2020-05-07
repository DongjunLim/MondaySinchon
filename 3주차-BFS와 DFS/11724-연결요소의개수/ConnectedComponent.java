import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//https://www.acmicpc.net/problem/11724

public class ConnectedComponent {

	static int N, M, ans;
    static boolean[][] graph;
    static boolean[] check;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scanner = new Scanner(System.in);
		N = scanner.nextInt(); //정점의 개수 입력받음
		M = scanner.nextInt(); //간선의 개수 입력받음
		graph  = new boolean[N + 1][N + 1];
		check = new boolean[N+1];
		
		for(int i=0; i<M; i++) {
			int a=scanner.nextInt(); //간선의 양 끝점들을 입력받음
			int b = scanner.nextInt();
			graph[a][b] = true;
			graph[b][a] = true; //서로 인접한 정점으로 설정
		}

		ans = 0; //연결요소의 개수 초기화
		for (int i = 1; i <= N; i++) {
            if (!check[i]) { //그래프 검사시
                bfs(i); //bfs 호출
                ans++;//개수 증가
            }
        }
        System.out.println(ans); //연결 요소 개수 출력
	}
	
	public static void bfs(int v) {
		Queue<Integer> q = new LinkedList<Integer>(); //링크드 리스트로 큐 생성
		q.offer(v);//큐에 현재 노드(시작) 대입
		check[v] = true; //노드 방문함(true)
		
		while(!q.isEmpty()) { //큐가 비어있지 않는 동안
			int tmp = q.poll(); //tmp에 q의 제일 앞 요소를 팝 시킴 
			for(int i=1; i<=N; i++) { //정점의 개수만큼 도는 동안
				if(!check[i]&& graph[tmp][i]) { //현재 정점에서 인접한 정점을 방문하지 않았다면
					check[i] = true; //i 노드 방문
					q.offer(i);//큐에 추가
				}
				
			}
		}
		
		
	}

}

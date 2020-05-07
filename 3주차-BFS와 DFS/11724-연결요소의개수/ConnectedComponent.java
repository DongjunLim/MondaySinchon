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
		N = scanner.nextInt(); //������ ���� �Է¹���
		M = scanner.nextInt(); //������ ���� �Է¹���
		graph  = new boolean[N + 1][N + 1];
		check = new boolean[N+1];
		
		for(int i=0; i<M; i++) {
			int a=scanner.nextInt(); //������ �� �������� �Է¹���
			int b = scanner.nextInt();
			graph[a][b] = true;
			graph[b][a] = true; //���� ������ �������� ����
		}

		ans = 0; //�������� ���� �ʱ�ȭ
		for (int i = 1; i <= N; i++) {
            if (!check[i]) { //�׷��� �˻��
                bfs(i); //bfs ȣ��
                ans++;//���� ����
            }
        }
        System.out.println(ans); //���� ��� ���� ���
	}
	
	public static void bfs(int v) {
		Queue<Integer> q = new LinkedList<Integer>(); //��ũ�� ����Ʈ�� ť ����
		q.offer(v);//ť�� ���� ���(����) ����
		check[v] = true; //��� �湮��(true)
		
		while(!q.isEmpty()) { //ť�� ������� �ʴ� ����
			int tmp = q.poll(); //tmp�� q�� ���� �� ��Ҹ� �� ��Ŵ 
			for(int i=1; i<=N; i++) { //������ ������ŭ ���� ����
				if(!check[i]&& graph[tmp][i]) { //���� �������� ������ ������ �湮���� �ʾҴٸ�
					check[i] = true; //i ��� �湮
					q.offer(i);//ť�� �߰�
				}
				
			}
		}
		
		
	}

}

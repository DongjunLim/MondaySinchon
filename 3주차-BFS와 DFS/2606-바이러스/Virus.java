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
		N = scanner.nextInt(); //��ǻ���� ��
		M = scanner.nextInt(); //���� ����Ǿ� �ִ� ��ǻ�� ���� ��
		computer  = new int[N + 1][N + 1];
		check = new boolean[N+1];
		
		for(int i=0; i<M; i++) {
			int a=scanner.nextInt(); //���� �Է¹���
			int b = scanner.nextInt();
			computer[a][b] = computer[b][a] = 1; //�Էµ� ������ ���� ������
		}

		
        System.out.println(bfs(1)); //���� ���(��߳��� ������ ���� ������ �˻�)
	}
	
	public static int bfs(int v) {
		int ans = 0; //������ ��ǻ�� ��
		Queue<Integer> q = new LinkedList<Integer>(); //��ũ�� ����Ʈ�� ť ����
		q.offer(v);//ť�� ���� ��� ����
		check[v] = true; //��� �湮��(true)
		
		while(!q.isEmpty()) { //ť�� ������� �ʴ� ����
			int tmp = q.poll(); //tmp�� q�� ���� �� ��Ҹ� �� ��Ŵ 
			for(int i=1; i<=N; i++) { //��� ������ŭ ���� ����
				if(!check[i]&& computer[tmp][i] == 1) { //���� ��忡�� ������ ����� �湮���� �ʾҴٸ�
					check[i] = true; //i ��� �湮
					q.offer(i);//ť�� �߰�
					ans++;//������ ����̱� ������ ������ ��ǻ���� �� ����
				}
				
			}
		}
		
		return ans;
	}

}

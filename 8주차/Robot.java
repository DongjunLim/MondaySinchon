import java.util.*;

//https://www.acmicpc.net/problem/14503

class Node{ //������ ��� ����
	int r;
	int c;
	int d;
	
	Node(int r, int c, int d){
		this.r=r;
		this.c=c;
		this.d = d;
	}
}

public class Robot{
	
	static int[] dx = {-1, 0, 1, 0};    // �ϵ�����
    static int[] dy = {0, 1, 0, -1};
    static int[][] arr;
    static int N,M,r,c,d;

    static int count; //û���� ĭ ���� ����

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	Scanner sc = new Scanner(System.in);
	N = sc.nextInt();
	M = sc.nextInt();
	 
	r = sc.nextInt()+1;
	c = sc.nextInt()+1;
	d = sc.nextInt();
	 
	arr = new int[N + 2][M + 2];

	for (int i = 1; i <= N; i++) { //�Է¹���
	    for (int j = 1; j <= M; j++) {
	       arr[i][j] = sc.nextInt();
	     }
	  }
	
	bfs(arr,r,c,d);
	Check(arr);    //û���� ĭ�� ������ ����
    System.out.println(count);
  }
	private static void bfs(int[][] arr,int r, int c, int d) {
		Queue<Node> q= new LinkedList<>();
		arr[r][c] = 9; //<-������ -1�� ��µ� ***
		q.offer(new Node(r,c,d));
		
		while(!q.isEmpty()) {
			Node p = q.poll();
			int nowA = p.r;
			int nowB = p.c; //���� x,y��ǥ ǥ��
			int nowC = p.d; //���� ����
			Boolean flags = false;//4������ �� û�ҵ��ְų� ���� ��츦 �Ǵ�
            int nextX;
            int nextY;
            int nextD; //���� ���鿡 ���� ������ ����

            for (int i = 0; i < 4; i++) {
                nowC = (nowC + 3) % 4;    //���� �̵��� ����
                nextX = nowA + (dx[nowC]);    //���� �̵��� X��ǥ
                nextY = nowB + (dy[nowC]);    //���� �̵��� Y��ǥ
 
                Node nextNode = new Node(nextX, nextY, nowC);
                if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) { //����ó��
                    continue;
                }
                //���� �̵��� ��ġ��  û�ҵ��� ���� ���̶�� �̵�
                if (arr[nextX][nextY] == 0) {
                    q.add(nextNode);
                    arr[nextX][nextY] = 9; //?
                    flags = true;
                    break;
                }
            }
          //4����� û�ҵưų� ���� ��쿡�� ����.
            if (!flags) {
                nextD = (nowC + 2) % 4;
                nextX = nowA + dx[nextD];
                nextY = nowB + dy[nextD];
 
          //���� ������ ���� ���� �ƴ϶�� �̵�, �׷��� �ʴٸ� ����
             if (arr[nextX][nextY] != 1) {
                arr[nextX][nextY] = 9;
                 q.offer(new Node(nextX, nextY, nowC));
              }
            }
        }
    }
 
	//û���� ĭ�� ������ ���ϴ� �Լ�
    public static void Check(int[][] arr) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 9)
                    count++;
                
            }
         
        }
    }
  
}

import java.util.*;

//https://www.acmicpc.net/problem/14503

class Node{ //적용할 노드 생성
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
	
	static int[] dx = {-1, 0, 1, 0};    // 북동남서
    static int[] dy = {0, 1, 0, -1};
    static int[][] arr;
    static int N,M,r,c,d;

    static int count; //청소한 칸 갯수 세기

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	Scanner sc = new Scanner(System.in);
	N = sc.nextInt();
	M = sc.nextInt();
	 
	r = sc.nextInt()+1;
	c = sc.nextInt()+1;
	d = sc.nextInt();
	 
	arr = new int[N + 2][M + 2];

	for (int i = 1; i <= N; i++) { //입력받음
	    for (int j = 1; j <= M; j++) {
	       arr[i][j] = sc.nextInt();
	     }
	  }
	
	bfs(arr,r,c,d);
	Check(arr);    //청소한 칸의 개수를 구함
    System.out.println(count);
  }
	private static void bfs(int[][] arr,int r, int c, int d) {
		Queue<Node> q= new LinkedList<>();
		arr[r][c] = 9; //<-없으면 -1씩 출력됨 ***
		q.offer(new Node(r,c,d));
		
		while(!q.isEmpty()) {
			Node p = q.poll();
			int nowA = p.r;
			int nowB = p.c; //현재 x,y좌표 표시
			int nowC = p.d; //현재 방향
			Boolean flags = false;//4방향이 다 청소돼있거나 벽일 경우를 판단
            int nextX;
            int nextY;
            int nextD; //다음 노드들에 대한 정수들 선언

            for (int i = 0; i < 4; i++) {
                nowC = (nowC + 3) % 4;    //다음 이동할 방향
                nextX = nowA + (dx[nowC]);    //다음 이동할 X좌표
                nextY = nowB + (dy[nowC]);    //다음 이동할 Y좌표
 
                Node nextNode = new Node(nextX, nextY, nowC);
                if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) { //예외처리
                    continue;
                }
                //다음 이동할 위치가  청소되지 않은 곳이라면 이동
                if (arr[nextX][nextY] == 0) {
                    q.add(nextNode);
                    arr[nextX][nextY] = 9; //?
                    flags = true;
                    break;
                }
            }
          //4방향다 청소됐거나 벽일 경우에는 후진.
            if (!flags) {
                nextD = (nowC + 2) % 4;
                nextX = nowA + dx[nextD];
                nextY = nowB + dy[nextD];
 
          //만약 후진할 곳이 벽이 아니라면 이동, 그렇지 않다면 종료
             if (arr[nextX][nextY] != 1) {
                arr[nextX][nextY] = 9;
                 q.offer(new Node(nextX, nextY, nowC));
              }
            }
        }
    }
 
	//청소한 칸의 개수를 구하는 함수
    public static void Check(int[][] arr) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 9)
                    count++;
                
            }
         
        }
    }
  
}

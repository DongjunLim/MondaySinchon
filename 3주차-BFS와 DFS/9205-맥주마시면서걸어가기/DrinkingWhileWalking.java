import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


//https://www.acmicpc.net/problem/9205

public class DrinkingWhileWalking {

	static int N, n;//입력되는 테스트케이스 수와 편의점 수
	static int[] check; //좌표를 들렸는지 들리지 않았는지 0과 1로 구분


	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		
		for(int j=0; j<N; j++) {
			n = Integer.parseInt(br.readLine());
			LOCATION[] location = new LOCATION[n + 2];
			Queue<LOCATION> q = new LinkedList<LOCATION>(); //bfs 탐색을 위한 큐 생성
			check = new int[n+2];
			boolean success = false; //목적지에 도착했을 때 true, 아님 false
			String[] str;
			for(int i=0; i<n+2; i++) {
				str = br.readLine().split(" ");
				location[i] = new LOCATION(Integer.parseInt(str[0]), Integer.parseInt(str[1]));
			}
			
			LOCATION start = location[0]; //시작점 생성
			LOCATION arrive = location[n+1]; //목적지 생성
			q.add(start); //시작점을 큐에 추가
			
			while(!q.isEmpty()) { //큐가 비어있지 않다면
				LOCATION tmp = q.poll(); //현재위치 
				if(tmp.equals(arrive)) { //이미 목적지(페스티벌)에 도착했다면
					success = true; //true로 바뀜
					break;
				}
				
				for(int k=1; k<n+2; k++) { //입력된 좌표 수 만큼 반복
					if (check[k]==0 && Math.abs(tmp.x - location[k].x) + Math.abs(tmp.y - location[k].y) <= 1000) {
						//아직 k 노드를 방문하지 않았고 인접한 x좌표와 y좌표의 차이의 합이 1000 이하이면
						check[k] = 1; //k 노드 방문
						q.add(location[k]);//큐에 추가
					}
				}
		}
		
		if(success) { //true이면 happy, 아니면 sad
			System.out.println("happy");
		} else{
            System.out.println("sad");
        }

		}
	}
}


	class LOCATION { //좌표 생성 클래스
    int x;
    int y;
 
    LOCATION(int x, int y) {
        this.x = x;
        this.y = y;
    }
}




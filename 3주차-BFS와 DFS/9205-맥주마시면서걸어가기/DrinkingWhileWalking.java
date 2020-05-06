import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


//https://www.acmicpc.net/problem/9205

public class DrinkingWhileWalking {

	static int N, n;//�ԷµǴ� �׽�Ʈ���̽� ���� ������ ��
	static int[] check; //��ǥ�� ��ȴ��� �鸮�� �ʾҴ��� 0�� 1�� ����


	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		
		for(int j=0; j<N; j++) {
			n = Integer.parseInt(br.readLine());
			LOCATION[] location = new LOCATION[n + 2];
			Queue<LOCATION> q = new LinkedList<LOCATION>(); //bfs Ž���� ���� ť ����
			check = new int[n+2];
			boolean success = false; //�������� �������� �� true, �ƴ� false
			String[] str;
			for(int i=0; i<n+2; i++) {
				str = br.readLine().split(" ");
				location[i] = new LOCATION(Integer.parseInt(str[0]), Integer.parseInt(str[1]));
			}
			
			LOCATION start = location[0]; //������ ����
			LOCATION arrive = location[n+1]; //������ ����
			q.add(start); //�������� ť�� �߰�
			
			while(!q.isEmpty()) { //ť�� ������� �ʴٸ�
				LOCATION tmp = q.poll(); //������ġ 
				if(tmp.equals(arrive)) { //�̹� ������(�佺Ƽ��)�� �����ߴٸ�
					success = true; //true�� �ٲ�
					break;
				}
				
				for(int k=1; k<n+2; k++) { //�Էµ� ��ǥ �� ��ŭ �ݺ�
					if (check[k]==0 && Math.abs(tmp.x - location[k].x) + Math.abs(tmp.y - location[k].y) <= 1000) {
						//���� k ��带 �湮���� �ʾҰ� ������ x��ǥ�� y��ǥ�� ������ ���� 1000 �����̸�
						check[k] = 1; //k ��� �湮
						q.add(location[k]);//ť�� �߰�
					}
				}
		}
		
		if(success) { //true�̸� happy, �ƴϸ� sad
			System.out.println("happy");
		} else{
            System.out.println("sad");
        }

		}
	}
}


	class LOCATION { //��ǥ ���� Ŭ����
    int x;
    int y;
 
    LOCATION(int x, int y) {
        this.x = x;
        this.y = y;
    }
}




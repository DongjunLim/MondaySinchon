package SWEA;

import java.io.IOException;
import java.util.Scanner;

public class SWEA_4408_자기방으로돌아가기 {
	/*
	 * 1 3 5 7 9 11 ...
	 * 
	 * 2 4 6 8 10 12 ...
	 * 
	 * 이런 경우 마주 보는 방을 하나의 방으로 처리할 수 있음. 
	 * 
	 * (1, 2) (3, 4) (5, 6) 이렇게 하여 1 ~ 200번까지의 방을 배열의 인덱스로 바로 사용하여 지나가는 경로를 카운팅!
	 * 위와 같이 하기 위해서는 방 번호가 홀수인 경우 짝수로 만들어줘야 함.
	 * 그리고 작은 번호의 방에서 큰 번호의 방으로 이동하도록 해줘야 함. (그래야 하나의 for로 카운팅 가능)
	 * 
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		// BufferedReader 사용하면 Runtime Error
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		for(int t = 1; t <= tc; t++) {
			int N = sc.nextInt();
			int cnt[] = new int[201];
			
			for(int i = 0; i < N; i++) {
				int start = sc.nextInt();
				int end = sc.nextInt();
				
				// 작은 번호의 방에서 큰 번호의 방으로 이동시키기 위해 swap
				if(start > end) {
					int tmp = start;
					start = end;
					end = tmp;
				}
				
				// 방 번호를 짝수로 맞추기 위한 과정
				if(start % 2 == 1) start++;
				if(end % 2 == 1) end++;
				
				// 400번까지의 방이 있으므로 / 2를 수행해줘야 인덱스 그대로 사용 가능
				start /= 2;
				end /= 2;
				
				// 지나가는 경로 카운팅
				for(int j = start; j <= end; j++) cnt[j]++;
			}
			
			// 경로 중에서 가장 카운팅이 많은 곳이 가장 많이 겹치는 곳이므로 가장 오래 걸리는 시간임.
			int max = 0;
			for(int i = 0; i < cnt.length; i++) {
				if(max < cnt[i]) max = cnt[i];
			}
			
			System.out.println("#" + t + " " + max);
		}
	}
}

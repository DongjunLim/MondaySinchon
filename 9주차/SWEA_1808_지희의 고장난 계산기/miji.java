import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Calculator {
	static int[] nums;
	static int target;
	static int min;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		

		for(int test_case = 1; test_case <= T; test_case++)
		{
			
			String[] temp = br.readLine().split(" ");
			int min = Integer.MAX_VALUE;
			nums = new int[10];
			for(int i=0; i<10; i++) {
				nums[i] = Integer.parseInt(temp[i]);
				//0,1,0...
			}
			
			target = Integer.parseInt(br.readLine()); //60
			
			//해당 숫자를 바로 만들때
			int y = isValid(target);
			if(y !=0 ) {
				y = y+1; //= 카운트
				System.out.println("#" + test_case + " " + y);
				continue;
			}
			
			solve(target,0);
			
			if(min == Integer.MAX_VALUE)
				min = -1; //만들 수 없는 경우 -1
			else
				min += 1; //만들 수 있는 경우는 = 버튼 추가
			System.out.println("#" + test_case + " " + min);
			
			
		}
		br.close(); // 없으면 시간초과
	}
	
	public static int solve(int target, int depth) {
		int result = Integer.MAX_VALUE;
		int y = isValid(target);
		
		//해당 숫자를 만들 수 있는 경우 숫자의 길이 반환
		if( y!=0) return y;
		
		for(int i=2, end=(int)Math.sqrt(target)+1; i< end; i++){
			// 약수이면
			if(target % i == 0){
				int a = isValid(i);
				// i를 만들 수 있으면
				if(a != 0){
					a = a+1;	// 곱하기 버튼 추가
					y = solve(target/i, depth+1);
					// target/i를 만들 수 있는 경우
					if(y != Integer.MAX_VALUE){
						int r = a+y;
						if(r < result)
							result = r;
						// 최소값보다 작고 target이 원하는 수인 경우 min값 업데이트
						if(result < min && target == Calculator.target)
							min = result;
					}
				}
			}
		}
		return result;
	}
	
	
	
	public static int isValid(int x) {
		int a = 0;
		int length = 1;
		
		//10으로 나눠서 자리수 확인
		if(x>=10) {
			while(true) {
			a = x%10;
			x /= 10;
			length++;
			if(nums[a] == 0) return 0;
			if(x<10) break;
			}
			
			
		}
		
		//10보다 작은 경우 사용 가능한 버튼인지 확인
		if(nums[x] == 0) return 0;
		return length;
	}
	
	
	

}

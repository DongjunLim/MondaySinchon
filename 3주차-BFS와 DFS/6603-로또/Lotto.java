import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

//https://www.acmicpc.net/problem/6603

public class Lotto {
	
	static int k; //입력받을 정수 개수
	static int[] arr; //입력받은 정수 배열에 넣음
	static int [] arr2; //dfs에 활용

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
        
		
		while(true) {
			
			//**이부분을 while 밖에 선언하면 메모리 초과가 일어남**
			
			//버퍼로 입력받음
			String[] str = br.readLine().split(" ");
			k =  Integer.parseInt(str[0]);
			arr = new int[k];
			arr2 = new int[k];
			
			
			if(k == 0) { //0이면 break
				break;
			}
			
			for(int i=0; i<k; i++) { //k만큼 배열에 대입
				arr[i] = Integer.parseInt(str[i + 1]);
			}
			
			
			
			Arrays.sort(arr); //정렬
			
			dfs(0,0); //dfs 호출
			
			System.out.println();
			
		}
		

	}
	
	public static void dfs(int start, int depth) {
		if(depth == 6) { //1에 해당하는 요소들이 6개이면 print 호출
			print();
		}
		
		for(int i=start; i<k; i++) { //k만큼루프 실행
			//arr2에 요소들에 대한 정보를 0과 1로 구분
			arr2[i] = 1;
			dfs(i+1, depth+1); 
			arr2[i] = 0;
		}
		
	}
	
	public static void print() { //출력 형식을 정해줌
		for(int i=0; i<k; i++) {
			if(arr2[i] == 1) { //arr2에서 설정된 요소들이 0,1중 1에 해당하는 arr 요소들만 출력
				System.out.print(arr[i]+" ");
			}
		}
		System.out.println();
	}

}


import java.io.IOException;
import java.util.Scanner;

//https://www.acmicpc.net/problem/14888


public class PuttingInOperator_miji {
	
	static int[] arr;// 숫자 배열
    static int[] op = new int[4];// 연산자 횟수를 저장할 배열
    static int N; //수의 개수
    static int min = Integer.MAX_VALUE; // 최댓값 저장
    static int max = Integer.MIN_VALUE; // 최솟값 저장


	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("숫자 개수 입력하기: ");
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); 
		arr = new int[N+1]; 
		
		//char[] MH = new char[N];
		
		 for (int i = 0; i < N; i++) {
	            arr[i] = sc.nextInt(); //입력받은 N만큼 숫자 입력받기
	        }
	 
	     for (int i = 0; i < 4; i++) {
	            op[i] = sc.nextInt(); //연산자 횟수 입력받기
	     }
	     
	     dfs(0,arr[0],0); //dfs 호출
	     
	     System.out.println(max); //최댓값 출력
	     System.out.println(min); //최솟값 출력

	}
	
	
	public static void dfs(int num, int result, int j) { //dfs로 요소들의 연산자 넣기
        if(num == N-1) { //연산자 개수와 같을 때(더이 상 연산할 것이 없을 때)
        	if(max<result) max = result; //더 작거나 큰 요소를 min과 max로 설정
        	if(min > result) min = result;
        }
        
        for(int i=0; i<op.length; i++) { //4번 반복
			if(op[i] == 0) { //만약 모든 연산자들이 0이면 continue
				continue;
			}else { //아니라면
				if(i==0) {
					op[i]--; //연산자 하나 사용
					dfs(num+1, result + arr[j+1], j+1); //다음 요소와 덧셈
					op[i]++; //연산자 다시 복구
				}
				else if( i== 1) {
					op[i]--; 
					dfs(num+1, result - arr[j+1], j+1);
					op[i]++;
				}
				else if( i == 2) {
					op[i]--; 
					dfs(num+1, result * arr[j+1], j+1);
					op[i]++; 
				}
				else if( i ==3) {
					op[i]--;
					dfs(num+1, result / arr[j+1], j+1);
					op[i]++;
				}
				
				
			}
		}
    }

}

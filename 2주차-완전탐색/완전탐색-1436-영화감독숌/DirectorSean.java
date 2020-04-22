import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class DirectorSean {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		System.out.println("N번째 영화 입력하기: ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int movieNumber = 0; //영화 제목
		
		
		while(N >0) { //N이 0보다 클 때 반복문 계속 수행
			movieNumber++; //영화 제목의 숫자를 증가시킴
			
			String movies = Integer.toString(movieNumber); //증가시킨 숫자를 문자열로 변환
			
			if(movies.contains("666")) { //해당 문자열에 666이라는 숫자가 포함되어있는지 확인
				N--; //포함되어있다면 입력값을 줄임
			}
			
	}
		
		System.out.println(movieNumber); //영화제목 출력

  }
}
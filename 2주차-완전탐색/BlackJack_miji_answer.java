import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Vector;

//https://www.acmicpc.net/problem/2798


public class BlackJack_miji_answer {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		//입력받을 때 문자열로 받고, 띄어쓰기로 입력 구분
        String[] inputStr = reader.readLine().split(" ");
        String[] card = reader.readLine().split(" ");
        
        //카드 수 입력
		int N = Integer.parseInt(inputStr[0]);
		//카드의 최대 합 입력
		int M = Integer.parseInt(inputStr[1]);
		
	
		//메소드 호출
		blackjack(card, M, N);

	}
	
	private static void blackjack(String[] card, int M, int N)  {
		
		//최대 값과 가까운 값 호출하는 tmp
        int tmp = 0;
        
        //입력으로 받은 카드들 중...
		for(int i=0; i<N-2; i++) { //첫번 째 카드 A 선택, 세 카드 중 첫 카드이므로 끝에 두장 남김.
			int A = Integer.parseInt(card[i]);
			for(int j=i+1; j<N-1; j++) { //두번 째 카드 B 선택, 끝에 한장 남김
				int B = Integer.parseInt(card[j]);
				for(int k=j+1; k<N; k++) { //세번 째 카드 C 선택, 세카드 중 마지막 카드이므로 끝까지 반복
					int C = Integer.parseInt(card[k]);
					if(A+B+C == M) { //만약 세 카드의 합이 입력한 최대 합과 같다면 바로 답으로 리턴
						System.out.println(M);
						return;
					}else if(A+B+C < M) { //세 카드의 합이 최대 합보다 작을 때
						if(A+B+C > tmp){ //tmp보단 클 때
                            tmp = A+B+C; //tmp에 합 대입
                        }
					/* if문 대신
					 * Vector<Integer> maxNumbers = new Vector<Integer>();
					 * maxNumbers.add(A+B+C);
					   maxNumbers.sort(Comparator.naturalOrder());
					   System.out.println(maxNumbers.lastElement());
					   로 하면 시간 초과...
					 * */
					}
				}
			}
			
			
		}
		System.out.println(tmp); //tmp를 출력
		
	}


}

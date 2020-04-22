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
		
		//�Է¹��� �� ���ڿ��� �ް�, ����� �Է� ����
        String[] inputStr = reader.readLine().split(" ");
        String[] card = reader.readLine().split(" ");
        
        //ī�� �� �Է�
		int N = Integer.parseInt(inputStr[0]);
		//ī���� �ִ� �� �Է�
		int M = Integer.parseInt(inputStr[1]);
		
	
		//�޼ҵ� ȣ��
		blackjack(card, M, N);

	}
	
	private static void blackjack(String[] card, int M, int N)  {
		
		//�ִ� ���� ����� �� ȣ���ϴ� tmp
        int tmp = 0;
        
        //�Է����� ���� ī��� ��...
		for(int i=0; i<N-2; i++) { //ù�� ° ī�� A ����, �� ī�� �� ù ī���̹Ƿ� ���� ���� ����.
			int A = Integer.parseInt(card[i]);
			for(int j=i+1; j<N-1; j++) { //�ι� ° ī�� B ����, ���� ���� ����
				int B = Integer.parseInt(card[j]);
				for(int k=j+1; k<N; k++) { //���� ° ī�� C ����, ��ī�� �� ������ ī���̹Ƿ� ������ �ݺ�
					int C = Integer.parseInt(card[k]);
					if(A+B+C == M) { //���� �� ī���� ���� �Է��� �ִ� �հ� ���ٸ� �ٷ� ������ ����
						System.out.println(M);
						return;
					}else if(A+B+C < M) { //�� ī���� ���� �ִ� �պ��� ���� ��
						if(A+B+C > tmp){ //tmp���� Ŭ ��
                            tmp = A+B+C; //tmp�� �� ����
                        }
					/* if�� ���
					 * Vector<Integer> maxNumbers = new Vector<Integer>();
					 * maxNumbers.add(A+B+C);
					   maxNumbers.sort(Comparator.naturalOrder());
					   System.out.println(maxNumbers.lastElement());
					   �� �ϸ� �ð� �ʰ�...
					 * */
					}
				}
			}
			
			
		}
		System.out.println(tmp); //tmp�� ���
		
	}


}

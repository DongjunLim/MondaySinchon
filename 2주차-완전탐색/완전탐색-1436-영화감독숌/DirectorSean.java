import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class DirectorSean {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		System.out.println("N��° ��ȭ �Է��ϱ�: ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int movieNumber = 0; //��ȭ ����
		
		
		while(N >0) { //N�� 0���� Ŭ �� �ݺ��� ��� ����
			movieNumber++; //��ȭ ������ ���ڸ� ������Ŵ
			
			String movies = Integer.toString(movieNumber); //������Ų ���ڸ� ���ڿ��� ��ȯ
			
			if(movies.contains("666")) { //�ش� ���ڿ��� 666�̶�� ���ڰ� ���ԵǾ��ִ��� Ȯ��
				N--; //���ԵǾ��ִٸ� �Է°��� ����
			}
			
	}
		
		System.out.println(movieNumber); //��ȭ���� ���

  }
}
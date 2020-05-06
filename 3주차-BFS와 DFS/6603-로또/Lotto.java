import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

//https://www.acmicpc.net/problem/6603

public class Lotto {
	
	static int k; //�Է¹��� ���� ����
	static int[] arr; //�Է¹��� ���� �迭�� ����
	static int [] arr2; //dfs�� Ȱ��

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
        
		
		while(true) {
			
			//**�̺κ��� while �ۿ� �����ϸ� �޸� �ʰ��� �Ͼ**
			
			//���۷� �Է¹���
			String[] str = br.readLine().split(" ");
			k =  Integer.parseInt(str[0]);
			arr = new int[k];
			arr2 = new int[k];
			
			
			if(k == 0) { //0�̸� break
				break;
			}
			
			for(int i=0; i<k; i++) { //k��ŭ �迭�� ����
				arr[i] = Integer.parseInt(str[i + 1]);
			}
			
			
			
			Arrays.sort(arr); //����
			
			dfs(0,0); //dfs ȣ��
			
			System.out.println();
			
		}
		

	}
	
	public static void dfs(int start, int depth) {
		if(depth == 6) { //1�� �ش��ϴ� ��ҵ��� 6���̸� print ȣ��
			print();
		}
		
		for(int i=start; i<k; i++) { //k��ŭ���� ����
			//arr2�� ��ҵ鿡 ���� ������ 0�� 1�� ����
			arr2[i] = 1;
			dfs(i+1, depth+1); 
			arr2[i] = 0;
		}
		
	}
	
	public static void print() { //��� ������ ������
		for(int i=0; i<k; i++) {
			if(arr2[i] == 1) { //arr2���� ������ ��ҵ��� 0,1�� 1�� �ش��ϴ� arr ��ҵ鸸 ���
				System.out.print(arr[i]+" ");
			}
		}
		System.out.println();
	}

}

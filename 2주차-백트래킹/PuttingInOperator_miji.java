
import java.io.IOException;
import java.util.Scanner;

//https://www.acmicpc.net/problem/14888


public class PuttingInOperator_miji {
	
	static int[] arr;// ���� �迭
    static int[] op = new int[4];// ������ Ƚ���� ������ �迭
    static int N; //���� ����
    static int min = Integer.MAX_VALUE; // �ִ� ����
    static int max = Integer.MIN_VALUE; // �ּڰ� ����


	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("���� ���� �Է��ϱ�: ");
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); 
		arr = new int[N+1]; 
		
		//char[] MH = new char[N];
		
		 for (int i = 0; i < N; i++) {
	            arr[i] = sc.nextInt(); //�Է¹��� N��ŭ ���� �Է¹ޱ�
	        }
	 
	     for (int i = 0; i < 4; i++) {
	            op[i] = sc.nextInt(); //������ Ƚ�� �Է¹ޱ�
	     }
	     
	     dfs(0,arr[0],0); //dfs ȣ��
	     
	     System.out.println(max); //�ִ� ���
	     System.out.println(min); //�ּڰ� ���

	}
	
	
	public static void dfs(int num, int result, int j) { //dfs�� ��ҵ��� ������ �ֱ�
        if(num == N-1) { //������ ������ ���� ��(���� �� ������ ���� ���� ��)
        	if(max<result) max = result; //�� �۰ų� ū ��Ҹ� min�� max�� ����
        	if(min > result) min = result;
        }
        
        for(int i=0; i<op.length; i++) { //4�� �ݺ�
			if(op[i] == 0) { //���� ��� �����ڵ��� 0�̸� continue
				continue;
			}else { //�ƴ϶��
				if(i==0) {
					op[i]--; //������ �ϳ� ���
					dfs(num+1, result + arr[j+1], j+1); //���� ��ҿ� ����
					op[i]++; //������ �ٽ� ����
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

/**
 *  @��������
 *  ��� ��θ� �ּҷ� �̵��Ϸ���
 *  ���д� Ʈ���� ����� �Ǵµ�
 *  ���д� Ʈ���� ���� ������ ���� - 1�Դϴ�.
 *  �׷��� �׳� N-1�� ����߽��ϴ�.
 */

package ps.boj;

import java.util.ArrayList;
import java.util.Scanner;

public class BOJ_9372_�������_���� {
    public static int N, M;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();
        
        for(int tc = 0; tc < T; tc++){
            N = sc.nextInt();   M = sc.nextInt();

            for(int i = 0; i <= M; i++)
                sc.nextLine();

            System.out.println(N-1);
        }
    }
}


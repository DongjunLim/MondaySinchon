/**
 *  @문제접근
 *  모든 경로를 최소로 이동하려면
 *  스패닝 트리를 만들면 되는데
 *  스패닝 트리의 간선 갯수는 정점 - 1입니다.
 *  그래서 그냥 N-1을 출력했습니다.
 */

package ps.boj;

import java.util.ArrayList;
import java.util.Scanner;

public class BOJ_9372_상근이의_여행 {
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


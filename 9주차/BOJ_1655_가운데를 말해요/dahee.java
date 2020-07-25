package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1655_가운데를말해요 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        LinkedList<Integer> list = new LinkedList<Integer>();

        // tc만큼 반복문 수행
        while(tc-- > 0){
            int num = Integer.parseInt(br.readLine());
            list.add(num);

            // sort 수행
            Collections.sort(list, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1 - o2;
                }
            });

            int size = list.size();
            // 짝수인 경우
            if(size % 2 == 0) System.out.println(list.get(size / 2 - 1));
            // 홀수인 경우
            else System.out.println(list.get(size / 2));
        }
    }
}

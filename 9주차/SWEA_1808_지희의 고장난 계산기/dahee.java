package SWEA;

import java.io.*;

public class SWEA_1808_지희의고장난계산기 {
    public static int result, calCnt, isAvailable[];

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());

        for(int t = 1; t <= tc; t++){
            isAvailable = new int[10];
            String input[] = br.readLine().split(" ");

            // 입력 받기
            for(int i = 0; i < input.length; i++){
                isAvailable[i] = Integer.parseInt(input[i]);
            }

            result = Integer.parseInt(br.readLine());
            calCnt = Integer.MAX_VALUE;

            // 만들 수 있는 경우인지 확인
            int len = check(result);
            if(len != 0) {
                System.out.println("#" + t + " " + (len + 1));
                continue;
            }

            dfs(result, 0);
            // 값의 변화가 없다는 것은 만들 수 없는 경우이므로 -1로 갱신
            if(calCnt == Integer.MAX_VALUE) calCnt = -1;
            // 위의 경우가 아니라면 누른 횟수 증가(마지막 계산 버튼)
            else calCnt += 1;

            System.out.println("#" + t + " " + calCnt);
        }
    }

    public static int dfs(int target, int depth){
        int res = Integer.MAX_VALUE;
        int b = check(target);

        // target 수를 만들 수 있으면 길이 반환
        if(b != 0) return b;

        for(int i = 2, end = (int)Math.sqrt(target) + 1; i < end; i++){
            // 약수인 경
            if(target % i == 0){
                // 가지고 있는 숫자로 만들 수 있는지 확인
                int a = check(i);
                // 만들 수 있는 경우
                if(a != 0){
                    a = a + 1; // 연산 횟수 추가
                    b = dfs(target / i, depth + 1);
                    // target / i를 만들 수 있는 경우
                    if(b != Integer.MAX_VALUE){
                        int r = a + b;
                        if(r < res)
                            res = r;
                        if(res < calCnt && target == result)
                            calCnt = res;
                    }
                }
            }
        }
        return res;
    }

    private static int check(int num){
        int tmp = 0;
        int res = 1;

        if(num >= 10){
            while(true){
                // 10으로 나눠봄
                tmp = num % 10;
                num = num / 10;
                res++; // 연산 횟수 증가

                // 내가 현재 가지고 있는 값이 아니라면 계산 불가
                if(isAvailable[tmp] == 0) return 0;
                if(num < 10) break;
            }
        }

        // 불가능한 경우
        if(isAvailable[num] == 0) return 0;

        // 길이 반환(길이가 곧 누른 횟수가 되므로
        return res;
    }
}

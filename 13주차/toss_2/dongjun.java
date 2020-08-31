/**
 *  @문제접근
 *  .을 구분자로 하여 문자열을 자르고,
 *  자른 문자열 배열의 최소길이 - 1 만큼 순회하며
 *  문자열이 동일한지 확인하는 방식으로 풀었습니다.
 *  
 *  @성능
 *  O(문자열의 최소길이 * n)
 */
public class T1 {
    public static void main(String[] args){
        int n = 3;
        String[] input = {"경기도.수원시.영통구.법조로", "경기도.수원시.영통구.삼성로", "경기도.수원시.영통구.법조로30"};
        System.out.println(solve(n, input));

        n = 4;
        input = new String[] {"서울특별시.송파구.충민로", "경기도.성남시.분당구.불정로", "서울특별시.송파구.충민로3", "서울특별시.송파구"};
        System.out.println(solve(n, input));

        n = 2;
        input = new String[] {"경기도.안산시.상록구.초지1로", "경기도.안산시.상록구.초지1로20"};
        System.out.println(solve(n, input));

        n = 2;
        input = new String[] {"경기도.안양시.만안구", "경기도.안양시.만안구.덕천로"};
        System.out.println(solve(n, input));
    }

    private static String solve(int n, String[] input) {
        String[][] s = new String[input.length][];
        String answer = "";
        int minIdx = Integer.MAX_VALUE;

        for(int i = 0; i < input.length; i++){
            s[i] = input[i].split("\\.");
            minIdx = Math.min(minIdx, s[i].length);
        }

        String cString;

        for(int i = 0; i < minIdx - 1; i++){
            cString = s[0][i];
            for(int j = 1; j < s.length; j++){
                if(!cString.equals(s[j][i])){
                    return answer.equals("") ? "없음" : answer.substring(0, answer.length() - 1);
                }
            }
            answer += (cString + ".");
        }
        return answer.equals("") ? "없음" : answer.substring(0, answer.length() - 1);
    }
}

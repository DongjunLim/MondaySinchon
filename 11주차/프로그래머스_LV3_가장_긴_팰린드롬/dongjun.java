/**
 *  @문제접근
 *  각각의 문자들을 첫 문자로 하는
 *  부분문자열 중에
 *  길이가 가장 큰 부분문자열부터
 *  팰린드롬인지 확인해갔습니다. 
 */

package ps.programmers;

public class LV3_가장_긴_팰린드롬 {
    public static void main(String[] args){
        
        String s = "cdeabcbak";

        System.out.println(solve(s));
    }

    public static int solve(String s) {
        int maxPalindrome = 1;

        char[] inputString = s.toCharArray();

        for(int i=0; i<=inputString.length; i++){
            
            if ((inputString.length-1) - i <= maxPalindrome) 
                return maxPalindrome;

            for(int j = inputString.length; j > i; j--){
                
                if(j - i < maxPalindrome) 
                    break;

                maxPalindrome = Math.max(maxPalindrome, countSubstringPalindrome(i, j, inputString));
            }
        }
        return maxPalindrome;
    }

    public static int countSubstringPalindrome(int startPoint, int endPoint, char[] inputString) {
        int left = startPoint, right = endPoint;

        while(left <= right){
            if(inputString[left++] != inputString[--right]){
                return 0;
            }
        }
        return endPoint-startPoint;
    }
}


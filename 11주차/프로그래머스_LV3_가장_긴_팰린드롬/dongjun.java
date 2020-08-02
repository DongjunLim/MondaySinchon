/**
 *  @��������
 *  ������ ���ڵ��� ù ���ڷ� �ϴ�
 *  �κй��ڿ� �߿�
 *  ���̰� ���� ū �κй��ڿ�����
 *  �Ӹ�������� Ȯ���ذ����ϴ�. 
 */

package ps.programmers;

public class LV3_����_��_�Ӹ���� {
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


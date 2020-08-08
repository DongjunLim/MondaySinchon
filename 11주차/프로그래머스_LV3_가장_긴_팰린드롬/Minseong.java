package Algorithm.MondaySinchon.ProgrammersLongestPalindrome2;

class Solution {

    static char array[];
    static boolean flag;

    public int solution(String s) {

        array = s.toCharArray();

        for (int i = s.length(); i > 1; i--){

            for (int j = 0; i + j <= s.length(); j++){
                flag = false;
                for (int k = 0; k < i / 2; k++){
                    if (array[j + k] != array[i + j - k - 1]){
                        flag = true;
                        break;
                    }
                }
                if (!flag){
                    return i;
                }
            }
        }
        return 1;

    }
}
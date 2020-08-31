import java.util.*;

//https://leetcode.com/problems/generate-parentheses
//**괄호 추가할 때 재귀 사용**

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> parentheses = new ArrayList<>();
        if (n == 0) return parentheses;
        
        //string이 빈 상태로 시작
        validParentheses(parentheses, "", n, n);
        
        return parentheses;
    }
    
    public void validParentheses(List<String> parentheses, String cur, int left, int right){
        //경우 1: 더 이상 괄호를 추가할 수 없을 때
        if(left ==0 && right == 0){
            parentheses.add(cur); //현재 값 리턴
            return;
        }
        
        //경우 2: 왼쪽 괄호 추가하는 경우
        if(left > 0){
            validParentheses(parentheses, cur+"(", left-1, right);
        }
        
        //경우 3: 오른쪽 괄호 추가하는 경우, **오른쪽과 왼쪽 괄호는 짝을 맞추어야 함**
        if(right>0 && right > left){
            validParentheses(parentheses, cur+")", left, right-1);
        }
    }
}
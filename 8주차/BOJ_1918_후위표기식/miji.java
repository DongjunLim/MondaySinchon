import java.util.*;
//https://www.acmicpc.net/problem/1918

public class PostfixExpression {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String input= sc.next();
		String answer = "";
		Stack<Character> stack = new Stack<>();
		
		for(int i=0; i<input.length(); i++) {
			
			
			if(input.charAt(i) >= 'A' && input.charAt(i) <= 'Z') { //알파벳에 해당된다면
				answer+=input.charAt(i);
				
			}else if(input.charAt(i) == '(') {
				stack.push(input.charAt(i));
						
			}else if(input.charAt(i) == ')') {
				while(!stack.isEmpty()) {
					// 스택이 빌 때 까지 
                    if(stack.peek()=='(') {
                       // 여는 괄호를 만나면
                       stack.pop();
                       // 여는 괄홀 없애고
                       break;
                       // 반복 종료
				}
                answer+=stack.pop(); //해당 요소 팝 시켜서 answer에 추가
			}
		}else { //연산자일경우
			 // * / + - 일 경우
            while (!stack.isEmpty() &&  compare(stack.peek()) >= compare(input.charAt(i))) {
                // 스택이 비어 있지 않고 스택 상단 값의 우선순위가 입력 문자보다 크면
                // 괄호안이 아니고 stack 최상단 값이 * 나 /면
                answer+=stack.pop();
                // 스택 상단 값 출력
            }
            stack.add(input.charAt(i));
            // 다시 담음
		}
		
		
	}
	
		
	while (!stack.isEmpty()) {
	       // 반복 끝났는데 스택이 다 비어있지 않으면 나머지 대입
		   answer+=stack.pop();
	       
	   }
	
	System.out.print(answer);

	
}
	
	public static int compare(char ch) { 
		if (ch == '(') return 0;
        if (ch == '+' || ch == '-') return 1;
        else return 2;
	}
	
}

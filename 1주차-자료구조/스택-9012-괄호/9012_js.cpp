#include <iostream>
#include <vector>
#include <stack>
#include <string>

using namespace std;

int main(){
	// 반복 횟수 입력
	int iter = 0;
	cin >> iter;
	// 반복 횟수만큼 반복
	for (int i = 0; i < iter; ++i){
		stack<char> stl_stack;
		// 테스트 케이스 입력 (,)의 입력만 있다고 가정
		string s;
		cin >> s;
		// 테스트 케이스 길이만큼 반복
		for (int j = 0; j < s.length(); ++j){
			// 첫 시작이거나 (일 경우
			if (stl_stack.empty() || s[j] == '(')
				stl_stack.push(s[j]);
			// )이면서 스택 맨위에 (가 있을 경우
			else if (stl_stack.top() == '(')
				stl_stack.pop();
		}	
		// 결과 스택이 비었다면 YES, 아니면 NO
		if (stl_stack.empty())
			cout << "YES" << endl;
		else 
			cout << "NO" << endl;
	}

	return 0;
}
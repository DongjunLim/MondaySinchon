#include <iostream> 
#include <string> 
#include <stack> 
//#include <Windows.h> 

using namespace std;

int main(){
	stack<char> stack_k, stack_c;
	int iter;
	// 반복 횟수 입력
	cin >> iter;
	while (iter--){
		// 테스트 케이스 입력
		string s;
		cin >> s;
		// 테스트 케이스의 길이만큼 반복
		for (int i = 0; i < s.size(); i++){
			// 해당 위치의 글자를 복사
			char c = s.at(i);
			// 해당 글자에 따라 진행
			switch (c){
				case '<':
					if (!stack_k.empty()){
						stack_c.push(stack_k.top());
						stack_k.pop();
					}
					break;
				case '>':
					if (!stack_c.empty()){
						stack_k.push(stack_c.top());
						stack_c.pop();
					}
					break;
				case '-':
					if (!stack_k.empty()){
						stack_k.pop();
					}
					break;
				default:
					stack_k.push(c);
				}
		}
        	// 창영이가 로깅한 비밀번호를 출력
		while (!stack_k.empty()){
			stack_c.push(stack_k.top());
			stack_k.pop();
		}
		while (!stack_c.empty()){
			cout << stack_c.top();
			stack_c.pop();
		}
		cout << "\n";

	}
	//system("pause");
	return 0;
}
//성공 파일
#include <iostream>
#include <cstring>
#include <string>
#include <stack>
#include <vector>
using namespace std;



int main()
{
	int n; //입력한 테스트 케이스 수
	string str; //입력되는 문자열
	stack<char> a; //문자 담는 스택
	stack<char> temp; //커서 이동 후 문자 담을 임시 스택
	vector<char> result; //결과값 받는 벡터

	cin >> n;

	while (n--) { //테스트 케이스 돌아가는 동안
		result.clear();

		cin >> str;

		for (int i = 0; i < str.length(); i++) {
			if (str[i] == '-') { //해당 문자열이 '-'에 해당하면
				if (!a.empty()) { //a 스택이 비어있지 않다면
					a.pop(); //마지막 요소 빼기
				}
			}
			else if (str[i] == '<') { //해당 문자열이 '<'을 만나면
				if (!a.empty()) { //a 스택이 비어있지 않다면
					temp.push(a.top()); //스택의 마지막 요소 임시 스택에 넣기
					a.pop(); //a 스택에는 마지막 요소 빼기
				}
			}
			else if (str[i] == '>') {
				if (!temp.empty()) { //임시 스택이 비어있지 않다면
					a.push(temp.top()); //현재 커서에 임시 스택에 있던 문자를 a 스택에 넣기
					temp.pop(); //임시 스택 마지막 요소 빼기
				}
			}
			else { //만약 알파벳이나 숫자일 때
				a.push(str[i]); //a 스택에 추가
			}
		}

		while (!temp.empty()) { //만약 임시 스택에 요소들이 존재한다면
			a.push(temp.top()); //a 스택에 임시 스택의 요소들 넣기
			temp.pop(); //임시 스택에 있는 요소들 제거
		}

		while (!a.empty()) { //a 스택에 요소들이 존재한다면
			result.push_back(a.top()); //result 벡터에 a 스택 요소들 넣기
			a.pop(); //a 스택에 있는 요소들 제거
		}

		reverse(result.begin(), result.end()); //스택은 LIFO 형태이기 때문에 역순으로 정렬함

		for (int i = 0; i < result.size(); i++) {
			cout << result[i];
		}

		cout << endl;
	}

	return 0;


}


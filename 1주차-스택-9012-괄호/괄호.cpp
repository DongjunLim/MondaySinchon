// baekjoon.cpp : 이 파일에는 'main' 함수가 포함됩니다. 거기서 프로그램 실행이 시작되고 종료됩니다.
//
//#include <string>
#include<stack>
#include <iostream>
#include <cstring>
//#include<vector>
using namespace std;

bool Check(string s) {
    stack<char> c; //스택 선언
    char ac; 
    int len = s.length(); //입력값 크기
    
    for (int i = 0; i < len; i++) {
        ac = s[i]; // 문자 하나씩 ac로 받음

        if (ac == '(') { //만약 문자 ac가 '(' 이라면
            c.push(s[i]); //스택에 추가
        }
        
        if (ac == ')') {//만약 문자 ac가 ')' 이라면
            if (!c.empty()) { //스택이 비어있지 않다면( 즉, '(' 가 들어있다면)
                c.pop(); //'('와 ')'가 만나기 때문에 팝 시켜서 스택을 비움
            }
            else {
                return false;
            }
        }

    }
    return c.empty(); //빈 스택을 리턴, 만약 괄호가 남아있다면 false 리턴
}


int main()
{
    int n; //입력받을 수
    string s; // 입력 받을 문자열

    cin >> n; //숫자 입력
    for (int i = 0; i < n; i++) {
        cin >> s; //입력되는 숫자만큼 테스트 케이스 받음
        if (Check(s)) { cout << "YES" << endl; }
        else { cout << "NO" << endl; }

    }
    return 0;
    
}


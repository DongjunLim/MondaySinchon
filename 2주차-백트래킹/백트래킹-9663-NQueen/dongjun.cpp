#include <iostream>
#include <vector>
#include <cstdlib>
using namespace std;


int answer = 0;     // 경우의 수를 기록할 변수
int n;              // 체스판 크기
int boardRow[15];   // 체스판 정보, 배열의 index = 체스판의 행, value = 해당 행에서 퀸을 놓은 열의 위치

// 퀸을 놓아도 되는지 확인하는 함수
bool check(int idx){
    // 0번 행부터 idx -1 번째 행까지 확인
    for(int i = 0; i<idx; i++){
        if(boardRow[i]==boardRow[idx] || abs(boardRow[idx]-boardRow[i]) == idx-i)
            return false;
    }
    return true;
}

// 매개변수 idx = 현재 행의 인덱스
int backtracking(int idx){
    
    // idx가 n보다 크면 모든 행을 확인 한 것이므로 answer를 1 증가
    if(idx == n)
        return ++answer;
    
    // 어떤 열에 퀸을 놓을지 고르는 반복문
    for(int col=0; col<n; col++){
        boardRow[idx] = col;    // 일단 퀸을 둠
        
        if(check(idx))
            backtracking(idx+1);     // 퀸을 놔서 문제가 없으면 다음행으로 이동
    }
    return 0;
}

int main(){
        
    cin >> n;
    
    // 탐색함수 호출
    backtracking(0);
    
    // 결과 호출
    cout << answer;
    
    return 0;
}


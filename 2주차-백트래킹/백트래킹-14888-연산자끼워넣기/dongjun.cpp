#include <iostream>
#include <vector>
#include <cstdlib>
using namespace std;

int n;          // 수열길이
int* arr;       // 수열을 담을 배열
int op[4];      // 연산자 갯수를 담을 배열
int maxAnswer = -999999999; // 최대값을 담을 변수
int minAnswer = 999999999;  // 최소값을 담을 변수

void findMaxMin(int index, int candidate, int plus, int minus, int multiply, int divide){
    
    // 기저사례일때 이제까지 구한 큰수와 작은수를 후보값과 각각 비교하여 갱신
    if(index == n){
        maxAnswer = candidate > maxAnswer ? candidate : maxAnswer;
        minAnswer = candidate < minAnswer ? candidate : minAnswer;
        return;
    }
    
    // 완전탐색. 연산자별로 재귀호출
    if(plus)
        findMaxMin(index + 1, candidate+arr[index], plus-1, minus, multiply, divide);
    if(minus)
        findMaxMin(index + 1, candidate-arr[index], plus,minus-1, multiply, divide);
    if(multiply)
        findMaxMin(index + 1, candidate*arr[index], plus,minus, multiply-1, divide);
    if(divide)
        findMaxMin(index + 1, int(candidate/arr[index]), plus,minus, multiply, divide-1);
    
    return;
}

int main(){
    
    cin >> n;
    
    arr = (int *)malloc(sizeof(int)*n);
    
    for(int i=0; i<n; i++)  cin >> arr[i];
    for(int i=0; i<4; i++) cin >> op[i];
    
    // 재귀호출, 수열의 0번 인덱스 값을 candidate의 초기값으로 설정
    findMaxMin(1, arr[0], op[0], op[1], op[2], op[3]);
    
    // 결과출력
    cout << maxAnswer << endl <<minAnswer;
    
    return 0;
}


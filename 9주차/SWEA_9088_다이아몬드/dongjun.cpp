/*
    1. 다이아몬드 배열을 정렬합니다.
    2. 정렬된 배열을 순회하며 각 숫자에서 만들 수 있는 묶음을 계산합니다.
    3. 묶음의 크기가 answer의 값보다 크면 answer를 갱신합니다.
    4. answer를 반환합니다.
 
    // O(n^2)의 성능을 이전의 구한 값을 이용해 O(n)으로 최적화 했습니다.
 */

#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;


int solve(int n, int k, vector<int> diamonds){
    int answer = 0;
    int j = 1, i = 0;
    int cnt = 1;

    sort(diamonds.begin(), diamonds.end());
    
    for(; i < n; i++){
        int start = diamonds[i];
        
        for(; j < n; j++){
            if(diamonds[j] - k > start) break;
            cnt++;
        }
        answer = max(cnt--, answer);
    }
    
    return answer;
}


int main(){
    
    int T;
    freopen("input.txt", "r", stdin);
    cin >> T;
    
    for(int tc=1; tc<=T; tc++){
        int N, K;
        
        cin >> N >> K;
        vector<int> diamonds(N);
        
        for(int i=0; i<N; i++)  cin >> diamonds[i];
        
        printf("#%d %d\n", tc, solve(N, K, diamonds));
    }
    return 0;
}

/*
  1. 전수조사했습니다.
*/

#include <iostream>
#include <vector>
#include <algorithm>
#define INF 2000000
using namespace std;

int main(){
  int T, tc;
  int N, M;
  int answer;
  int temp;

  cin >> T;

  for(tc=1; tc<=T; tc++){
    cin >> N >> M;

    vector<int> dp(N+1,0);
    vector<int> snacks(N+1);
    answer = -1;

    for(int i=1; i<=N; i++){
      cin >> snacks[i];
    }

    for(int i=1; i<N+1; i++){
      for(int j=1; j<N+1; j++){
        if(i==j)  continue;

        temp = snacks[j]+snacks[i];

        if(temp <= M && answer < temp)
          answer = temp;
      }
    }

    printf("#%d %d\n",tc,answer);
  }
  return 0;
}

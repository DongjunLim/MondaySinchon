#include <iostream>
#include <vector>
#include <cstdlib>

using namespace std;

// 로또 자리수
int length = 6;

// 반복횟수를 줄이기 위한 변수
int limit = 0;

// 입력 후보숫자를 받는 배열
vector<int> s;


// 정답 출력 함수
void printVector(vector<int> vct){
    for(int i=0; i<vct.size(); i++){
        cout << vct[i] <<" ";
    }
    cout << endl;
}


void dfs(int idx, vector<int> candidate){
    
    // 깊이가 로또 자리수가 되면 저장한 로또 번호 출력
    if(idx == length){
        printVector(candidate);
        return;
    }
    
    // 오름차순 조건에 맞는 범위를 반복하며 dfs 재귀호출
    for(int i=idx; i<limit+idx; i++){
        if(candidate.back() < s[i]){
            candidate.push_back(s[i]);
            dfs(idx+1, candidate);
            candidate.pop_back();
        }
    }
    
    
}

int main(){
    freopen("input.txt","r",stdin);
    int k;
    
    
    while(cin >> k){
        s.clear();
        
        int temp;
        for(int i=0; i< k; i++){
            cin >> temp;
            s.push_back(temp);
        }
        
        // 로또번호 후보를 저장하는 벡터
        vector<int> candidate;
        
        // 조건 오름차순에 맞게 반복문의 범위를 설정
        limit = s.size()-length+1;
        
        // 첫번재 자리수에 들어갈 수 있는 범위만큼 반복하며 dfs 호출
        for(int i=0; i< limit; i++){
            candidate.clear();
            candidate.push_back(s[i]);
            dfs(1, candidate);
            candidate.pop_back();
        }
        cout << endl;
        
    }
    return 0;
}


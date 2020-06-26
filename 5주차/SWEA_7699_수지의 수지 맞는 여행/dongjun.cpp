/*
    1. dfs�� Ǯ��.
    2. �湮��带 ����� visited ������ �迭 i,j�� �������� ���� �ʰ� ���ĺ� �ƽ�Ű��ȣ�� �ε����� ���.
    3. ����� ���̰� ��ü ���ĺ��� �� 26�� �Ǹ� ����ǵ��� ����.
 */

#include <iostream>
#include <vector>
#include <algorithm>
#define INF 2000000
using namespace std;
int answer, R, C;
vector<bool> visitedAlphabet;
vector<vector<char>> island(21, vector<char>(21));

void dfs(int row, int col, int cnt);

int main(){
    int T, tc;
    freopen("input.txt","r",stdin);
    cin >> T;
    for(tc = 1; tc<=T; tc++){
        cin >> R >> C;
        
        visitedAlphabet.clear();
        visitedAlphabet.resize(91,false);
        island.clear();
        island.resize(R, vector<char>(C));
        
        answer = 0;
        
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                cin >> island[i][j];
            }
        }
        
        dfs(0,0,0);
        printf("#%d %d\n",tc,answer);
    }
    return 0;
}

void dfs(int row, int col, int cnt){
    cnt++;
    visitedAlphabet[island[row][col]] = true;
    answer = max(answer,cnt);

    if(answer == 26)    return;
    
    if(row != 0 && !visitedAlphabet[island[row-1][col]]){
        dfs(row-1,col,cnt);
    }
    
    if(col != 0 && !visitedAlphabet[island[row][col-1]]){
        dfs(row,col-1,cnt);
    }
    
    if(row+1 < R && !visitedAlphabet[island[row+1][col]]){
        dfs(row+1,col,cnt);
    }
    
    if(col+1 < C && !visitedAlphabet[island[row][col+1]]){
        dfs(row,col+1,cnt);
    }
    
    visitedAlphabet[island[row][col]] = false;

}


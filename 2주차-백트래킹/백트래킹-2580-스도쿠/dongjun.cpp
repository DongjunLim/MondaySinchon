#include <iostream>
#include <vector>
#include <cstdlib>
using namespace std;

// 스도쿠판 선언
int board[9][9];

// 스도쿠판에서 값이 0인 좌표를 기록할 벡터 선언(채워야 할 좌표를 앞뒤로 왔다갔다 해야 하기 때문에 필요함)
vector<pair<int,int>> candidates;

// num이라는 값을 좌표에 놔도 되는지 확인하는 함수
bool check(int num, int row, int col){
    int x, y;
    
    // 가로와 세로에 중복되는 값이 있는지 확인.
    for(int j=0; j<9; j++){
        if(num == board[row][j] || num == board[j][col])    return false;
    }
    
    // 서브배열 순회를 위해 row와 col을 기준으로 현재좌표가 속한 서브배열의 첫번째 인덱스 좌표를 찾는다.
    x = int(row / 3) * 3;
    y = int(col / 3) * 3;
    
    // 자신이 속한 3 x 3 서브배열에 중복되는 값이 있는지 확인
    for(int i = x; i < (x + 3); i++){
        for(int j = y; j < (y + 3); j++){
            if(num == board[i][j])  return false;
        }
    }
    
    // 여기까지 왔다는건 가로, 세로, 셔브배열에 중복되는 값이 없다는거
    // 따라서 true를 리턴
    return true;
}

// 스도쿠판을 순회하며 값을 하나씩 채워나갈 dfs 함수
// 매개변수 idx = 채워야할 좌표값들의 순서.
void play(int idx){
    
/*  idx가 candidates 벡터의 사이즈와 같다는건 스도쿠판을 모두 채웠다는 것이다.
    따라서 결과를 출력하고 종료한다.
    여기서 종료하지 않으면 재귀함수가 계속 돌아가 값이 변경될 수 있다. */
    if((size_t)idx == candidates.size()){
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                cout << board[i][j] << " ";
            }
            cout << endl;
        }
        exit(0);
        return;
    }
    
    // 구하고자 하는 좌표값을 받는다.
    int row = candidates[idx].first, col = candidates[idx].second;
    
    // 좌표에 1부터 9까지 차례로 넣어본다.
    for(int i=1; i<10; i++){
        if(check(i,row,col)){       // 좌표에 i를 넣기전에 값을 넣을 수 있는지 check함수를 통해 혹인한다.
            board[row][col] = i;    // 넣어도 되면 좌표에 i를 넣는다.
            play(idx+1);            // 해당 좌표는 값을 넣었으니 다음 빈칸(값이 0인 좌표)로 이동한다.
        }
    }
    
    // for loop을 다 돌았는데 넣을 값이 없다면 재귀함수를 리턴한다.
    // 리턴하기 전에 해당좌표를 0으로 변경한다(이전 좌표에서부터 다시 채워야 하므로 리셋시킴).
    board[row][col] = 0;
    return;
}

int main(){
    
    for(int i=0; i<9; i++){
        for(int j=0; j<9; j++){
            cin >> board[i][j];
        }
    }
    
    // 보드판에서 값이 0인 좌표의 i,j인덱스를 candidates에 페어자료형으로 삽입한다.
    for(int i=0; i<9; i++){
        for(int j=0; j<9; j++)
            if(board[i][j]==0)  candidates.push_back(make_pair(i,j));
    }
    
    // dfs 호출
    play(0);
    
    return 0;
}


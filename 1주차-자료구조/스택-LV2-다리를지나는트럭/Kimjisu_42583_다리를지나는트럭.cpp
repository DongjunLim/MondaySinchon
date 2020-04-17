#include <string>
#include <vector>
#include <queue>
#include <iostream>

using namespace std;

int solution(int bridge_length, int weight, vector<int> truck_weights) {
	int answer = 0, next = 0, head_sec = 0;
	int now_weight;

	queue<pair<int, int>> passing_que;
	while (true) {
		answer++;
		if (bridge_length == answer - head_sec) {
			now_weight -= passing_que.front().second;
			passing_que.pop();
		}
		if (next < truck_weights.size()) {
			// 통과 중이 아닐 때
			if (passing_que.empty()) {
				now_weight = truck_weights[next];
				passing_que.push(make_pair(answer, truck_weights[next]));
				next++;
			}
			// 통과 중일 때 
			else {
				// 여러 대가 들어가도 되는지 체크
				if (now_weight + truck_weights[next] <= weight) {
					now_weight += truck_weights[next];
					passing_que.push(make_pair(answer, truck_weights[next]));
					next++;
				}

			}
		}

		// 끝 조건
		if (next == truck_weights.size() && passing_que.empty())
			break;
		else
			head_sec = passing_que.front().first;

	}
	return answer;
}

/*
테스트 1 〉	통과(0.01ms, 3.78MB)
테스트 2 〉	통과(0.09ms, 3.84MB)
테스트 3 〉	통과(0.00ms, 3.74MB)
테스트 4 〉	통과(0.07ms, 3.73MB)
테스트 5 〉	통과(0.65ms, 3.86MB)
테스트 6 〉	통과(0.19ms, 3.77MB)
테스트 7 〉	통과(0.01ms, 3.83MB)
테스트 8 〉	통과(0.01ms, 3.88MB)
테스트 9 〉	통과(0.04ms, 3.91MB)
테스트 10 〉	통과(0.01ms, 3.86MB)
테스트 11 〉	통과(0.00ms, 3.86MB)
테스트 12 〉	통과(0.01ms, 3.8MB)
테스트 13 〉	통과(0.03ms, 3.77MB)
테스트 14 〉	통과(0.01ms, 3.74MB)
*/

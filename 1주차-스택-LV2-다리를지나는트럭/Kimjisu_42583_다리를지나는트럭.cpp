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
			// ��� ���� �ƴ� ��
			if (passing_que.empty()) {
				now_weight = truck_weights[next];
				passing_que.push(make_pair(answer, truck_weights[next]));
				next++;
			}
			// ��� ���� �� 
			else {
				// ���� �밡 ���� �Ǵ��� üũ
				if (now_weight + truck_weights[next] <= weight) {
					now_weight += truck_weights[next];
					passing_que.push(make_pair(answer, truck_weights[next]));
					next++;
				}

			}
		}

		// �� ����
		if (next == truck_weights.size() && passing_que.empty())
			break;
		else
			head_sec = passing_que.front().first;

	}
	return answer;
}

/*
�׽�Ʈ 1 ��	���(0.01ms, 3.78MB)
�׽�Ʈ 2 ��	���(0.09ms, 3.84MB)
�׽�Ʈ 3 ��	���(0.00ms, 3.74MB)
�׽�Ʈ 4 ��	���(0.07ms, 3.73MB)
�׽�Ʈ 5 ��	���(0.65ms, 3.86MB)
�׽�Ʈ 6 ��	���(0.19ms, 3.77MB)
�׽�Ʈ 7 ��	���(0.01ms, 3.83MB)
�׽�Ʈ 8 ��	���(0.01ms, 3.88MB)
�׽�Ʈ 9 ��	���(0.04ms, 3.91MB)
�׽�Ʈ 10 ��	���(0.01ms, 3.86MB)
�׽�Ʈ 11 ��	���(0.00ms, 3.86MB)
�׽�Ʈ 12 ��	���(0.01ms, 3.8MB)
�׽�Ʈ 13 ��	���(0.03ms, 3.77MB)
�׽�Ʈ 14 ��	���(0.01ms, 3.74MB)
*/

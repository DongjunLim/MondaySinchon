#include <iostream>
#include <vector>

using namespace std;

vector<int> number;
vector<int> p_m_t_d;
int n;
int result[2] = { INT_MIN, INT_MAX };

void find_min_max(int count, int calc_num) {
	
	if (count >= n) {
		if (result[0] < calc_num)
			result[0] = calc_num;
		if (result[1] > calc_num)
			result[1] = calc_num;
		return;
	}
	for (int i = 0; i < 4; i++) {
		if (p_m_t_d[i]) {
			p_m_t_d[i]--;
			
			if (i == 0)
				calc_num += number[count];
			else if (i == 1)
				calc_num -= number[count];
			else if (i == 2)
				calc_num *= number[count];
			else
				calc_num /= number[count];
	
			find_min_max(count+1, calc_num);
			p_m_t_d[i]++;
		}
	}
}

int main() {
	
	
	cin >> n;

	number.assign(n, 0);
	p_m_t_d.assign(4, 0);

	for (int i = 0; i < n; i++)
		cin >> number[i];
	for (int i = 0; i < 4; i++)
		cin >> p_m_t_d[i];

	find_min_max(1,number[0]);

	cout << result[0] << '\n' << result[1];
}


//https://programmers.co.kr/learn/courses/30/lessons/42842

class Solution {
    public int[] solution(int brown, int red) {
        int[] answer = new int[2];
        int total = brown + red; //카펫의 총 수
        int x = 0, y = 0; //가로와 세로
        int max = 2005000; //red과 brown이 합쳐도 max보단 이하
        
        for (int i = 1; i <= total/2; i++) {
            if (total % i == 0) {
                x = total / i;
                y = total / x;
                
                if (x < y) //가로가 세로보다 작다면 continue, 아래 조건 무시
                    continue;
                
                //가로와 세로에서 -2씩 하면 빨간 카펫의 수와 같은지 확인
                //max보다 total이 작은지 확인
                if ((x-2) * (y-2) == red && max > x + y) { 
                    max = x + y;
                    answer[0] = x; //첫번째 원소에 a 값 대입
                    answer[1] = y; //두번째 원소에 b값 대입
                }
            }
        }
        return answer;
    }

}

    /**
     *
     * @문제접근
     * 투포인터를 이용해 풀었습니다.
     * 왼쪽에서 오른쪽ㅇ로 순회하며
     * 현재 위치에서 왼쪽과 비교해 캔디값을 갱신하고,
     * 반대로 오른쪽에서 왼쪽으로 순회하며
     * 현재 위치에서 오른쪽 값과 비교해 더 큰 값을 저장하고
     * 배열의 합을 구해 반환했습니다.
     *
     * @성능
     * Runtime: 2 ms
     * Memory Usage: 40 MB
     * 시간복잡도: O(N)
     */
    public int candy(int[] ratings) {
        int answer = 0;
        int[] candies = new int[ratings.length];
        Arrays.fill(candies, 1);

        for(int left = 1; left < ratings.length; left++){
            if(ratings[left-1] < ratings[left])
                candies[left] = candies[left-1] + 1;
        }

        for(int right = ratings.length-2; right >= 0; right--){
            if(ratings[right+1] < ratings[right])
                candies[right] = Math.max(candies[right], candies[right+1] + 1);
        }

        for(int s: candies)
            answer += s;

        return answer;
    }

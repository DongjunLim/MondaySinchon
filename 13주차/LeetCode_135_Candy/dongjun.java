    /**
     *
     * @��������
     * �������͸� �̿��� Ǯ�����ϴ�.
     * ���ʿ��� �����ʤ��� ��ȸ�ϸ�
     * ���� ��ġ���� ���ʰ� ���� ĵ���� �����ϰ�,
     * �ݴ�� �����ʿ��� �������� ��ȸ�ϸ�
     * ���� ��ġ���� ������ ���� ���� �� ū ���� �����ϰ�
     * �迭�� ���� ���� ��ȯ�߽��ϴ�.
     *
     * @����
     * Runtime: 2 ms
     * Memory Usage: 40 MB
     * �ð����⵵: O(N)
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

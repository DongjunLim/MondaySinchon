import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
		
		for (int work : works) pq.offer(work);
        
        for (int i = 0; i < n; i++) {
            int max = (int)pq.poll();
            if (max <= 0) break;
            pq.offer(max - 1);
        }
        
        long result = 0;
        while (!pq.isEmpty()) {
            result += Math.pow(pq.poll(), 2);
        }
		
		return result;
    }
}

import java.util.*;

class Solution {
    public int solution(int[] citations) { 
        Arrays.sort(citations);
		int result = citations.length;
		int h_index = 0;

		while(true){
			int upCnt = 0;
			int downCnt = 0;
			
			if(h_index == citations.length + 1) break;

			for(int i = 0; i < citations.length; i++){
				if(h_index <= citations[i]) upCnt++;
			}

			downCnt = citations.length - upCnt;

			if(downCnt <= h_index && upCnt >= h_index){
				result = h_index;
			}
			h_index++;
		}
        return result;
    }
}

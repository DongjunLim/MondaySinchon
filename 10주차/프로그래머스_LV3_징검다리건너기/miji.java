public class Bridge {
	
	//접근방법: 징검다리를 연속적으로 k개씩 묶어 각각 최댓값을 구함
	// 구한 최댓값을 다른 집합의 최댓값을 비ㅛ해서 최솟값을 구함

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] stones = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
		int k =3;
		int answer = 0;
		
        int min = Integer.MAX_VALUE;
		
		for(int i=0; i<=stones.length-k; ){
			//System.out.println("i="+i);//0 3 4 7
			 int max = stones[i];//구간의 처음 요소를 max 변수에 추가
			 //System.out.println("max="+max);//2 3 2 2 
	         int idx = 0;//다음 i의 위치를 지정할 인덱스 변수
            
            for(int j=i+1; j<i+k; j++) {
            	if(stones[j] >= max) { //현재 구간의 징검다리 구간의 최댓값보다 크거나 같을 때
            		idx = j; //인덱스를 현재 징검다리 인덱스로 변경
            		max=stones[j]; //구간의 최댓값을 현재 징검다리로 변경
            		
            	}
            }
            
            if(idx == 0) i++;//구간의 최댓값이 변경되지 않았을 때 한칸만 이동
            else {
            	i=(idx+1);
            }
            min=Math.min(min, max);//구간의 최댓값이 다른 구간과 비교했을 때, 더 작은 구간의 최댓값을 결값에 설정
            answer= min;
		}
		
		System.out.print(answer);
	}

}

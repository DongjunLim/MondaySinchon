
//https://www.acmicpc.net/problem/1655

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Middle {
	
	/*2개의 PriorityQueue를 선언한다. → 각각을 minHeap, maxHeap
	 * 각 PriorityQueue는 작은 값, 큰 값 우선순위를 가지게 Comparator인터페이스의 메소드를 오버라이딩.
	 * 두 개의 PriorityQueue의 크기가 같은 경우 maxHeap에 입력된 값을 추가
	 * 입력한 값이 minHeap의 최솟값보다 크다면 둘을 swap
	 * 두 개의 크기가 다른 경우 minHeap에 입력된 값을 추가
	 * 입력한 값이 maxHeap의 최댓값보다 작다면 둘을 swap
	 * maxHeap의 top에 위치한 값이 중간 값
	*/

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
		PriorityQueue<Integer> minHeap = new PriorityQueue<>((o1, o2) -> o1 - o2);

		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(br.readLine());
			
			if(i%2 == 0) maxHeap.add(num); 
			else minHeap.add(num); 
			
			if(!maxHeap.isEmpty() && !minHeap.isEmpty()) {
				if(maxHeap.peek() > minHeap.peek()) { // swap
					int tmp = maxHeap.poll();
					maxHeap.add(minHeap.poll());
					minHeap.add(tmp);
				}
			}
			
			System.out.println(maxHeap.peek());
		}
			
	}
		

}


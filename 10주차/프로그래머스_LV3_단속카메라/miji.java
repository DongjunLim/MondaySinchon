import java.util.*;

/*1. 진입점을 기준으로 오름차순으로 정렬.
2. 현재 설치 예정 구간(겹치는 구간)과 자동차의 주행 구간을 비교해 설치 예정 구간을 통과하는지 확인.
   -통과한다면 설치 예정 구간을 완벽하게 겹치는 구간으로 갱신.
   -통과하지 않는다면 단속 카메라를 늘리고 새로운 설치 예정 구간(현재 자동차의 주행구간)으로 갱신.*/
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] routes= {{-20,15}, {-14,-5}, {-18,-13}, {-5,-3}};
		 int answer = 1; //카메라 개수
	        
	        int camera = -30001; // 카메라의 위치 
	        
	        Arrays.sort(routes, new Comparator<int[]>(){//차량이 나간 지점 기준으로 routes 정렬
	           @Override
	            public int compare(int[] a, int[] b){
	                return a[0] - b[0];
	            }
	        }); 
	        
	        int min = routes[0][0];
	        int max = routes[0][1];
	        
	        for(int i=0; i<routes.length; i++){
	            int in = routes[i][0];
	            int out = routes[i][1];
	            
	            // 현재 차의 진출 지점보다 다음 차의 진입 지점이 더 클경우
				// -> 단속 범위를 벗어나므로 카메라 +1 , 다음 단속범위 지정
	            if(in > max || out < min){
	                answer = answer+1;
	                max = out; min = in;
	            }else{
	                min = in > min ? in : min;
	                max = max > out ? out : max;
	            }
	        }
	        System.out.print(answer);
	    }
	}

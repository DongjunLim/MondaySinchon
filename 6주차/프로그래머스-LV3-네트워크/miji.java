import java.util.LinkedList;
import java.util.Queue;

class Solution {
    static int answer;
    static boolean[] check;
    static int n;
    static int[][] computers; 
    
    public int solution(int n, int[][] computers) {
        answer = 0;
        check = new boolean[n+1];
        
        for(int i=0; i<n; i++){
            if(!check[i]){
                bfs(i, computers);
                answer++;
            }
        }
        
        return answer;
		
	}
	
	public static void bfs(int v, int[][] computers) {
		
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(v);
		check[v] = true; 

		while(!q.isEmpty()) {
			int tmp = q.poll(); 
			for(int i=0; i<computers.length; i++) {
                //방문하지 않았고 자기 자신이 아닌 경우
				if(!check[i] && computers[tmp][i] == 1 && tmp != i) {
					check[i] = true; 
					q.offer(i);
				}
                
			}
		}

	}
}
  

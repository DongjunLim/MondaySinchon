package PRO;

class PRO_43162_네트워크 {
    
    public static int cnt;
	public static boolean visited[];
    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
		
		for(int i = 0; i < computers.length; i++) {
			if(!visited[i]) {
				visited[i] = true;
				dfs(i, computers);
				cnt++;
			}
		}
        
        return cnt;
    }
    
    private static void dfs(int n, int computers[][]) {
		
		for(int i = 0; i < computers[n].length; i++) {
			if(visited[i]) continue;
			if(computers[n][i] == 0) continue;
			
			visited[i] = true;
			dfs(i, computers);
		}
	}
}

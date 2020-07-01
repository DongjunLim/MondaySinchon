package Algorithm.MondaySinchon.ProgrammersNetwork;

class Solution {

    static boolean visited[];

    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[computers.length];

        for (int i = 0; i < computers.length; i++){
            if (!visited[i]){
                answer++;
                dfs(i, visited, computers);
            }
        }
        return answer;
    }


    public static void dfs(int node, boolean visited[], int computers[][]){

        visited[node] = true;

        for (int i = 0; i < computers.length; i++){
            if (!visited[i] && computers[node][i] == 1){
                dfs(i, visited, computers);
            }
        }
    }
}
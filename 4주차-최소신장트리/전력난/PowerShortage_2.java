
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/6497


public class PowerShortage_2 {
	
	static int m; // 집의 수
	static int n; // 길의 수(간선)
	static PriorityQueue<A> pq; // 간선 값을 Min Heap 으로 하는 우선순위 큐
	static int[] parent;   // disjoint-set(union find)에서 필요한 부모 노드를 저장하는 배열
	static boolean[] visit; //방문 여부 배열
	static int result; //결과(최소비용) 값 저장
	static int totalCost; //총 비용 값 저장
	
	static class A implements Comparable<A>{ //x좌표, y좌표, z 비용 생성
	    int x;
	    int y;
	    int z;
	    public A(int x, int y, int z) {
	        super();
	        this.x = x;
	        this.y = y;
	        this.z = z;
	    }
	    @Override
	    public int compareTo(A arg0) { //min Heap을 만들기 위한 우선순위 큐용 Comparable 메서드
	    	if(this.z > arg0.z) return 1;
            return -1;
     
	    }
	  
	      
	}
	
	public static int find(int a){
		 if(a==parent[a]) return a; //초기화된 상태(정점이 처음 등장)이면 자기 자신이 부모
	        parent[a] = find(parent[a]); //find 할 때마다 부모는 최상위부모로 설정 (성능 향상)
	        return parent[a];
	        //return find(parent[a]); ← 최상위 부모를 저장하지 않고 매번 여러 단계를 올라가 찾으면 시간 초과 발생

    }
	
    public static void union(int a, int b){
        int aRoot = find(a);
        int bRoot = find(b);
        if(aRoot == bRoot){ //부모가 같으면 사이클 형성되기 때문에 false
            return;
        } 
   
        parent[bRoot] = a;
        
    }

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
        
        while( true) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
            
    		m = Integer.parseInt(st.nextToken());  //집의 개수
            n = Integer.parseInt(st.nextToken());  // 길(간선)의 개수
            
            //////while문 아래 stringtokenizer와 m,n 설정을 안해주면 런타임 에러 발생//////
        	
        	if (m == 0 && n == 0) break;
              
            parent = new int[m+1];  //Disjoint-set 
            visit  = new boolean[m+1];
            result = 0;
              
            pq = new PriorityQueue<A>();
            String [] tempStr ;
            totalCost=0;
            for (int i = 0; i < n; i++) {
                tempStr = br.readLine().split(" ");
                pq.add(new A(Integer.valueOf(tempStr[0]), Integer.valueOf(tempStr[1]), Integer.valueOf(tempStr[2])));
                totalCost += Integer.valueOf(tempStr[2]);
            } //모든 간선에 대해 [시작, 끝, 비용] 을 가진 클래스로 우선순위 큐에 add
              
            for (int i = 1; i < m+1; i++) {
                parent[i]=i;
            } // union-find 의 초기화는 일단 자기 자신의 부모노드는 자기 자신으로 설정
              
            for (int i = 0; i < n; i++) { //모든 간선에 대해서 확인
                A oneNode = pq.poll(); // 현재 큐에 있는 모든 인스턴스 중 비용이 가장 작은 간선이 poll 된다.
                int start = oneNode.x; //x좌표를 시작점으로 설정
                int end = oneNode.y; //y좌표를 도착점으로 설정
                int a = find(start); // 만약 이 간선을 선택해서 연결한다고 했을때 사이클이 생기면 안되므로 
                int b = find(end);   // 양쪽의 루트(최상위부모)노드가 무엇인지 확인하고
                if( a == b ) continue; //만약 같으면 선택하지 않고 넘어간다.
                  
                union(start,end); //두개의 루트 노드가 달랐다면 한쪽의 최상위 부모를 다른 한쪽의 부모로 설정하고
                result += oneNode.z; //선택된 간선이므로 간선의 비용을 더한다.
                
            }
            int answer = 0;
            answer = totalCost - result;
            System.out.println(answer);
            pq.clear();
        }
        
        

	}

}

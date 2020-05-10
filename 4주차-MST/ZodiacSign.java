import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;


//https://www.acmicpc.net/problem/4386

public class ZodiacSign{
	static int N; // 정점의 개수
	
	static ArrayList<Edge> pq; // 간선 값을 Min Heap 으로 하는 우선순위 큐
	static int[] parent;   // disjoint-set(union find)에서 필요한 부모 노드를 저장하는 배열
	static boolean[] visit; //방문 여부 배열
	static int result; //결과 값 저장
	static Pos[] spos;//새로 입력받는 좌표 저장하는 배열
	static DJS djs;
	static class Pos{ //입력되는 x와 y좌표
		double x,y;
		Pos(double x, double y){
			this.x = x;
			this.y = y;
		}
	}
	  
	static class Edge implements Comparable<Edge>{
	    int s;
	    int e;
	    double v;
	    public Edge(int s, int e, double v) {
	        super();
	        this.s = s;
	        this.e = e;
	        this.v = v;
	    }
	    @Override
	    public int compareTo(Edge o) { //가중치의 min값을 구하기 위한  Comparable 메서드
	    	 if(this.v > o.v) return 1;
	            return -1;
	        }
	  
	}      


	static double distance(Pos A, Pos B) { //두 좌표의 거리를 구하는 메서드
        return Math.sqrt(Math.pow((A.x-B.x),2) + Math.pow((A.y-B.y),2));

	}
	 
	static class DJS { //Disjoint-set
	        DJS(int n){ //자기 자신의 부모노드는 자기자신으로 설정
	            parent = new int[n+1];
	            for (int i = 1; i <=n ; i++) parent[i] = i;
	        }
	        int find(int n) {
	            if(n==parent[n]) return n; //초기화된 상태(첫 정점)이면 자기 자신이 부모가 된다.
	            return parent[n] = find(parent[n]); //find할 때마다 부모는 최상위부모로 설정
	        }

	      
	    boolean union(int a, int b){
	        int aRoot = find(a);
	        int bRoot = find(b);
	        if(aRoot == bRoot){ //부모가 같으면 사이클 형성되기 때문에 false
	            return false;
	        } parent[bRoot] = a;
	        return true;
	    }
	  
	}
	 public static void main(String[] args) throws IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        N = Integer.parseInt(br.readLine().trim());
	        spos = new Pos[N];
	        djs = new DJS(N);
	        double x, y;
	        StringTokenizer st;
	        pq = new ArrayList<>();
	        for (int i = 0; i < N; i++) {
	            st = new StringTokenizer(br.readLine().trim(), " ");
	            x = Double.parseDouble(st.nextToken());
	            y = Double.parseDouble(st.nextToken());
	            spos[i] = new Pos(x, y);
	            for (int j = 0; j < i ; j++) {
	            	//새로운 좌표의 정보와 최소 거리를 리스트에 추가
	                pq.add(new Edge(i,j,distance(spos[i],spos[j])));
	            }
	        }

	        //Kruskal algorithm
	        Collections.sort(pq);

	        double result = 0;
	        for (Edge ed:pq) { //ed에 가중치 값을 히니씩 추가하는 동안
	        	//사이클이 형성되지 않는다면 result에 가중치 값 추가
	            if(djs.union(ed.s, ed.e)) result += ed.v;
	        }

	        System.out.println(String.format("%.2f", result)); //소숫점2자리로 출력
	    }

	        
	 }


  


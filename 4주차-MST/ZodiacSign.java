import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;


//https://www.acmicpc.net/problem/4386

public class ZodiacSign{
	static int N; // ������ ����
	
	static ArrayList<Edge> pq; // ���� ���� Min Heap ���� �ϴ� �켱���� ť
	static int[] parent;   // disjoint-set(union find)���� �ʿ��� �θ� ��带 �����ϴ� �迭
	static boolean[] visit; //�湮 ���� �迭
	static int result; //��� �� ����
	static Pos[] spos;//���� �Է¹޴� ��ǥ �����ϴ� �迭
	static DJS djs;
	static class Pos{ //�ԷµǴ� x�� y��ǥ
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
	    public int compareTo(Edge o) { //����ġ�� min���� ���ϱ� ����  Comparable �޼���
	    	 if(this.v > o.v) return 1;
	            return -1;
	        }
	  
	}      


	static double distance(Pos A, Pos B) { //�� ��ǥ�� �Ÿ��� ���ϴ� �޼���
        return Math.sqrt(Math.pow((A.x-B.x),2) + Math.pow((A.y-B.y),2));

	}
	 
	static class DJS { //Disjoint-set
	        DJS(int n){ //�ڱ� �ڽ��� �θ���� �ڱ��ڽ����� ����
	            parent = new int[n+1];
	            for (int i = 1; i <=n ; i++) parent[i] = i;
	        }
	        int find(int n) {
	            if(n==parent[n]) return n; //�ʱ�ȭ�� ����(ù ����)�̸� �ڱ� �ڽ��� �θ� �ȴ�.
	            return parent[n] = find(parent[n]); //find�� ������ �θ�� �ֻ����θ�� ����
	        }

	      
	    boolean union(int a, int b){
	        int aRoot = find(a);
	        int bRoot = find(b);
	        if(aRoot == bRoot){ //�θ� ������ ����Ŭ �����Ǳ� ������ false
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
	            	//���ο� ��ǥ�� ������ �ּ� �Ÿ��� ����Ʈ�� �߰�
	                pq.add(new Edge(i,j,distance(spos[i],spos[j])));
	            }
	        }

	        //Kruskal algorithm
	        Collections.sort(pq);

	        double result = 0;
	        for (Edge ed:pq) { //ed�� ����ġ ���� ���Ͼ� �߰��ϴ� ����
	        	//����Ŭ�� �������� �ʴ´ٸ� result�� ����ġ �� �߰�
	            if(djs.union(ed.s, ed.e)) result += ed.v;
	        }

	        System.out.println(String.format("%.2f", result)); //�Ҽ���2�ڸ��� ���
	    }

	        
	 }


  


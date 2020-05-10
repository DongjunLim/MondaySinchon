
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/6497


public class PowerShortage_2 {
	
	static int m; // ���� ��
	static int n; // ���� ��(����)
	static PriorityQueue<A> pq; // ���� ���� Min Heap ���� �ϴ� �켱���� ť
	static int[] parent;   // disjoint-set(union find)���� �ʿ��� �θ� ��带 �����ϴ� �迭
	static boolean[] visit; //�湮 ���� �迭
	static int result; //���(�ּҺ��) �� ����
	static int totalCost; //�� ��� �� ����
	
	static class A implements Comparable<A>{ //x��ǥ, y��ǥ, z ��� ����
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
	    public int compareTo(A arg0) { //min Heap�� ����� ���� �켱���� ť�� Comparable �޼���
	    	if(this.z > arg0.z) return 1;
            return -1;
     
	    }
	  
	      
	}
	
	public static int find(int a){
		 if(a==parent[a]) return a; //�ʱ�ȭ�� ����(������ ó�� ����)�̸� �ڱ� �ڽ��� �θ�
	        parent[a] = find(parent[a]); //find �� ������ �θ�� �ֻ����θ�� ���� (���� ���)
	        return parent[a];
	        //return find(parent[a]); �� �ֻ��� �θ� �������� �ʰ� �Ź� ���� �ܰ踦 �ö� ã���� �ð� �ʰ� �߻�

    }
	
    public static void union(int a, int b){
        int aRoot = find(a);
        int bRoot = find(b);
        if(aRoot == bRoot){ //�θ� ������ ����Ŭ �����Ǳ� ������ false
            return;
        } 
   
        parent[bRoot] = a;
        
    }

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
        
        while( true) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
            
    		m = Integer.parseInt(st.nextToken());  //���� ����
            n = Integer.parseInt(st.nextToken());  // ��(����)�� ����
            
            //////while�� �Ʒ� stringtokenizer�� m,n ������ �����ָ� ��Ÿ�� ���� �߻�//////
        	
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
            } //��� ������ ���� [����, ��, ���] �� ���� Ŭ������ �켱���� ť�� add
              
            for (int i = 1; i < m+1; i++) {
                parent[i]=i;
            } // union-find �� �ʱ�ȭ�� �ϴ� �ڱ� �ڽ��� �θ���� �ڱ� �ڽ����� ����
              
            for (int i = 0; i < n; i++) { //��� ������ ���ؼ� Ȯ��
                A oneNode = pq.poll(); // ���� ť�� �ִ� ��� �ν��Ͻ� �� ����� ���� ���� ������ poll �ȴ�.
                int start = oneNode.x; //x��ǥ�� ���������� ����
                int end = oneNode.y; //y��ǥ�� ���������� ����
                int a = find(start); // ���� �� ������ �����ؼ� �����Ѵٰ� ������ ����Ŭ�� ����� �ȵǹǷ� 
                int b = find(end);   // ������ ��Ʈ(�ֻ����θ�)��尡 �������� Ȯ���ϰ�
                if( a == b ) continue; //���� ������ �������� �ʰ� �Ѿ��.
                  
                union(start,end); //�ΰ��� ��Ʈ ��尡 �޶��ٸ� ������ �ֻ��� �θ� �ٸ� ������ �θ�� �����ϰ�
                result += oneNode.z; //���õ� �����̹Ƿ� ������ ����� ���Ѵ�.
                
            }
            int answer = 0;
            answer = totalCost - result;
            System.out.println(answer);
            pq.clear();
        }
        
        

	}

}

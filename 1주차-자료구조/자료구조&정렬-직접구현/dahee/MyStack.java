public class MyStack {

	public static Node top;

	// 연결 리스트 이용
	public static class Node{
		Object data;
		Node nextNode;
	}

	public MyStack() {
		this.top = null;
	}

	public static void push(Object obj) {
		Node node = new Node(); // 넣을 Node 생성
		node.data = obj; // Node의 데이터 부분에 입력으로 들어온 Object 셋팅
		node.nextNode = top; // Node의 nextNode는 top으로 설정
		top = node; // 가장 최근 삽입한 노드이기 때문에 top을 만든 node로 설정
	}

	public static Object pop() {
		if(!isEmpty()) {
			Object data = peek();
			top = top.nextNode;
			return data;
		}
		else return "NullPointException";
	}

	public static boolean isEmpty() {
		return (top == null);
	}

	public static Object peek() {
		if(!isEmpty()) return top.data;
		else return "No data";
	}
}

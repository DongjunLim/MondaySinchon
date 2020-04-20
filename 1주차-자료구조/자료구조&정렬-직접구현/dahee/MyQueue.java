
public class MyQueue {
	
	public static Node front;
	public static Node rear;
	
	public static class Node{
		Object data;
		Node nextNode;
	}
	
	public MyQueue() {
		this.front = null;
		this.rear = null;
	}
	
	public static void offer(Object obj) {
		Node node = new Node();
		node.data = obj;
		node.nextNode = null;
		
		if(isEmpty()) {
			front = node;
			rear = node;
		}
		else {
			rear.nextNode = node;
			rear = node;
		}
	}
	
	public static Object poll() {
		if(!isEmpty()) {
			Object data = peek();
			front = front.nextNode;
			return data;
		}
		else return "NullPointException";
	}
	
	public static boolean isEmpty() {
		return (front == null);
	}
	
	public static Object peek() {
		if(!isEmpty()) return front.data;
		else return "No data";
	}
}

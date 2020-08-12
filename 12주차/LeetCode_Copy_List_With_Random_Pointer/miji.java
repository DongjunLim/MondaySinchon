/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

//깊은복사(deep copy)는 복합객체 복사 + 그 내용도 재귀적으로 복사
//처음에 만들었던 객체와 복사된 객체가 전혀 달라지기 때문에 어느 한쪽을 수정한다고 해서 다른 한쪽이 영향 받는 일이 없음.


class Solution {
    HashMap<Node, Node> map = new HashMap<>();
    
    public Node copyRandomList(Node head) {
        
        
        if(head == null || map.containsKey(head)){
            return map.get(head);
        } 
        Node copy = new Node(head.val); //복사할 노드 생성
        map.put(head, copy); //맵에 원래 노드와 복사 노드 추가
        copy.next = copyRandomList(head.next);
        copy.random = copyRandomList(head.random);
        
        return copy;
        
    }
}

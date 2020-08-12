class Solution {
    /*
      해쉬맵으로 구현하여 시간 복잡도 -> O(n)
      현재 탐색하는 노드의 다음인 next node를 연결해주고 random도 마찬가지로 연결해줌.
      그리고 head를 뽑아서 리턴
    */
    
    public Node copyRandomList(Node head) {
        if (head == null) return null;
  
          Map<Node, Node> map = new HashMap<Node, Node>();

          Node node = head;
          while (node != null) {
            map.put(node, new Node(node.val));
            node = node.next;
          }

          node = head;
          while (node != null) {
            map.get(node).next = map.get(node.next);
            map.get(node).random = map.get(node.random);
            node = node.next;
          }

          return map.get(head);
    }
}

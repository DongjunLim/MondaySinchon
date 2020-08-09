/**
 *   @문제접근
 *   그냥 더럽게 풀었습니다.
 *
 *   @성능
 *   Runtime: 2 ms
 *   Memory Usage: 39.1 MB.
 */

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


class childNode extends Node {
    int randomNodeIdx;

    public childNode(int val){
        super(val);
    }
}


class Solution138 {
    public Node copyRandomList(Node head) {
        if(head == null)
            return null;

        ArrayList<childNode> nodeList = new ArrayList<>();

        Node temp = head;

        while(true) {
            // 노드 복사
            childNode now = new childNode(temp.val);
            now.next = new childNode(temp.next.val);

            int idxCnt = 0;

            if(temp.random == null)
                now.randomNodeIdx = -1;
            // 랜덤노드의 인덱스 찾기
            else {
                Node tempForFindRandomNode = head;
                while (true) {
                    if (temp.random.equals(tempForFindRandomNode)){
                        now.randomNodeIdx = idxCnt;
                        break;
                    }
                    if (tempForFindRandomNode.next == null)
                        break;
                    tempForFindRandomNode = tempForFindRandomNode.next;
                    idxCnt++;
                }
            }
            
            nodeList.add(now);
            if(temp.next == null)
                break;
            temp = temp.next;
        }

        // 랜덤 노드 세팅
        for(int i = 0; i < nodeList.size(); i++){
            childNode now = nodeList.get(i);

            if(now.randomNodeIdx != -1)
                now.random = nodeList.get(now.randomNodeIdx);
        }

        return nodeList.get(0);
    }
}


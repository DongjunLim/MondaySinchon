/**
  * @문제접근
  * 이진탐색트리는 중위순회하면 정렬된 값을 얻을 수 있는 걸 이용해 풀었습니다.
  *
  */
class Solution {
    public static ArrayList<Integer> arr = new ArrayList<>();
    public int kthSmallest(TreeNode root, int k) {
        arr.clear();
        searchTree(root, k);
        return arr.get(k-1);
    }
    public void searchTree(TreeNode now, int k){
        if(now == null)
            return;
        
        searchTree(now.left, k);
        arr.add(now.val);
        searchTree(now.right, k);
    }
}

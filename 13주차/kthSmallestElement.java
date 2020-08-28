/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

//https://leetcode.com/problems/kth-smallest-element-in-a-bst/submissions/

class Solution {
    int count = 0;
    int ans = 0;
    public int kthSmallest(TreeNode root, int k) {
        //int k = Integer.MAX_VALUE;
        if(root == null) return -1;
        find(root, k);
        
        return ans;
        
    }
    public void find(TreeNode node, int k){
        //노드가 존재하지 않을 때
        if(node == null) return;
        
        //1. 왼쪽 노드 탐색, count 증가
        find(node.left, k);
        count++;
        
      
        if(count== k){
           ans = node.val; //현재 노드의 값을 답에 저장
            
        }
        2. 오른쪽 노드 탐색
        find(node.right, k);
    }
}
package Algorithm.MondaySinchon.LeetKthSmallestElementInABST;


// BST에서 중위순회하게되면 정렬된 값이 나온다
// https://muckycode.blogspot.com/2015/01/binary-search-treebst.html

import java.util.ArrayList;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}


class Solution {

    public static ArrayList<Integer> arrayList = new ArrayList<>();

    public int kthSmallest(TreeNode root, int k) {

        arrayList.clear();
        searchTree(root, k);
        return arrayList.get(k - 1);

    }

    public void searchTree(TreeNode current, int k){
        if (current == null){
            return;
        }

        searchTree(current.left, k);
        arrayList.add(current.val);
        searchTree(current.right, k);
    }
}
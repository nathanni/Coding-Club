package com.nathan.amazon;


/**
 * Created by Nathan on 11/21/16.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class BST_Minimum_Path_Sum {
    public int Solution(TreeNode root) {
        if (root == null) return 0;
        if (root.left != null && root.right == null)
            return Solution(root.left) + root.val;
        if (root.left == null && root.right != null)
            return Solution(root.right) + root.val;
        return Math.min(Solution(root.left), Solution(root.right)) + root.val;
    }
}

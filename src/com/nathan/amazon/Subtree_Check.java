package com.nathan.amazon;

/**
 * Created by nni on 11/22/2016.
 */
public class Subtree_Check {
    public boolean isSubtree(TreeNode t1, TreeNode t2) {
        if (t2 == null) return true;
        if (t1 == null) return false;
        return (isSameTree(t1, t2) || isSubtree(t1.left, t2) || isSubtree(t1.right, t2));
    }

    private boolean isSameTree(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        if (t1.val != t2.val) return false;

        return isSameTree(t1.left, t2.left) && isSameTree(t1.right, t2.right);
    }
}

package com.nathan.bittiger.verifyHeap;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Nathan on 9/21/2016.
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }

}


public class Solution {
    public static boolean isHeap(TreeNode root) {
        if (root == null) return true;

        return isSmaller(root) && isComplete(root);
    }

    private static boolean isSmaller(TreeNode root) {

        if (root == null) return true;

        if (root.left != null && root.val > root.left.val) return false;
        if (root.right != null && root.val > root.right.val) return false;
        return isSmaller(root.left) && isSmaller(root.right);

    }

    private static boolean isComplete(TreeNode root) {
        return countNode(root) == maxIndex(root, 0) + 1;
    }

    private static int countNode(TreeNode root) {
        if (root == null) return 0;
        return countNode(root.left) + countNode(root.right) + 1;
    }

    private static int maxIndex(TreeNode root, int i) {
        if (root == null) return -1;
        return Math.max(i, Math.max(maxIndex(root.left, i * 2 + 1), maxIndex(root.right, i * 2 + 2)));
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("src/com/nathan/bittiger/verifyHeap/input"));

        int n = sc.nextInt();

        while (n != -1) {
            TreeNode[] treeNodes = new TreeNode[n];
            for (int i = 0; i < n; i++) {
                treeNodes[i] = new TreeNode(0);
            }

            for (int i = 0; i < n; i++) {
                int val = sc.nextInt();
                treeNodes[i].val = val;
                int leftIdx = sc.nextInt();
                int rightIdx = sc.nextInt();
                if (leftIdx != -1) treeNodes[i].left = treeNodes[leftIdx];
                if (rightIdx != -1) treeNodes[i].right = treeNodes[rightIdx];
            }

            System.out.println(isHeap(treeNodes[0]));
            n = sc.nextInt();
        }
        sc.close();
    }

}

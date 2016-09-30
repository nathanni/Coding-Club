package com.nathan.bittiger.treeTraverse;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Created by nni on 9/21/2016.
 */

class TreeNode {
    int val;
    TreeNode left, right;

    public TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }

}

class Pair {
    TreeNode node;
    int type;
    public Pair(TreeNode node, int type) {
        this.node = node;
        this.type = type; //0 first time 1 print
    }
}


class Traverse {


    //0 preorder, 1 inorder, 2 postorder
    public static List<Integer> traverseByType(TreeNode root, int order) {
        List<Integer> res = new ArrayList<>();
        if (root == null || order < 0 || order > 2) return res;

        Deque<Pair> stack = new LinkedList<>();

        stack.push(new Pair(root, 0));

        while (!stack.isEmpty()) {
            Pair pair = stack.pop();
            if (pair.node == null) continue;

            if (pair.type == 1) {
                res.add(pair.node.val);
                continue;
            }

            switch (order) {
                case 0:
                    stack.push(new Pair(pair.node.right, 0));
                    stack.push(new Pair(pair.node.left, 0));
                    stack.push(new Pair(pair.node, 1));
                    break;
                case 1:
                    stack.push(new Pair(pair.node.right, 0));
                    stack.push(new Pair(pair.node, 1));
                    stack.push(new Pair(pair.node.left, 0));
                    break;
                case 2:
                    stack.push(new Pair(pair.node, 1));
                    stack.push(new Pair(pair.node.right, 0));
                    stack.push(new Pair(pair.node.left, 0));
                    break;

            }
        }

        return res;


    }



    public static List<Integer> preorder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            res.add(node.val);

            if (node.right != null) {
                stack.push(node.right);
            }

            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return res;

    }

    public static List<Integer> inorder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Deque<TreeNode> stack = new LinkedList<>();

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            TreeNode node = stack.pop();
            res.add(node.val);
            root = node.right;
        }
        return res;


    }

    public static List<Integer> postorder1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Deque<TreeNode> stack = new LinkedList<>();

        TreeNode prev = null;
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode curr = stack.peek();
            if (prev == null || prev.left == curr || prev.right == curr) {
                if (curr.left != null) {
                    stack.push(curr.left);
                } else if (curr.right != null) {
                    stack.push(curr.right);
                }
            } else if (curr.left == prev) {
                if (curr.right != null) {
                    stack.push(curr.right);
                }
            } else {
                res.add(curr.val);
                stack.pop();
            }
            prev = curr;
        }
        return res;

    }

    public static List<Integer> postorder2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Deque<TreeNode> stack1 = new LinkedList<>();
        Deque<TreeNode> stack2 = new LinkedList<>();

        stack1.push(root);

        while (!stack1.isEmpty()) {
            TreeNode node = stack1.pop();
            stack2.push(node);

            if (node.left != null) {
                stack1.push(node.left);
            }

            if (node.right != null) {
                stack1.push(node.right);
            }
        }

        while (!stack2.isEmpty()) {
            res.add(stack2.pop().val);
        }

        return res;

    }
}


public class Solution {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner sc = new Scanner(new File("src/com/nathan/bittiger/treeTraverse/input"));

        int n = sc.nextInt();

        while (n != -1) {

            TreeNode[] treeNodes = new TreeNode[n];

            for (int i = 0; i < n; i++) {
                treeNodes[i] = new TreeNode(0);
            }

            for (int i = 0; i < n; i++) {
                int val = sc.nextInt();
                int leftNum = sc.nextInt();
                int rightNum = sc.nextInt();
                treeNodes[i].val = val;
                if (leftNum != -1) treeNodes[i].left = treeNodes[leftNum];
                if (rightNum != -1) treeNodes[i].right = treeNodes[rightNum];
            }
            System.out.println("preorder: " + Traverse.preorder(treeNodes[0]));
            System.out.println("inorder: " + Traverse.inorder(treeNodes[0]));
            System.out.println("postorder1: " + Traverse.postorder1(treeNodes[0]));
            System.out.println("postorder2: " + Traverse.postorder2(treeNodes[0]));

            System.out.println("bittiger's way");
            System.out.println("preorder: " + Traverse.traverseByType(treeNodes[0], 0));
            System.out.println("inorder: " + Traverse.traverseByType(treeNodes[0], 1));
            System.out.println("postorder1: " + Traverse.traverseByType(treeNodes[0], 2));

            n = sc.nextInt();
        }




        sc.close();


    }
}

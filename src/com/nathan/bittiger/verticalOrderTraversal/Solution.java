package com.nathan.bittiger.verticalOrderTraversal;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Created by Nathan on 9/17/2016.
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

class Traverse {

    class NodeWithVLevel {
        TreeNode node;
        int verticalLevel;
        public NodeWithVLevel(TreeNode node, int verticalLevel) {
            this.node = node;
            this.verticalLevel = verticalLevel;
        }
    }

    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        if (root == null) return res;

        Queue<NodeWithVLevel> queue = new LinkedList<>();
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        queue.offer(new NodeWithVLevel(root, 0));
        int left = 0, right = 0;

        while (!queue.isEmpty()) {
            NodeWithVLevel nodeWithVLevel = queue.poll();
            TreeNode node = nodeWithVLevel.node;
            int level = nodeWithVLevel.verticalLevel;

            if (!map.containsKey(level)) {
                List<Integer> list = new ArrayList<>();
                list.add(node.val);
                map.put(level, list);
            } else {
                map.get(level).add(node.val);
            }



            if (node.left != null) {
                queue.offer(new NodeWithVLevel(node.left, level- 1));
                left = Math.min(left, level - 1);
            }
            if (node.right != null) {
                queue.offer(new NodeWithVLevel(node.right, level + 1));
                right = Math.max(right, level + 1);
            }
        }

        for (int i = left; i <= right; i++) {
            res.add(map.get(i));
        }

        return res;

    }
}


public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("src/com/nathan/bittiger/verticalOrderTraversal/input"));

        int n = sc.nextInt();

        while (n != -1) {

            System.out.println(n);
            TreeNode[] nodes = new TreeNode[n];
            for (int i = 0; i < n; i++) {
                nodes[i] = new TreeNode(0);
            }

            for (int i = 0; i < n; i++) {

                TreeNode curr = nodes[i];
                int m = sc.nextInt();
                curr.val = m;
                int left = sc.nextInt();
                if (left != -1) curr.left = nodes[left];
                int right = sc.nextInt();
                if (right != -1) curr.right = nodes[right];


            }
            System.out.println("hah");
            Traverse traverse = new Traverse();
            List<List<Integer>> result = traverse.verticalOrder(nodes[0]);

            System.out.println(result);

            n = sc.nextInt();

        }
        sc.close();


    }
}

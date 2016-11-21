package com.nathan.amazon;

import java.util.ArrayList;

/**
 * Created by Nathan on 11/21/16.
 */

class Node {
    int val;
    ArrayList<Node> children;

    public Node(int val) {
        this.val = val;
        this.children = new ArrayList<>();
    }
}


class SumCount {
    int sum;
    int count;

    public SumCount(int sum, int count) {
        this.sum = sum;
        this.count = count;
    }
}

public class Company_Tree {

    public static void main(String[] args) {
        Node root = new Node(1);
        Node l21 = new Node(2);
        Node l22 = new Node(3);
        Node l23 = new Node(4);
        Node l31 = new Node(5);
        Node l32 = new Node(5);
        Node l33 = new Node(5);
        Node l34 = new Node(5);
        Node l35 = new Node(5);
        Node l36 = new Node(5);

        l21.children.add(l31);
        l21.children.add(l32);

        l22.children.add(l33);
        l22.children.add(l34);

        l23.children.add(l35);
        l23.children.add(l36);

        root.children.add(l21);
        root.children.add(l22);
        root.children.add(l23);

        Node res = getHighAve(root);
        System.out.println(res.val + " " + highAve);
    }

    private static Node highAveNode;
    private static double highAve;

    public static Node getHighAve(Node root) {
        if (root == null) return null;

        //initialize very important
        highAveNode = null;
        highAve = Double.MAX_VALUE;

        helper(root);
        return highAveNode;

    }

    private static SumCount helper(Node root) {
        //leaf
        if (root == null || root.children.size() == 0) {
            return new SumCount(root.val, 1); // if root in getHighAve is a leaf, highAveNode won't be ovverride
        }

        int sum = root.val;
        int count = 1;
        for (Node child : root.children) {
            SumCount sc = helper(child);
            sum += sc.sum;
            count += sc.count;
        }

        if (highAve < (double) sum / count) {
            highAve = (double) sum / count;
            highAveNode = root;
        }

        return new SumCount(sum, count);

    }
}

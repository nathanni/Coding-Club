package com.nathan.bittiger.lca;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Nathan on 9/15/16.
 */

class Node {
    int id;
    Node left;
    Node right;
    Node (int id) {
        this.id = id;
        this.left = null;
        this.right = null;
    }
}

class Finder {
    Node findFromRoot(Node a, Node b, Node root) {

        //ending case
        if (root == null || root == a || root == b) {
            return root;
        }


        Node left = findFromRoot(a, b, root.left);
        Node right = findFromRoot(a, b, root.right);
        if (left != null && right != null) {
            return root;
        }

        if (left != null) return left;
        return right;

//        if (left != null) {
//            return left;
//        }
//
//        if (right != null) {
//            return right;
//        }
//
//        return null;
    }
}

public class Solution {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("src/com/nathan/bittiger/lca/input"));
        int n = sc.nextInt();

        Finder finder = new Finder();

        while (n != -1) {
            Node[] tree = new Node[n];

            for (int i = 0; i < n; i++) {
                tree[i] = new Node(i);
            }

            for (int i = 0; i < n; i++) {
                int leftId = sc.nextInt();
                if (leftId != -1) tree[i].left = tree[leftId];
                int rightId = sc.nextInt();
                if (rightId != -1) tree[i].right = tree[rightId];
            }

            int m = sc.nextInt();

            while (m-- != 0) {
                System.out.println(finder.findFromRoot(tree[sc.nextInt()], tree[sc.nextInt()], tree[0]).id);
            }

            n = sc.nextInt();

        }
        sc.close();
    }
}

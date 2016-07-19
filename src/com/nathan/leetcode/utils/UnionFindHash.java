package com.nathan.leetcode.utils;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by Nathan on 7/19/16.
 */
public class UnionFindHash {

    private HashMap<Integer, Integer> parent;
    private int count;

    public UnionFindHash(HashSet<Integer> set) {

        parent = new HashMap<>();

        for (Integer num : set) {
            parent.put(num, num);
            count++;
        }

    }

    public int find(int p) {
        int root = p;
        while (root != parent.get(root)) {
            root = parent.get(root);
        }

        while (p != root) {
            int newP = parent.get(p);
            parent.put(p, root);
            p = newP;
        }

        return root;
    }

    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    public void union(int p, int q) {
        int rootP = parent.get(p);
        int rootQ = parent.get(q);

        if (rootP == rootQ) return;

        parent.put(rootP, rootQ);
        count--;
    }

    public int count() {
        return this.count;
    }

}

package com.nathan.leetcode.utils;

/**
 * Created by Nathan on 7/19/2016.
 */
public class UnionFind {

    private int[] parent;
    private int[] size;

    private int count;

    public UnionFind(int n) {
        count = n;
        parent = new int[n];
        size = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int count() {
        return this.count;
    }

    public int find(int p) {
        validate(p);
        int root = p;
        while (root != parent[root]) {
            root = parent[root];
        }

        while (p != root) {
            int newP = parent[p];
            parent[p] = root;
            p = newP;
        }
        return root;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);

        if (rootP == rootQ) return;

        if (size[rootP] < size[rootQ]) {
            parent[rootP] = rootQ;
            size[rootQ] += size[rootP];
        } else {
            parent[rootQ] = rootP;
            size[rootP] += size[rootQ];
        }

        count--;
    }

    public void validate(int p) {
        int n = parent.length;
        if(p < 0 || p >= n) {
            throw new IndexOutOfBoundsException("p is out of range");
        }
    }
}

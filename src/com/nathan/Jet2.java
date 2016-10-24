package com.nathan;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by nni on 10/24/2016.
 */
public class Jet2 {

    public static void main(String[] args) {
        Jet2 jet2 = new Jet2();
        int[][] matrix = {{1,0,0,0,1,0},{1,0,0,0,1,0},{1,1,1,1,0,1},{1,1,1,1,0,1},{1,1,1,1,1,1},{0,0,0,1,1,1},{0,0,0,1,1,0}};
        List<int[]> res = jet2.findRectangle(matrix);
        for (int[] arr: res) {
            for (int i: arr) {
                System.out.print(i + ",");
            }
            System.out.println();
        }
    }


    class UnionFind {
        int[] parent;
        int[] size;

        public UnionFind(int len) {
            parent = new int[len];
            size = new int[len];

        }

        public int find(int p) {
            int root = p;
            while (root != parent[root]) {
                parent[root] = parent[parent[root]];
                root = parent[root];
            }
            return root;
        }

        public boolean connected(int p, int q) {
            return find(p) == find(q);
        }

        public void add(int index) {
            parent[index] = index;
            size[index] = 1;

        }


        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) return;

            if (size[rootP] < size[rootQ]) {
                parent[rootP] = parent[rootQ];
                size[rootQ] += size[rootP];

            } else {
                parent[rootQ] = parent[rootP];
                size[rootP] += size[rootQ];
            }
        }



    }




    public List<int[]> findRectangle(int[][] matrix) {

        List<int[]> res = new ArrayList<>();

        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dirs = {{-1, 0}, {0, -1}};
        Queue<int[]> queue= new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                        if ((i - 1 < 0 || matrix[i - 1][j] != 0) && (j - 1 < 0 || matrix[i][j - 1] != 0)) {
                            //topleft
                            queue.offer(new int[]{i, j});
                        }

                        if ((i + 1 >= m || matrix[i + 1][j] != 0) && (j + 1 >= n || matrix[i][j + 1] != 0)) {
                            //bottomright
                            int[] first = queue.poll();
                            res.add(new int[]{first[0],first[1], i, j});
                        }

                }
            }
        }

        return res;

//        UnionFind uf = new UnionFind(m * n + 1);
//        HashMap<Integer, LinkedList<Integer>> map = new HashMap<>();
//        int[][] dirs = {{-1, 0}, {0, -1}};
//
//        boolean topleft = true;
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                if (matrix[i][j] == 0) {
//                    uf.add(i * n + j + 1);
//                    for (int[] dir: dirs) {
//                        int x = i + dir[0];
//                        int y = j + dir[1];
//                        if (x >= 0 && y >= 0 && matrix[x][y] == 0) {
//                            uf.union(i * n + j + 1, x * n + y + 1);
//                            topleft = false;
//                        }
//                    }
//                    if (topleft) {
//                        LinkedList<Integer> list = new LinkedList<>();
//                        list.add()
//                        map.put(i * n + j, )
//                    }
//                }
//            }
//        }
//
//
//
//        return res;
    }
}

package com.nathan.amazon;

import java.util.*;

/**
 * Created by Nathan on 11/21/16.
 */
class Connection {
    String node1;
    String node2;
    int cost;

    public Connection(String a, String b, int c) {
        node1 = a;
        node2 = b;
        cost = c;
    }
}

class UnionFind {
    HashMap<String, String> parent;
    int count = 0;

    public UnionFind(HashSet<String> set) {

        parent = new HashMap<>();
        for (String s : set) {
            parent.put(s, s);
            count++;
        }
    }

    public String find(String p) {
        String root = p;
        while (!root.equals(parent.get(root))) {
            parent.put(root, parent.get(parent.get(root)));
            root = parent.get(root);
        }
        return root;
    }

    public boolean isConnected(String p, String q) {
        return find(p).equals(find(q));
    }

    public void union(String p, String q) {
        String rootP = find(p);
        String rootQ = find(q);
        if (rootP.equals(rootQ)) return;
        parent.put(rootP, rootQ);
        count--;
    }
}

public class City_Connections_MST {
    public static ArrayList<Connection> getLowCost(ArrayList<Connection> connections) {
        if (connections == null || connections.size() == 0) return new ArrayList<>();

        Collections.sort(connections, new Comparator<Connection>() {
            @Override
            public int compare(Connection o1, Connection o2) {
                return o1.cost - o2.cost;
            }
        });

        ArrayList<Connection> res = new ArrayList<>();
        HashSet<String> set = new HashSet<>();

        for (Connection connection : connections) {
            String n1 = connection.node1;
            String n2 = connection.node2;
            set.add(n1);
            set.add(n2);
        }

        UnionFind uf = new UnionFind(set);

        for (Connection connection : connections) {
            String n1 = connection.node1;
            String n2 = connection.node2;
            if (!uf.isConnected(n1, n2)) {
                uf.union(n1, n2);
                res.add(connection);
            }
        }

        if (set.size() - 1 != res.size()) return new ArrayList<>();

        Collections.sort(res, new Comparator<Connection>() {
            @Override
            public int compare(Connection o1, Connection o2) {
                if (o1.node1.equals(o2.node1)) {
                    return o1.node2.compareTo(o2.node2);
                }
                return o1.node1.compareTo(o2.node1);
            }
        });

        return res;

    }

    public static void main(String[] args) {
        ArrayList<Connection> connections = new ArrayList<>();
        //这里还是一个苯环形状，有化学出身的看到这里可以鼓掌了
        connections.add(new Connection("A", "B", 6));
        connections.add(new Connection("B", "C", 4));
        connections.add(new Connection("C", "D", 5));
        connections.add(new Connection("D", "E", 8));
        connections.add(new Connection("E", "F", 1));
        connections.add(new Connection("B", "F", 10));
        connections.add(new Connection("E", "C", 9));
        connections.add(new Connection("F", "C", 7));
        connections.add(new Connection("B", "E", 3));
        connections.add(new Connection("A", "F", 1));

        ArrayList<Connection> res = getLowCost(connections);
        for (Connection c : res) {
            System.out.println(c.node1 + " -> " + c.node2 + " 需要花费大洋 : " + c.cost);
        }
    }
}

package com.nathan.amazon;

import java.util.*;

/**
 * Created by nni on 11/21/2016.
 */
class Order {
    String orderName;

    public Order(String string) {
        this.orderName = string;
    }
}

class OrderDependency {
    Order cur;
    Order pre;

    public OrderDependency(Order pre, Order cur) {
        this.pre = pre;
        this.cur = cur;
    }
}

public class Order_Dependency {
    public static List<Order> solution(List<OrderDependency> orderDependencies) {
        if (orderDependencies == null || orderDependencies.size() == 0) return new ArrayList<>();


        List<Order> res = new ArrayList<>();

        Map<String, Integer> indegree = new HashMap<>();
        Map<String, List<String>> orders = new HashMap<>();

        Map<String, Order> nameToOrder = new HashMap<>();

        Set<String> set = new HashSet<>();

        for (OrderDependency orderDependency : orderDependencies) {
            String pre = orderDependency.pre.orderName;
            String cur = orderDependency.cur.orderName;
            set.add(pre);
            set.add(cur);

            if (!nameToOrder.containsKey(pre)) {
                nameToOrder.put(pre, orderDependency.pre);
            }

            if (!nameToOrder.containsKey(cur)) {
                nameToOrder.put(cur, orderDependency.cur);
            }


            if (!orders.containsKey(pre)) {
                List<String> list = new ArrayList<>();
                list.add(cur);
                orders.put(pre, list);
            } else {
                orders.get(pre).add(cur);
            }

            if (!orders.containsKey(cur)) {
                List<String> list = new ArrayList<>();
                orders.put(cur, list);
            }

            if (!indegree.containsKey(pre)) {
                indegree.put(pre, 0);
            }

            if (!indegree.containsKey(cur)) {
                indegree.put(cur, 1);
            } else {
                indegree.put(cur, indegree.get(cur) + 1);
            }


        }

        Queue<String> queue = new LinkedList<>();

        for (String key : indegree.keySet()) {
            if (indegree.get(key) == 0) {
                queue.offer(key);
            }
        }

        while (!queue.isEmpty()) {
            String currOrder = queue.poll();
            res.add(nameToOrder.get(currOrder));

            for (String nextOrder : orders.get(currOrder)) {

                indegree.put(nextOrder, indegree.get(nextOrder) - 1);
                if (indegree.get(nextOrder) == 0) {
                    queue.offer(nextOrder);
                }
            }
        }

        if (set.size() != res.size()) return new ArrayList<>();

        return res;


    }

    public static void main(String[] args) {
        Order o1 = new Order("泡面");
        Order o2 = new Order("泡面");
        Order o3 = new Order("SF");
        Order o4 = new Order("租车");
        Order o5 = new Order("SF");
        Order o6 = new Order("泡面");
        Order o7 = new Order("租车");
        Order o8 = new Order("SF");
        Order o9 = new Order("爽(每个行为只输出了一次对吧)");
        OrderDependency od1 = new OrderDependency(o1, o3);
        OrderDependency od2 = new OrderDependency(o2, o7);
        OrderDependency od3 = new OrderDependency(o3, o9);
        OrderDependency od4 = new OrderDependency(o4, o3);
        OrderDependency od5 = new OrderDependency(o6, o9);
        OrderDependency od6 = new OrderDependency(o8, o9);
        OrderDependency od7 = new OrderDependency(o2, o5);

        List<OrderDependency> list = new ArrayList<>();
        list.add(od1);
        list.add(od2);
        list.add(od3);
        list.add(od4);
        list.add(od5);
        list.add(od6);
        list.add(od7);
        //最后输出就是这种形式
        List<Order> res = solution(list);
        for (int i = 0; i < res.size(); i++) {
            System.out.print(res.get(i).orderName);
            if (i + 1 < res.size()) {
                System.out.print(" -> ");
            }
        }
    }

}

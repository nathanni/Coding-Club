package com.nathan;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by nni on 10/19/2016.
 */
class Dog {
    String name;
    int id;
    Dog(String name, int id) {
        this.name = name;
        this.id = id;
    }
    Dog() {

    }
    public void bite() {}

}

public class Test2 {
    public static void main(String[] args) {
        Queue<Dog> queue = new LinkedList<>();

        queue.offer(new Dog() {
            public void bite() {
                 id = 333;
            }
        });

        queue.peek().bite();
        System.out.println(queue.peek().id);
    }
}

package com.nathan.singleton;

/**
 * Created by nni on 12/6/2016.
 */
public class Singleton1_regular {

    private static Singleton1_regular instance;
    private Singleton1_regular(){}

    public static Singleton1_regular getInstance() {
        if (instance == null) {
            instance = new Singleton1_regular();
        }
        return instance;
    }
}

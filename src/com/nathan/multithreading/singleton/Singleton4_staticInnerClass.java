package com.nathan.multithreading.singleton;

/**
 * Created by nni on 12/6/2016.
 */
public class Singleton4_staticInnerClass {

    private Singleton4_staticInnerClass(){}

    private static class SingletonHolde {
        private static final Singleton4_staticInnerClass instance = new Singleton4_staticInnerClass();
    }
    public final static Singleton4_staticInnerClass getInstance() {
        return SingletonHolde.instance;
    }


}

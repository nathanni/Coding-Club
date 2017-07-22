package com.nathan.singleton;

/**
 * Created by Nathan on 6/27/17.
 */
public class StaticInnerClass {
    private StaticInnerClass(){}
    private static class Inner {
        private final static StaticInnerClass instance = new StaticInnerClass();
    }

    public static StaticInnerClass getInstance() {
        return StaticInnerClass.Inner.instance;
    }


}

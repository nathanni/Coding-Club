package com.nathan.singleton;

/**
 * Created by Nathan on 6/27/17.
 */

/*
* Not lazy load
* */
public class StaticFinalField {
    private static final StaticFinalField instance = new StaticFinalField();
    private StaticFinalField() {}

    public static StaticFinalField getInstance() {
        return instance;
    }
}

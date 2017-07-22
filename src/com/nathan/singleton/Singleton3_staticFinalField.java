package com.nathan.singleton;

/**
 * Created by nni on 12/6/2016.
 */
public class Singleton3_staticFinalField {
    private final static Singleton3_staticFinalField instance = new Singleton3_staticFinalField();
    private Singleton3_staticFinalField(){};
    public static Singleton3_staticFinalField getInstance() {
        return instance;
    }

}

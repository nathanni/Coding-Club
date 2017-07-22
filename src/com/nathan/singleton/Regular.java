package com.nathan.singleton;

/**
 * Created by Nathan on 6/27/17.
 */

/*
* Race condition, duplicate instance
*
* */
public class Regular {

    private Regular() {}
    private static Regular instance;

    public static Regular getInstance() {
        if (instance == null) {
            instance = new Regular();
        }
        return instance;
    }

}

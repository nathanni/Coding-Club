package com.nathan.singleton;

/**
 * Created by Nathan on 6/27/17.
 */

/*
* In JAVA, new Object is not an atomic operation.
* The following operations possible running in 1 - 2 - 3 or 1 - 3 - 2
* Because JAVA using out-of-order execution to avoid pipeline hazard
* So we need to use volatile to avoid this.
* 1.    Assign space for Object
* 2.    Run Object's constructor to do some initialize work
* 3.    Combine local variable to this Object
*
* */

public class DoubleCheckedLock {
    private static volatile DoubleCheckedLock instance;
    private DoubleCheckedLock(){}

    public static DoubleCheckedLock getInstance() {
        if (instance == null) {
            synchronized (DoubleCheckedLock.class) {
                if (instance == null) {
                    instance = new DoubleCheckedLock();
                }
            }
        }

        return instance;
    }
}

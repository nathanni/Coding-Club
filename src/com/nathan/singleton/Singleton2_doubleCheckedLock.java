package com.nathan.singleton;

/**
 * Created by nni on 12/6/2016.
 */
public class Singleton2_doubleCheckedLock {
    private static volatile Singleton2_doubleCheckedLock instance;
    private Singleton2_doubleCheckedLock() {

    }
    public static Singleton2_doubleCheckedLock getInstance() {
        if (instance == null) {
            synchronized (Singleton2_doubleCheckedLock.class) {
                if (instance == null) {
                    instance = new Singleton2_doubleCheckedLock();
                }
            }
        }
        return instance;
    }

}

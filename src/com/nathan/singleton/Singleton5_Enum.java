package com.nathan.singleton;

/**
 * Created by nni on 12/6/2016.
 */
public class Singleton5_Enum {

    public enum EasyInstance {
        INSTANCE;
        private EasyInstance() {
            System.out.println("Here");
        }
    }

    public static void main(String[] args) {
        System.out.println(EasyInstance.INSTANCE);
    }
}

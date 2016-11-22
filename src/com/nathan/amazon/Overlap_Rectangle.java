package com.nathan.amazon;

/**
 * Created by nni on 11/22/2016.
 */

class RecNode {
    double x;
    double y;
    public RecNode(double x, double y) {
        this.x = x;
        this.y = y;
    }
}


public class Overlap_Rectangle {

    public static boolean check(RecNode topLeftA, RecNode topLeftB, RecNode bottomRightA, RecNode bottomRightB) {

        if (topLeftA.x >= bottomRightB.x || bottomRightA.x <= topLeftB.x
                || topLeftA.y <= bottomRightB.y || bottomRightA.y >= topLeftB.y){
            return false;
        }
        return true;

    }
}

package com.nathan.amazon;

/**
 * Created by nni on 11/22/2016.
 */
public class Gray_Code {

    public static int grayCheck(byte t1, byte t2) {
        byte rst = (byte) (t1 ^ t2);


        //检测bit里是否只有1个很巧妙的方法
        for (int i = 0; i < 8; i++) {
            int tmp = (1 << i);
            if (tmp == rst) {
                return 1;
            }
        }
        return 0;

    }
}

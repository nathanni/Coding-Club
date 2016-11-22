package com.nathan.amazon;

/**
 * Created by nni on 11/22/2016.
 */
public class Rotate_String {

    public static int isRotation(String word1, String word2) {
        if (word1 == null || word2 == null || word1.length() == 0 || word2.length() == 0 || word1.length() != word2.length()) return -1;

        String str = word1 + word1;

        return str.indexOf(word2) != -1 ? 1 : -1;
    }
}

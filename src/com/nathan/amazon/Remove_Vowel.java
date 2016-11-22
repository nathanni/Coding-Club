package com.nathan.amazon;

/**
 * Created by nni on 11/22/2016.
 */
public class Remove_Vowel {


    public static void main(String[] args) {
        String s = "abdhfgebsa";
        System.out.println(solution(s));
        String str = new String("abdhfgebsa");
        StringBuffer sb = new StringBuffer();
        String v = "aeiouAEIOU";
        for(int i = 0; i < str.length(); i++){
            if(v.indexOf(str.charAt(i)) > -1) continue;
            sb.append(str.charAt(i));
        }
        str = sb.toString();
        System.out.println(str);
    }

    public static String solution(String s) {
        String v = "aeiouAEIOU";

        StringBuilder sb = new StringBuilder();

        for (char c: s.toCharArray()) {
            if (v.indexOf(c) != -1) continue;
            sb.append(c);
        }
        return sb.toString();

    }
}

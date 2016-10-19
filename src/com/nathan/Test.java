package com.nathan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by nni on 10/19/2016.
 */
public class Test {
    public int[] intersect(int[] nums1, int[] nums2) {

        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) return new int[]{};

        List<Integer> list = new ArrayList<>();
        int[] orgSmall = nums1.length < nums2.length ? nums1: nums2;
        int[] big = nums1.length < nums2.length ? nums2: nums1;


        Arrays.sort(orgSmall);
        List<Integer> small = new ArrayList<>();
        for (int i : orgSmall) {
            small.add(i);
        }


        for (int i: big) {
            int pos = search(small, i);
            if (pos != -1) {
                list.add(small.get(pos));
                small.remove(pos);
            }
        }

        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }

        return res;


    }

    public int search(List<Integer> small, int target) {

        if (small == null || small.size() == 0) return -1;

        int start = 0, end = small.size() - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (small.get(mid) >= target) {
                end = mid;
            } else {
                start = mid;
            }
        }

        if (small.get(start) == target) return start;
        else if (small.get(end) == target) return end;
        else return - 1;

    }

    public static void main(String[] args) {

        System.out.println(canReach(1, 21, 245, 443));
    }

    static HashMap<String, String> cache = new HashMap<String, String>();

    static String canReach(int a, int b , int c, int d) {
        if (a > c || b > d) return "No";
        if (a == c && b == d) return "Yes";
        String key = a + "," + b + "," + c + "," + d + ",";
        if (cache.containsKey(key)) {
            return cache.get(key);
        }
        String res;
        if (canReach(a + b, b, c, d).equals("Yes") || canReach(a, a + b, c, d).equals("Yes"))  {
            res =  "Yes";
        }
        else {
            res = "No";
        }
        cache.put(key, res);
        return res;
    }

    static String canReach2(int a, int b , int c, int d) {
        if (a > c || b > d) return "No";
        boolean[][] f = new boolean[c + 1][d + 1];
        f[a][b] = true;
        for (int i = a; i <= c; i += b) {
            for (int j = b; j <= d; j += a) {
                f[i][j] = (i - j >= 0 ? f[i - j][j]: true) ||
                        (j - i >= 0 ? f[i][j - i]: true);
            }
        }
        return f[c][d]? "Yes": "No";
    }
}

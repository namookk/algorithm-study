package com.algorithm.programmers.y2021.m9.d11;

import java.util.Arrays;

public class Solution2 {
    public static void main(String[] args) {
        String[] strings = {"sun", "bed", "car"};
        int n = 1;

        solution(strings, n);
    }
    public static String[] solution(String[] strings, int n) {

        Arrays.sort(strings, (a,b) -> {
            String aa = Character.toString(a.charAt(n));
            String bb = Character.toString(b.charAt(n));
            if(!aa.equals(bb)) {
                return aa.compareTo(bb);
            }else{
                return a.compareTo(b);
            }
        });


        return strings;
    }
}

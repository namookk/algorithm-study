package com.algorithm.programmers.y2021.m9.d11;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        String s = "Zbcdefg";
        System.out.println(solution(s));
    }
    public static String solution(String s) {
        String[] sArr = s.split("");
        Arrays.sort(sArr, (a,b) -> {
            return b.compareTo(a);
        });
        return String.join("", sArr);
    }
}

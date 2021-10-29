package com.algorithm.programmers.y2021.m10.d29;

public class Solution {
    public static void main(String[] args) {
        String s = "1 2 3 4";
        System.out.println(solution(s));
    }
    public static String solution(String s) {
        String[] arr = s.split(" ");
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(String str : arr) {
            int num = Integer.parseInt(str);
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        return min + " " + max;
    }
}

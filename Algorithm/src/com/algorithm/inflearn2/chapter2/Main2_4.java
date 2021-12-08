package com.algorithm.inflearn2.chapter2;

import java.util.Arrays;

public class Main2_4 {
    public static void main(String[] args) {
        int[][] intervals = {{5,10},{16,20},{0,30}};
        int[][] intervals2 = {{6,10},{1,3}};

        System.out.println(solve(intervals));
        System.out.println(solve(intervals2));
    }

    public static boolean solve(int[][] intervals){
        Arrays.sort(intervals, (a,b) -> {
            return a[0] - b[0];
        });
        int end = intervals[0][1];
        for(int i = 1; i < intervals.length; i++) {
            if(intervals[i][0] < end) return false;
            else{
                end = intervals[i][1];
            }
        }

        return true;
    }
}

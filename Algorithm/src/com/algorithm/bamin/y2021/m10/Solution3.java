package com.algorithm.bamin.y2021.m10;

import java.util.Arrays;
import java.util.Comparator;

public class Solution3 {
    public static void main(String[] args) {
        int[][] moneys = {{100, 3}, {200, 1}, {50, 2}};
        System.out.println(solution(moneys));
    }

    public static int solution(int[][] moneys) {
        int answer = 0;
        Arrays.sort(moneys, (a,b) -> {
            return b[0] - a[0];
        });
        int c1 = 0;
        int c2 = 0;

        for(int i = 0; i < moneys.length; i++) {
            for(int j = 0; j < moneys[i][1]; j++) {
                if(c1 > c2) {
                    c2 += moneys[i][0];
                }else{
                    c1 += moneys[i][0];
                }
            }
        }

        return Math.abs(c2-c1);
    }
}

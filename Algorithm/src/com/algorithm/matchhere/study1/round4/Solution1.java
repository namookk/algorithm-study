package com.algorithm.matchhere.study1.round4;

import java.util.Scanner;

public class Solution1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            int num = sc.nextInt();
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        System.out.println(min +" "+ max);
    }
}

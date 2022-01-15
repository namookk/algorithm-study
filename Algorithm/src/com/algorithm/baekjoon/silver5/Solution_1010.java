package com.algorithm.baekjoon.silver5;

import java.util.Scanner;

public class Solution_1010 {
    static int[][] dp = new int[30][30];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int left = sc.nextInt();
            int right = sc.nextInt();
            System.out.println(combination(right, left));
        }
    }

    private static int combination(int right, int left){
        System.out.println(dp[right][left]);
        if(dp[right][left] > 0){
            return dp[right][left];
        }

        if(right == left || left == 0){
            return dp[right][left] = 1;
        }

        dp[right][left] = combination(right -1, left - 1) + combination(right - 1, left);
        return dp[right][left];
    }
}

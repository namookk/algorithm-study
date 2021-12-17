package com.algorithm.inflearn2.chapter8;

import java.util.Arrays;

public class Main8_1 {
    public static void main(String[] args) {
        int m = 3;
        int n = 2;
        System.out.println(solve(m, n));
    }
    public static int solve(int m, int n)  {
        int[][] dy = new int[m+1][n+1];
        int[][] dirs = {{0, -1}, {-1, 0}};
        dy[1][1] = 1;

        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if(i == 1 && j == 1) continue;
                dy[i][j] = dy[i-1][j] + dy[i][j-1];
            }
        }

        return dy[m][n];
    }
}

package com.algorithm.inflearn2.chapter8;

import java.util.Arrays;

public class Main8_1 {
    public static void main(String[] args) {
        int m = 3;
        int n = 2;
        System.out.println(solve(m, n));
    }
    public static int solve(int m, int n)  {
        int[][] dy = new int[m][n];
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                dy[i][j] = Integer.MAX_VALUE;
            }
        }
        dy[0][0] = 0;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(i == m && j == m) continue;
                for(int[] dir : dirs) {
                    int x = i + dir[0];
                    int y = j + dir[1];
                    if(x < 0 || y < 0 || x == m || y == n || dy[x][y] == Integer.MAX_VALUE) continue;
                    dy[i][j] = Math.min(dy[i][j], dy[x][y] + 1);
                }
            }
        }

        return dy[m-1][n-1];
    }
}

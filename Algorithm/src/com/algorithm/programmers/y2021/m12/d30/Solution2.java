package com.algorithm.programmers.y2021.m12.d30;

public class Solution2 {
    static final int MOD = 20170805;
    public static void main(String[] args) {
        int m = 3;
        int n = 3;
        int[][] city_map = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        System.out.println(solution(m, n, city_map));
    }

    public static int solution(int m, int n, int[][] city_map){
        int[][] dy = new int[m][n];
        for(int i = 0; i < m; i++){
            dy[i][0] = 1;
        }
        for(int j = 0; j < n; j++){
            dy[0][j] = 1;
        }
        for(int i = 0; i < m;i++){
            if(city_map[i][0] == 1){
                for(int j = i; j < m; j++){
                    dy[j][0] = 0;
                }
                break;
            }
        }
        for(int i = 0; i < n;i++){
            if(city_map[0][i] == 1){
                for(int j = i; j < n; j++){
                    dy[0][i] = 0;
                }
                break;
            }
        }

        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if(city_map[i][j] != 1){
                    int up = city_map[i-1][j] == 2 ? dy[i-1][j] - 1 : dy[i-1][j];
                    int left = city_map[i][j-1] == 2 ? dy[i][j-1] - 1 : dy[i][j-1];
                    dy[i][j] = (up + left) % MOD;
                }
            }
        }

        return dy[m-1][n-1];
    }
}

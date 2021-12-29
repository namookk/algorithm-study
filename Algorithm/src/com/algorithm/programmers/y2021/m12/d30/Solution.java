package com.algorithm.programmers.y2021.m12.d30;

import java.awt.*;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {
        int m = 3;
        int n = 2;
        int[][] puddles = {{2,2}};
        System.out.println(solution(m, n, puddles));
    }
    public static int solution(int m, int n, int[][] puddles) {
        int[][] dy = new int[n][m];
        int[][] puddlesArr = new int[n][m];
        for(int i = 0; i < n; i++){
            dy[i][0] = 1;
        }
        for(int i = 0; i < m; i++){
            dy[0][i] = 1;
        }
        for(int[] puddle : puddles){
            puddlesArr[puddle[1] - 1][puddle[0] - 1] = 1;
            if(puddle[1] - 1  == 0){
                for(int i = puddle[0] - 1 ; i < m; i++){
                    dy[0][i] = 0;
                }
            }
            if(puddle[0] - 1 == 0){
                for(int i = puddle[1] - 1 ; i < n; i++){
                    dy[i][0] = 0;
                }
            }
        }

        for(int i = 1; i < n; i++){
            for(int j = 1; j < m; j++){
                if(puddlesArr[i][j] == 0){
                    dy[i][j] = (dy[i-1][j] + dy[i][j-1]) % 1000000007;
                }
            }
        }

        return dy[n-1][m-1];
    }
}



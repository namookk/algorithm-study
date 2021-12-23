package com.algorithm.programmers.y2021.m12.d23;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    static int[][] dirs = {{1,0}, {-1, 0}, {0, 1}, {0, -1}}; // R, L, D, U
    static int[][][] ch;
    static int startI, startJ, startK;
    static List<Integer> answer = new ArrayList<>();
    static boolean flag = false;
    public static void main(String[] args) {
        String[] grid = {"R", "R"};

        for(Integer i : solution(grid)) System.out.print(i + " ");
    }

    public static int[] solution(String[] grid){
        char[][] grids = new char[grid.length][grid[0].length()];
        ch = new int[grid.length][grid[0].length()][4];
        for(int i = 0; i < grid.length; i++) {
            grids[i] = grid[i].toCharArray();
        }

        for(int i = 0; i < ch.length; i++) {
            for(int j = 0; j < ch[i].length; j++) {
                for(int k = 0; k < ch[i][j].length; k++) {
                    if(ch[i][j][k] == 0) {
                        startI = i;
                        startJ = j;
                        startK = k;
                        dfs(grids, i, j, k, 0);
                    }
                }
            }
        }

        return answer.stream().mapToInt(i->i).toArray();
    }

    public static void dfs(char[][] grids, int i, int j, int k, int sum) {
        if(i == startI && j == startJ && k == startK && ch[i][j][k] == 1) answer.add(sum);
        else if(ch[i][j][k] == 1) return;
        else {
            ch[i][j][k] = 1;
            switch (k) {
                case 0: // R
                    j = j < grids[0].length - 1 ? j + 1 : 0;
                    break;
                case 1: // L
                    j = j > 0 ? j - 1 : grids[0].length - 1;
                    break;
                case 2: // D
                    i = i < grids.length - 1 ? i + 1 : 0;
                    break;
                case 3: // U
                    i = i > 0 ? i - 1 : grids.length - 1;
                    break;
                default:
                    break;
            }

            char next = grids[i][j];
            int new_k = 0;
            switch (next) {
                case 'S': // L
                    new_k = k;
                    break;
                case 'L': // D
                    if (k == 0) {
                        new_k = 3;
                    } else if (k == 1) {
                        new_k = 2;
                    } else if (k == 2) {
                        new_k = 0;
                    } else {
                        new_k = 1;
                    }
                    break;
                case 'R': // U
                    if (k == 0) {
                        new_k = 2;
                    } else if (k == 1) {
                        new_k = 3;
                    } else if (k == 2) {
                        new_k = 1;
                    } else {
                        new_k = 0;
                    }
                    break;
                default:
                    break;
            }

            dfs(grids, i, j, new_k, sum + 1);
        }
    }

}
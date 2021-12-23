package com.algorithm.programmers.y2021.m12.d23;

import java.util.ArrayList;
import java.util.List;

//https://programmers.co.kr/learn/courses/30/lessons/86052

//정확성  테스트
//    테스트 1 〉	통과 (2.53ms, 78.3MB)
//    테스트 2 〉	통과 (3.02ms, 71.6MB)
//    테스트 3 〉	통과 (2.82ms, 80.2MB)
//    테스트 4 〉	통과 (7.47ms, 82.9MB)
//    테스트 5 〉	통과 (9.40ms, 89.7MB)
//    테스트 6 〉	통과 (11.43ms, 82.8MB)
//    테스트 7 〉	실패 (런타임 에러)
//    테스트 8 〉	통과 (38.45ms, 111MB)
//    테스트 9 〉	통과 (59.74ms, 119MB)
//    테스트 10 〉	통과 (52.75ms, 140MB)
//    테스트 11 〉	통과 (60.95ms, 146MB)

//성공
//정확성  테스트
//    테스트 1 〉	통과 (2.75ms, 76.9MB)
//    테스트 2 〉	통과 (2.75ms, 76.5MB)
//    테스트 3 〉	통과 (3.59ms, 72.7MB)
//    테스트 4 〉	통과 (8.54ms, 77MB)
//    테스트 5 〉	통과 (10.71ms, 87.1MB)
//    테스트 6 〉	통과 (19.09ms, 92.1MB)
//    테스트 7 〉	통과 (57.80ms, 104MB)
//    테스트 8 〉	통과 (47.53ms, 92.6MB)
//    테스트 9 〉	통과 (60.29ms, 123MB)
//    테스트 10 〉	통과 (51.99ms, 122MB)
//    테스트 11 〉	통과 (64.48ms, 147MB)

public class Solution {
    static int[][] dirs = {{1,0}, {-1, 0}, {0, 1}, {0, -1}}; // R, L, D, U
    static int[][][] ch;
    static int startI, startJ, startK;
    static List<Integer> answer = new ArrayList<>();
    static boolean flag = false;
    public static void main(String[] args) {
        String[] grid = {"SL", "LR"};

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
                        doWhile(grids, i, j, k, 0);
                    }
                }
            }
        }
        return answer.stream().mapToInt(i->i).sorted().toArray();
    }

    public static void doWhile(char[][] grids, int i, int j, int k, int sum){
        while(ch[i][j][k] == 0) {
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
            sum += 1;
            k = new_k;
        }
        if(i == startI && j == startJ && k == startK && ch[i][j][k] == 1) answer.add(sum);
    }

    public static void dfs(char[][] grids, int i, int j, int k, int sum) {
        if(i == startI && j == startJ && k == startK && ch[i][j][k] == 1) answer.add(sum);
        else if(ch[i][j][k] == 1){
            return;
        }
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
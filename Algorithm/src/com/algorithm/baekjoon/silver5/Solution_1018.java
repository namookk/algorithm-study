package com.algorithm.baekjoon.silver5;

import java.util.Scanner;

public class Solution_1018 {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       int n = sc.nextInt();
       int m = sc.nextInt();
       sc.nextLine();
       String[][] board = new String[n][m];
       for (int i = 0; i < n ; i++) {
           String boardStr = sc.nextLine();
           board[i] = boardStr.split("");
       }

        System.out.println(solution(n, m, board));
    }

    private static int solution(int n, int m, String[][] board){
        int answer = Integer.MAX_VALUE;
        for (int i = 0; i <= n - 8; i++) {
            for(int j = 0; j <= m - 8; j++){
                answer = Math.min(answer, getMinChange(board, i, j));
            }
        }

        return answer;
    }

    private static int getMinChange(String[][] board, int x, int y){
        int startBcount = 0;
        int startWcount = 0;
        for(int i = x; i < x + 8; i++){
            for(int j = y; j < y + 8; j++){
                if(i % 2 == 0){
                    if(j % 2 == 0){
                        if(board[i][j].equals("W")) startBcount++;
                        else startWcount++;
                    }else{
                        if(board[i][j].equals("B")) startBcount++;
                        else startWcount++;
                    }
                }else{
                    if(j % 2 == 0){
                        if(board[i][j].equals("B")) startBcount++;
                        else startWcount++;
                    }else{
                        if(board[i][j].equals("W")) startBcount++;
                        else startWcount++;
                    }
                }
            }
        }
        return Math.min(startBcount, startWcount);
    }
}

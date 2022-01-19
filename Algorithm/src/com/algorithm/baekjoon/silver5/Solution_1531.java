package com.algorithm.baekjoon.silver5;

import java.util.Scanner;

public class Solution_1531 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int limit = sc.nextInt();
        int[][] board = new int[101][101];

        for(int i = 0; i < n; i++){
            int leftX = sc.nextInt();
            int leftY = sc.nextInt();
            int rightX = sc.nextInt();
            int rightY = sc.nextInt();
            for(int j = leftX; j <= rightX; j++){
                for(int k = leftY; k <= rightY; k++){
                    board[j][k]++;
                }
            }
        }
        int answer = 0;
        for(int[] arr : board){
            for(int num : arr){
                if(num > limit) answer++;
            }
        }
        System.out.println(answer);
    }
}

package com.algorithm.baekjoon.silver5;

import java.util.Scanner;

public class Solution_2508 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while(n > 0){
            int row = sc.nextInt();
            int col = sc.nextInt();
            sc.nextLine();
            char[][] arr = new char[row][col];
            for(int i = 0; i < row; i++){
                String s = sc.nextLine();
                arr[i] = s.toCharArray();
            }
            System.out.println(solution(row, col, arr));
            n--;
        }
    }

    private static int solution(int row, int col, char[][] arr){
        int answer = 0;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(arr[i][j] == 111) {
                    if (i > 0 && i < row - 1 && arr[i-1][j] == 118 && arr[i+1][j] == 94) {
                        answer++;
                    }
                    if(j > 0 && j < col - 1 && arr[i][j-1] == 62 && arr[i][j+1] == 60){
                        answer++;
                    }
                }
            }
        }
        return answer;
    }
}

package com.algorithm.inflearn.chapter2;

import java.util.*;

public class Main2_10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        for(int i = 0 ; i < n; i++) {
            for(int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
            sc.nextLine();
        }
        System.out.println(solution(n, arr));
    }

    public static int solution(int n, int[][] arr) {
        int answer = 0;
        int[][] new_arr = new int[n+2][n+2];
        for(int i = 0; i < new_arr.length; i++) {
            for(int j = 0; j < new_arr[i].length; j++) {
                if( i == 0 || i == new_arr.length - 1 || j == 0 || j == new_arr[i].length - 1) {
                    new_arr[i][j] = 0;
                }else{
                    new_arr[i][j] = arr[i-1][j-1];
                }
            }
        }
        for(int i = 1; i < new_arr.length - 1; i++) {
            for(int j = 1; j < new_arr[i].length - 1; j++) {
                int num = new_arr[i][j];
                if(num > new_arr[i-1][j] && num > new_arr[i+1][j] &&
                        num > new_arr[i][j-1] && num > new_arr[i][j+1] ){
                    answer++;
                }
            }
        }

        return answer;
    }
}
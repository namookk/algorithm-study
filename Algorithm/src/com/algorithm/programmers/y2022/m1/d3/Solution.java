package com.algorithm.programmers.y2022.m1.d3;

public class Solution {
    public static void main(String[] args) {
        int[][] arr1 = {{1, 4}, {3, 2}, {4, 1}};
        int[][] arr2 = {{3, 3}, {3, 3}};


        int[][] arr2_1 = {{2, 3, 2}, {4, 2, 4}, {3, 1, 4}};
        int[][] arr2_2 = {{5, 4, 3}, {2, 4, 1}, {3, 1, 1}};
        for(int[] arr : solution(arr1, arr2)){
            for(int i : arr){
                System.out.print( i + " ");
            }
            System.out.println();
        }
        for(int[] arr : solution(arr2_1, arr2_2)){
            for(int i : arr){
                System.out.print( i + " ");
            }
            System.out.println();
        }
    }

    private static int[][] solution(int[][] arr1, int[][] arr2){
        int[][] answer = new int[arr1.length][arr2[0].length];

        for(int i = 0; i < arr1.length; i++){
            for(int k = 0; k < arr2[0].length; k++){
                int value = 0;
                for(int j = 0; j < arr1[0].length; j++){
                    value += arr1[i][j] * arr2[j][k];
                }
                answer[i][k] = value;
            }
        }

        return answer;
    }
}

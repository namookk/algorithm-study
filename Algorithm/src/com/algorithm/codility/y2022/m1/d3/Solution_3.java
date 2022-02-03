package com.algorithm.codility.y2022.m1.d3;

import java.util.Arrays;

public class Solution_3 {
    public static void main(String[] args) {
        int[] arr = {5, 3, 6, 1, 3};
        int k = 2;
        System.out.println(solution(arr, k));
    }

    private static int solution(int[] A, int K){
        // write your code in Java SE 8
        int len = A.length;
        int answer = Integer.MAX_VALUE;

        for(int i = 0; i < len - K + 1; i++){
            int lt = i;
            int rt = lt + K - 1;
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for(int j = 0; j < len; j++){
                if(j >= lt && j <= rt) continue;
                int num = A[j];
                min = Math.min(num, min);
                max = Math.max(num, max);
            }
            answer = Math.min(max - min, answer);
        }
        return answer;
    }
}

package com.algorithm.swea.y2022.m1.d3;

import java.util.Arrays;
import java.util.Scanner;

public class Solution1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][10];
        for(int i = 0; i < n; i++){
            int[] value = new int[10];
            for(int j = 0; j < 10; j++){
                value[j] = sc.nextInt();
            }
            arr[i] = value;
        }
        int[] result = solution(n, arr);
        for(int i = 0; i < result.length; i++){
            System.out.println("#"+(i+1)+" "+ result[i]);
        }
    }

    private static int[] solution(int n, int[][] arr){
        int[] answer = new int[arr.length];
        int idx = 0;
        for(int[] nums : arr){
            answer[idx++] = Arrays.stream(nums).filter(i -> i%2 == 1).sum();
        }

        return answer;
    }
}

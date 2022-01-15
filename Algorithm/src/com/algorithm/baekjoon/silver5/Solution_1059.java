package com.algorithm.baekjoon.silver5;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_1059 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        int target = sc.nextInt();
        System.out.println(solution(arr, target));
    }
    private static int solution(int[] arr, int target){
        Arrays.sort(arr);
        int low = 1;
        int high = 0;
        int prev = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == target) return 0;
            if(prev < target && arr[i] > target){
                low = prev + 1;
                high = arr[i] - 1;
                break;
            }
            prev = arr[i];
        }
        return (target - low) * (high - target + 1) + (high - target);
    }
}

package com.algorithm.baekjoon.silver5;

import java.util.Scanner;

public class Solution_2435 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }
        int answer = sum;
        int lt = 0;
        int rt = k;
        while(rt < n){
            sum -= arr[lt++];
            sum += arr[rt++];
            answer = Math.max(sum, answer);
        }
        System.out.println(answer);
    }
}

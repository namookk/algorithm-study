package com.algorithm.inflearn.y2021.m11.d5;

import java.util.Arrays;
import java.util.Scanner;

public class Main8_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        System.out.println(solution(arr, k));
    }

    public static int solution(int[] arr, int k) {
        int answer = 0;
        Arrays.sort(arr);
        int idx = arr.length - 1;
        while(k > 0) {
            answer += k / arr[idx];
            k = k % arr[idx];
            idx--;
            System.out.println(k);
        }
        return answer;
    }
}

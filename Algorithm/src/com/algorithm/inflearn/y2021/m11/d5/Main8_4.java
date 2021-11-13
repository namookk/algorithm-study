package com.algorithm.inflearn.y2021.m11.d5;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main8_4 {
    static Integer[] arr;
    static int k;
    static Integer min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        arr = new Integer[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        k = sc.nextInt();
        Arrays.sort(arr, Collections.reverseOrder());
        DFS(0, 0);
        System.out.println(min);
    }

    public static void DFS(int cnt, int sum) {
        if(sum > k) return;
        if(cnt >= min) return;
        if(sum == k) {
            min = Math.min(min, cnt);
        }else{
            for(int i = 0; i < arr.length; i++) {
                DFS(cnt + 1, sum + arr[i]);
            }
        }
    }
}

package com.algorithm.hackerrank.y2022.m1.d11;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int maxCnt = 0;
        int minMode = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
            sum += arr[i];
            int cnt = map.getOrDefault(arr[i], 0) + 1;
            if(cnt > maxCnt){
                minMode = arr[i];
                maxCnt = cnt;
            }else if(cnt == maxCnt){
                minMode = Math.min(minMode, arr[i]);
            }
            map.put(arr[i], cnt);
        }

        System.out.println((double)sum / n);
        System.out.println(getMedian(arr));
        System.out.println(minMode);
    }

    private static double getMedian(int[] arr){
        Arrays.sort(arr);
        double sum = arr.length % 2 == 0 ? (arr[arr.length / 2 - 1] + arr[arr.length / 2]) : (arr[arr.length / 2] + arr[arr.length / 2 + 1]);
        return sum / 2;
    }
}

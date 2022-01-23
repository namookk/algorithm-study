package com.algorithm.baekjoon.silver5;

import java.util.Scanner;

public class Solution_2303 {
    static int max;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] maxArr = new int[n];
        for (int i = 0; i < n ; i++) {
            int[] arr = new int[5];
            int[] ch = new int[5];
            for(int j = 0; j < 5; j++){
                arr[j] = sc.nextInt();
            }
            max = Integer.MIN_VALUE;
            recursive(arr, ch, 0, 0);
            maxArr[i] = max;
        }

        int winNum = Integer.MIN_VALUE;
        int answer = 0;
        for(int i = 0; i < n; i++){
            if(maxArr[i] >= winNum){
                answer = i + 1;
                winNum = maxArr[i];
            }
        }
        System.out.println(answer);
    }

    private static void recursive(int[] arr, int[] ch, int sum, int count){
        if(count == 3) max = Math.max(max, sum % 10);
        else{
            for (int i = 0; i < arr.length; i++) {
                if(ch[i] == 0){
                    ch[i] = 1;
                    recursive(arr, ch, sum + arr[i], count + 1);
                    ch[i] = 0;
                }
            }
        }
    }
}

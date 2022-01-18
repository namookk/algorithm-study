package com.algorithm.baekjoon.silver5;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_1427 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[(n +"").length()];
        int idx = 0;
        while(n > 0){
            arr[idx] = n % 10;
            n /= 10;
            idx++;
        }
        Arrays.sort(arr);
        for(int i = arr.length - 1; i >= 0; i--) System.out.print(arr[i]);
    }
}

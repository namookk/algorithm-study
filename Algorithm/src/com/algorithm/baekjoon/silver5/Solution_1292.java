package com.algorithm.baekjoon.silver5;

import java.util.Scanner;

public class Solution_1292 {
    static int[] arr = new int[1001];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        System.out.println(solution(n, m));
    }

    private static int solution(int n, int m){
        fill(1, 0);
        int sum = 0;
        for(int i = n; i <= m; i++){
            sum += arr[i];
        }
        return sum;
    }

    private static void fill(int num, int idx){
        for(int i = 1; i <= num; i++){
            if(idx + i > 1000) return;
            arr[idx+i] = num;
        }
        fill(num + 1, idx + num);
    }
}

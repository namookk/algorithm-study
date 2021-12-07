package com.algorithm.matchhere.study1.week2;

import java.util.Scanner;

public class Solution1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        solution(N);
    }

    public static void solution(int N){
        for(int i = 1; i <= N; i++) {
            String[] arr = new String[N];
            for(int j = 1; j <= N; j++) {
                arr[j-1] = (j > (N - i) ? "*" : " ");
            }
            System.out.println(String.join("", arr));
        }
    }
}

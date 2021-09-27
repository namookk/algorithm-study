package com.algorithm.inflearn.y2021.m9.d23;

import java.util.Scanner;

public class Main2_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Integer[] arr = new Integer[n];
        for(int i = 0 ; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(solution(n, arr));
    }

    public static int solution(int n, Integer[] arr) {
        int answer = 0;
        int num = Integer.MIN_VALUE;
        for(Integer i : arr) {
            if(i > num) {
                answer++;
                num = i;
            }
        }
        return answer;
    }
}

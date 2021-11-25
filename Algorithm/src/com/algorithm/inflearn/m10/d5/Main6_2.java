package com.algorithm.inflearn.m10.d5;

import java.util.Scanner;

public class Main6_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        for(int i : solution(N, arr)) {
            System.out.print(i +" ");
        }
    }

    public static int[] solution(int N, int[] arr) {

        for(int i = 0 ; i < N; i++) {
            for(int j = 0; j < N-i-1; j++) {
                if(arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }

        return arr;
    }

}

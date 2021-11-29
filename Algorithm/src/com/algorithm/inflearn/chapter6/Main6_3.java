package com.algorithm.inflearn.chapter6;


import java.util.Scanner;

public class Main6_3 {
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
        for(int i = 1; i < N; i++) {
            for(int j = i - 1; j >= 0; j--) {
                if(arr[j+1] < arr[j]) {
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

}
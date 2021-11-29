package com.algorithm.inflearn.chapter6;

import java.util.*;

public class Main6_1 {
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

        for(int i = 0; i < N; i++) {
            int least = i;
            for(int j = i+1; j < N; j++) {
                if(arr[j] < arr[least]) least = j;
            }
            if(i != least) {
                int temp = arr[i];
                arr[i] = arr[least];
                arr[least] = temp;
            }
        }

        return arr;
    }

}

package com.algorithm.inflearn.chapter2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main2_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Integer[] arr = new Integer[n];
        for(int i = 0 ; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        solution(n, arr);
    }

    public static void solution(int n, Integer[] arr) {
        List<Integer> list = new ArrayList<>();
        int num = Integer.MIN_VALUE;
        for(Integer i : arr) {
            if(i > num) System.out.print(i+" ");
            num = i;
        }
    }
}

package com.algorithm.inflearn.m9.d24;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main2_6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for(int i : solution(n, arr)){
            System.out.print(i + " ");
        }
    }
    public static List<Integer> solution(int n, int[] arr) {
        List<Integer> answer = new ArrayList<>();
        for(int i = 0; i < n; i++){
            String numStr = arr[i] + "";
            String reverseStr = new StringBuilder(numStr).reverse().toString();
            int num = Integer.parseInt(reverseStr);
            if(isPrime(num)) answer.add(num);
        }
        return answer;
    }
    public static boolean isPrime(int num){
        if(num == 1){
            return false;
        }
        for(int i = 2; i <= Math.sqrt(num); i++) {
            if(num % i == 0) return false;
        }
        return true;
    }
}


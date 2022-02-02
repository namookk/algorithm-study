package com.algorithm.baekjoon.silver5;

import java.util.Scanner;

public class Solution_2581 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int minNum = Integer.MAX_VALUE;
        int sum = 0;
        for(int i = n; i <= m; i++){
            if(isPrime(i)){
                minNum = Math.min(minNum, i);
                sum += i;
            }
        }
        if(minNum == Integer.MAX_VALUE) System.out.println(-1);
        else{
            System.out.println(sum);
            System.out.println(minNum);
        }
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

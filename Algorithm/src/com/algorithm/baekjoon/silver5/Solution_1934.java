package com.algorithm.baekjoon.silver5;

import java.util.Scanner;

public class Solution_1934 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0; i < n; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println(a * b / gcd(a, b));
        }
    }
    public static int gcd(int a, int b){
        if(a % b == 0) return b;
        return gcd(b, a % b);
    }
}

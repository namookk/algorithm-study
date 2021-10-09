package com.algorithm.inflearn.y2021.m10.d9;

import java.util.Scanner;

public class Main7_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        System.out.println(solution(N));
    }

    public static int solution(int n) {
        return factorial(n);
    }

    public static int factorial(int n) {
        if(n < 1) {
            return 1;
        }
        return n * factorial(n-1);
    }
}

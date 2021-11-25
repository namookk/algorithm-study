package com.algorithm.inflearn.m10.d8;

import java.util.Scanner;

public class Main7_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        solution(N);
    }
    public static void solution(int n) {
        if(n == 0) return;
        else{
            solution(n-1);
            System.out.print(n + " ");
        }
    }
}

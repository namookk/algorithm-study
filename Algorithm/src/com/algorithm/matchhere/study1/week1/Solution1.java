package com.algorithm.matchhere.study1.week1;

import java.util.Scanner;

// https://www.acmicpc.net/problem/2753

public class Solution1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(solution(n));
    }

    public static int solution(int n) {
        return n % 4 == 0 && (n % 100 != 0 || n % 400 == 0) ? 1 : 0;
    }
}


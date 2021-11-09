package com.algorithm.inflearn.y2021.m11.d9;

import java.util.Scanner;

public class Main8_7 {
    static long[][] ch;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r = sc.nextInt();
        System.out.println(solution(n, r));
    }

    public static long solution(int n, int r) {
        ch = new long[n + 1][r + 1];
        return combination(n, r);
    }

    public static long combination(int n, int r) {
        if(r == 0){ ch[n][r] = 1; return 1; }
        if(r == 1){ ch[n][r] = n; return n; }
        if(r == n){ ch[n][r] = 1; return 1; }
        if(ch[n - 1][r - 1] == 0) {
            ch[n - 1][r - 1] = combination(n - 1, r - 1);
        }
        if(ch[n - 1][r] == 0) {
            ch[n - 1][r] = combination(n - 1, r);
        }
        return ch[n - 1][r - 1] + ch[n - 1][r];
    }
}

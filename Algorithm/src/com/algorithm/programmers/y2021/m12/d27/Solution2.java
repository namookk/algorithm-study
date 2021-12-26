package com.algorithm.programmers.y2021.m12.d27;

public class Solution2 {
    public static void main(String[] args) {
        int n = 220;
        System.out.println(solution(n));
    }

    public static long solution(int n) {
        if(n < 3) return n;
        long[] dy = new long[n+1];
        dy[1] = 1L;
        dy[2] = 2L;
        for(int i = 3; i <= n; i++) {
            dy[i] = (dy[i-2] + dy[i - 1]) % 1234567;
        }

        return dy[n];
    }
}

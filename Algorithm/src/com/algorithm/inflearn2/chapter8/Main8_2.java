package com.algorithm.inflearn2.chapter8;

public class Main8_2 {
    public static void main(String[] args) {
        int n = 3;
        System.out.println(solve(n));
    }

    public static int solve(int n) {
        int[] dy = new int[n+1];
        if(n==1) return 1;
        if(n==2) return 2;
        dy[0] = 0;
        dy[1] = 1;
        dy[2] = 2;

        for(int i = 3; i <= n; i++){
            dy[i] = dy[i-2] + dy[i-1];
        }
        return dy[n];
    }
}

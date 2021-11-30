package com.algorithm.inflearn.chapter10;

import java.util.Scanner;

public class Main10_1 {

    static int answer = 0;
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        //재귀방법
        recursive(0);
        System.out.println(answer);

        // 동적 계획법
        System.out.println(dynamic(n));
    }
    //재귀방법
    public static void recursive(int sum) {
        if(sum > n) return;
        if(sum == n) answer++;
        else{
            for(int i = 1;i <= 2; i++) {
                recursive(sum + i);
            }
        }
    }
    //동적계획법
    public static int dynamic(int n) {
        int[] dy = new int[n+1];
        dy[1] = 1;
        dy[2] = 2;
        for(int i = 3; i <= n; i++) {
            dy[i] = dy[i-2] + dy[i-1];
        }
        return dy[n];
    }
}

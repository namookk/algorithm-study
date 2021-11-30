package com.algorithm.inflearn.chapter10;

import java.util.Scanner;

public class Main10_1 {
    static int answer = 0;
    static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        recursive(0);
        System.out.println(answer);
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
}

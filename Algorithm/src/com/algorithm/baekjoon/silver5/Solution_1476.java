package com.algorithm.baekjoon.silver5;

import java.util.Scanner;

public class Solution_1476 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int e = sc.nextInt();
        int s = sc.nextInt();
        int m = sc.nextInt();
        int num = e;
        e %= 15;
        s %= 28;
        m %= 19;
        while(num % 15 != e || num % 28 != s || num % 19 != m){
            num += 15;
        }
        System.out.println(num);
    }
}

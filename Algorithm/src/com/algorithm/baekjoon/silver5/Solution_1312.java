package com.algorithm.baekjoon.silver5;

import java.util.Scanner;

public class Solution_1312 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        System.out.println(solution(a,b,c));
    }

    private static int solution(int a, int b, int c){
        double value = (double)a/b;
        Double value2 = (value * Math.pow(10, c))  % 10;
        return value2.intValue();
    }
}

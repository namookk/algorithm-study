package com.algorithm.matchhere.study1.round7;

import java.util.Scanner;

public class Solution1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int V = sc.nextInt();

        System.out.println(solution(A,B,V));
    }

    public static int solution(int A, int B, int V) {
        return (V - B - 1) / (A - B) + 1;
    }
}

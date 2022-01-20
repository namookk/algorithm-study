package com.algorithm.baekjoon.silver5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution_1817 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int limit = sc.nextInt();
        int count = 0;
        int sum = 0;
        if(n == 0) System.out.println(0);
        else {
            for (int i = 0; i < n; i++) {
                int num = sc.nextInt();
                if (sum + num > limit) {
                    count++;
                    sum = num;
                } else {
                    sum += num;
                }
            }
            System.out.println(count + 1);
        }
    }
}

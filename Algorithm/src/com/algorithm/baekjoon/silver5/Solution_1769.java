package com.algorithm.baekjoon.silver5;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_1769 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int level = 0;
        int sum = 0;
        while(s.length() > 1){
            sum = Arrays.stream(s.split("")).mapToInt(Integer::parseInt).sum();
            System.out.println(sum);
            s = sum + "";
            level++;
        }
        System.out.println(level);
        System.out.println(Integer.parseInt(s) % 3 == 0 ? "YES" : "NO");
    }
}

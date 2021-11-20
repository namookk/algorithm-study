package com.algorithm.hackerrank.y2021.m11.d20;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args){
       Scanner sc = new Scanner(System.in);
       int x1 = sc.nextInt();
       int v1 = sc.nextInt();
       int x2 = sc.nextInt();
       int v2 = sc.nextInt();
        System.out.println(kangaroo(x1,v1,x2,v2));
    }
    public static String kangaroo(int x1, int v1, int x2, int v2) {
        int firstDiff = Math.abs(x1 - x2);
        int secondDiff = Math.abs((x1 + v1) - (x2 + v2));
        int diff = firstDiff - secondDiff;
        if(diff > 0 && firstDiff % diff == 0){
            return "YES";
        }
        return "NO";
    }
}

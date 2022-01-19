package com.algorithm.baekjoon.silver5;

import java.util.Scanner;

public class Solution_1459 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long x = sc.nextLong();
        long y = sc.nextLong();
        int dist = sc.nextInt();
        int cross = sc.nextInt();

        long answer = Long.MAX_VALUE;
        answer = Math.min((x+y) * dist, answer);
        if((x+y) % 2 == 0){
            answer = Math.min(Math.max(x,y) * cross, answer);
        }else{
            answer = Math.min((Math.max(x,y) - 1) * cross + dist, answer);
        }
        answer = Math.min(Math.min(x, y) * cross + Math.abs(x - y) * dist, answer);

        System.out.println(answer);
    }
}

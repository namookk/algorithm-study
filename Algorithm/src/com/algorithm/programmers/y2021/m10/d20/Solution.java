package com.algorithm.programmers.y2021.m10.d20;

//https://programmers.co.kr/learn/courses/30/lessons/87389
public class Solution {
    public static void main(String[] args) {
        int n = 10;
        System.out.println(solution(n));
    }

    public static int solution(int n) {
        int answer = 0;
        return getMin(n-1);
    }

    public static int getMin(int k) {
        for(int i = 2; i <= k;i++) {
            if(k%i == 0) return i;
        }
        return 0;
    }
}

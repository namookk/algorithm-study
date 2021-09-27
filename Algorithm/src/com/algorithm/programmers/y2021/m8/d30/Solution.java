package com.algorithm.programmers.y2021.m8.d30;

public class Solution {
    public static void main(String[] args) {
        int price = 3; //1회 가격
        int money = 20; // 자산
        int count = 4; //회수

        System.out.println(solution(price, money, count));
    }

    public static long solution(int price, int money, int count) {
        long answer = -1;
        long total = (long)price * ((count + 1) * (count / 2) + (count % 2 == 1 ? (count + 1) / 2 : 0)); // 합

        return total > money ? total - money : 0;
    }
}

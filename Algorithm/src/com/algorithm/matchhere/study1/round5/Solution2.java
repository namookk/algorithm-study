package com.algorithm.matchhere.study1.round5;

import java.util.Scanner;

public class Solution2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(solution(n));
    }
    public static int solution(int n){
        if(n < 100) return n;
        else{
            int cnt = 99;
            for(int i = 100; i <= n; i++) {
                int a = i / 100;
                int b = (i / 10)  % 10;
                int c = i % 10;

                if((a-b) == (b-c)) cnt++;
            }
            return cnt;
        }
    }
}

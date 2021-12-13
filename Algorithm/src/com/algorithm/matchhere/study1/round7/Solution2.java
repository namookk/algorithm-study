package com.algorithm.matchhere.study1.round7;

import java.util.Scanner;

public class Solution2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(solution(n));
    }

    public static int solution(int n) {
        int cnt = 0;
        while(true){
            if(n % 5 == 0) {
                return n/5 + cnt;
            }else if(n < 0) {
                return -1;
            }
            n -= 3;
            cnt++;
        }
    }
}

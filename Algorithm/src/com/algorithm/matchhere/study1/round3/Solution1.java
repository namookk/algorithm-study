package com.algorithm.matchhere.study1.round3;

import java.util.Scanner;

public class Solution1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(solution(n));
    }

    public static int solution(int n) {
        int answer = 0;
        int new_num = n;
        do{
            int sum = new_num / 10 + new_num % 10;
            new_num = (new_num % 10 * 10) + (sum % 10);
            answer++;
        }while(new_num != n);

        return answer;
    }
}

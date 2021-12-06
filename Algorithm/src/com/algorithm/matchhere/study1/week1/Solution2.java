package com.algorithm.matchhere.study1.week1;

import java.util.Scanner;

//https://www.acmicpc.net/problem/14681

public class Solution2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();

        System.out.println(solution(x, y));
    }

    public static int solution(int x, int y) {
        if(x > 0) {
            if(y > 0) return 1;
            else return 4;
        }else{
            if(y > 0) return 2;
            else return 3;
        }
    }
}

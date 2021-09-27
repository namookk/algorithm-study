package com.algorithm.inflearn.y2021.m9.d21;

import java.util.Scanner;

public class Main1_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(solution(str));
    }

    public static String solution(String str) {
        String answer = null;
        String[] arr = str.split(" ");
        int longLen = 0;
        for(String s : arr) {
            if(s.length() > longLen) {
                longLen = s.length();
                answer = s;
            }
        }
        return answer;
    }
}

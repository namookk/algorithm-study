package com.algorithm.inflearn.chapter1;

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

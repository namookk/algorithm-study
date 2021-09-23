package com.algorithm.day24;

import java.util.Scanner;

public class Main1_12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.next();
        System.out.println(solution(n, str));
    }

    public static String solution(int n, String str) {
        String answer = "";
        while(n > 0) {
            String s = str.substring(0,7);
            String binary = s.replaceAll("\\#", "1").replaceAll("\\*","0");
            int num = Integer.parseInt(binary, 2);
            answer += (char) num;
            str = str.substring(7);
            System.out.println(str);
            n--;
        }
        return answer;
    }
}
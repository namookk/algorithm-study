package com.algorithm.day22;

import java.util.Scanner;
import java.util.stream.Collectors;

public class Main3 {
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

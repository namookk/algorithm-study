package com.algorithm.inflearn.chapter1;

import java.util.Scanner;

public class Main1_7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(solution(str));
    }

    public static String solution(String str) {
        String answer = "YES";
        String[] strArr = str.split("");
        for(int i = 0 ; i < strArr.length; i++) {
            String lt = strArr[i].toLowerCase();
            String rt = strArr[(strArr.length - i-1)].toLowerCase();
            if(!lt.equals(rt)) return "NO";
        }
        return answer;
    }

}

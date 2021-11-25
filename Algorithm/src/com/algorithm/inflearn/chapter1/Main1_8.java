package com.algorithm.inflearn.chapter1;

import java.util.Scanner;
import java.util.stream.Collectors;

public class Main1_8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(solution(str));
    }

    public static String solution(String str) {
        String answer = "YES";

        str = str.chars().mapToObj(c -> (char)c).filter(c -> {
            return ((c >= 65 && c <= 90 ) || ( c >= 97 && c <= 122));
        }).map(c -> String.valueOf(c)).collect(Collectors.joining());

        String[] strArr = str.split("");
        for(int i = 0 ; i < strArr.length; i++) {
            String lt = strArr[i].toLowerCase();
            String rt = strArr[(strArr.length - i-1)].toLowerCase();
            if(!lt.equals(rt)) return "NO";
        }

        return answer;
    }
}

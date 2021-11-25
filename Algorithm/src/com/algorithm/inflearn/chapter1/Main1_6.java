package com.algorithm.inflearn.chapter1;

import java.util.*;

public class Main1_6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(solution(str));
    }

    public static String solution(String str) {
        String answer = "";
        List<String> list = new ArrayList<>();
        for(int i = 0 ; i < str.length(); i++) {
            String s = String.valueOf(str.charAt(i));
            if(list.indexOf(s) == -1) list.add(s);
        }

        return String.join("", list);
    }
}

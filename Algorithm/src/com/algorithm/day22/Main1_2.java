package com.algorithm.day22;

import java.util.Scanner;
import java.util.stream.Collectors;

public class Main1_2 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        String str = sc.next();
        System.out.println(solution(str));
    }

    public static String solution(String str) {
        String answer = null;
        answer = str.chars().mapToObj(c -> (char)c).map(c -> {
            if(Character.isLowerCase(c)){
                return String.valueOf(Character.toUpperCase(c));
            }else{
                return String.valueOf(Character.toLowerCase(c));
            }
        }).collect(Collectors.joining(""));

        System.out.println(answer);

        return answer;
    }
}

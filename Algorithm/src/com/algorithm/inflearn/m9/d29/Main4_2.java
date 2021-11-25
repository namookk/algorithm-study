package com.algorithm.inflearn.m9.d29;

import java.util.*;
import java.util.stream.Collectors;

public class Main4_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        System.out.print(solution(s1, s2));
    }

    public static String solution(String s1, String s2) {
        String answer = "YES";
        List<String> s1Arr = s1.chars().mapToObj(c -> String.valueOf(c))
                .map(c -> c.toLowerCase()).sorted().collect(Collectors.toList());
        List<String> s2Arr = s2.chars().mapToObj(c -> String.valueOf(c))
                .map(c -> c.toLowerCase()).sorted().collect(Collectors.toList());

        for(int i = 0; i < s1Arr.size(); i++) {
            if(!s1Arr.get(i).equals(s2Arr.get(i))) {
                return "NO";
            }
        }
        return answer;
    }
}
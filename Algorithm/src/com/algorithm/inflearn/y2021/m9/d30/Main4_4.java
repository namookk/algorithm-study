package com.algorithm.inflearn.y2021.m9.d30;

import java.util.*;
import java.util.stream.Collectors;

public class Main4_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        System.out.print(solution(s1, s2));
    }

    public static int solution(String s1, String s2) {
        int answer = 0;
        s2 = Arrays.stream(s2.split("")).sorted().collect(Collectors.joining());
        for(int i = 0; i <= s1.length() - s2.length(); i++) {
            String s = s1.substring(i, i + s2.length());
            s = Arrays.stream(s.split("")).sorted().collect(Collectors.joining());
            if(s2.equals(s)) {
                answer++;
            }
        }
        return answer;
    }
}
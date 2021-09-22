package com.algorithm.day23;

import java.util.Scanner;
import java.util.stream.Collectors;

public class Main9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(solution(str));
    }

    public static int solution(String str) {
        String ans = str.chars().mapToObj(c -> (char)c).filter(c -> {
            return Character.isDigit(c);
        }).map(c -> String.valueOf(c)).collect(Collectors.joining());
        return Integer.parseInt(ans);
    }
}

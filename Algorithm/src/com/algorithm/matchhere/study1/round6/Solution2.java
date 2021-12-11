package com.algorithm.matchhere.study1.round6;

import java.util.Arrays;
import java.util.Scanner;

public class Solution2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        System.out.println(solution(s));
    }

    public static int solution(String s) {
        if(s.length() == 0) return 0;
        return Arrays.stream(s.split(" ")).filter(str -> str.length() > 0 ).toArray().length;
    }
}

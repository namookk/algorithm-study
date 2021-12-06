package com.algorithm.inflearn2.chapter1;

import java.util.List;
import java.util.stream.Collectors;

public class Main1_2 {
    public static void main(String[] args) {
        String jewls = "aA";
        String stones = "aAAbbbb";
        String jewls2 = "z";
        String stones2 = "ZZ";

        System.out.println(solve(jewls, stones));
        System.out.println(solve(jewls2, stones2));
    }

    public static int solve(String jewls, String stones) {
        int answer = 0;
        List<Character> jewlList = jewls.chars().mapToObj(c -> (char)c).collect(Collectors.toList());
        for(char stone : stones.toCharArray()) {
            if(jewlList.indexOf(stone) > -1) answer++;
        }
        return answer;
    }
}

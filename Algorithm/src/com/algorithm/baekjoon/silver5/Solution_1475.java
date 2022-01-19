package com.algorithm.baekjoon.silver5;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution_1475 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int cnt = 0;
        Map<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()){
            if(c == '6' || c == '9'){
                int value = map.getOrDefault('a', 0) + 1;
                map.put('a', value);
                cnt = Math.max(cnt, value % 2 == 0 ? value / 2 : value / 2 + 1);
            }else{
                int value = map.getOrDefault(c, 0) + 1;
                map.put(c, value);
                cnt = Math.max(cnt, value);
            }
        }
        System.out.println(cnt);
    }
}

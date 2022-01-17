package com.algorithm.baekjoon.silver5;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution_1316 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int answer = 0;
        for(int i = 0; i < n; i++){
            String s = sc.nextLine();
            Map<Character, Integer> map = new HashMap<>();
            char prev = 'A';
            answer++;
            for(char c : s.toCharArray()){
                if(prev != c && map.getOrDefault(c, 0) > 0){
                    answer--;
                    break;
                }
                map.put(c, map.getOrDefault(c, 0) + 1);
                prev = c;
            }
        }
        System.out.println(answer);
    }
}

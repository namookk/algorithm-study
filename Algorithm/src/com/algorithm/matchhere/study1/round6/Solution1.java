package com.algorithm.matchhere.study1.round6;

import java.util.Scanner;

public class Solution1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        System.out.println(solution(s));
    }

    public static String solution(String s) {
        int max = 0;
        int[] arr = new int[26];
        for(char c : s.toCharArray()) {
            int idx = Character.toUpperCase(c) - 'A';
            arr[idx]++;
            max = Math.max(max, arr[idx]);
        }
        int cnt = 0;
        char maxC = 'A';
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == max) {
                maxC = (char)(i + 'A');
                cnt++;
            }
        }
        return cnt == 1 ? String.valueOf(maxC) : "?";
    }
}

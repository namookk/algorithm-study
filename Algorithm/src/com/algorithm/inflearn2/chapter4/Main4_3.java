package com.algorithm.inflearn2.chapter4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main4_3 {
    public static void main(String[] args) {
        String s = "bacdgabcda";
        String p = "abcd";

        for(int i : solve(s, p)) System.out.print(i + " ");
    }

    public static List<Integer> solve(String s, String p) {
        List<Integer> answer = new ArrayList<>();
        if(s == null|| s.length() == 0 || p == null || p.length() == 0 || s.length() < p.length()) return answer;

        int l = 0, r = p.length() -1;
        int[] arr = new int[26];
        for(int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            arr[c - 'a'] = 1;
        }
        String key = Arrays.toString(arr);
        while(r < s.length()) {
            int[] new_arr = new int[26];
            for(int i = l; i <= r; i++) {
                char c = s.charAt(i);
                new_arr[c - 'a'] = 1;
            }
            String key2 = Arrays.toString(new_arr);
            if(key.equals(key2)) answer.add(l);
            l++;
            r++;
        }
        return answer;
    }
}

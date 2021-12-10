package com.algorithm.inflearn2.chapter4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main4_1 {
    public static void main(String[] args) {
        String s = "abcabcd";
        System.out.println(solve(s));
    }

    //Sliding Window 풀이
    public static int solve(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int answer = 0;
        int lt = 0;
        int rt = 0;
        int counter = 0;

        while(rt < s.length()) {
            char c = s.charAt(rt);
            map.put(c, map.getOrDefault(c,0) + 1);
            if(map.get(c) > 1) counter++;
            rt++;

            while(counter > 0) {
                char c2 = s.charAt(lt);
                if(map.get(c2) > 1) counter--;
                map.put(c2, map.get(c2) - 1);
                lt++;
            }
            answer = Math.max(answer, rt - lt);
        }

        return answer;
    }
}

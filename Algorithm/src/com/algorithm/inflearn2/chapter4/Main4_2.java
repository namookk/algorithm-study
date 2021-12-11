package com.algorithm.inflearn2.chapter4;

import java.util.HashMap;
import java.util.Map;

public class Main4_2 {
    public static void main(String[] args) {
        String s = "eceba";
        String s2 = "ccaabbb";

        System.out.println(solve(s));
        System.out.println(solve(s2));
    }

    public static int solve(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int rt = 0;
        int lt = 0;
        int count = 0;
        int answer = 0;
        while(rt < s.length()){
            char c = s.charAt(rt);
            if(!map.containsKey(c)) {
                map.put(c, 1);
                count++;
            }else{
                map.put(c, map.get(c) + 1);
            }
            rt++;
            while(count > 2) {
                char c2 = s.charAt(lt);
                if(map.get(c2) == 1) {
                    count--;
                    map.remove(c2);
                }else{
                    map.put(c2, map.get(c2) - 1);
                }
                lt++;
            }
            answer = Math.max(answer, rt-lt);
        }
        return answer;
    }
}

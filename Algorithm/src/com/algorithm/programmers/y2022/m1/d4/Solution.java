package com.algorithm.programmers.y2022.m1.d4;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        String[] gems = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
        String[] gems2 = {"XYZ", "XYZ", "XYZ"};
        int[] result = solution(gems);
        System.out.println(result[0] +", "+ result[1]);
    }

    private static int[] solution(String[] gems){
        Set<String> allKind = new HashSet<>();
        for(String gem : gems){
            allKind.add(gem);
        }
        int size = allKind.size();
        if(allKind.size() == 1) return new int[]{1, 1};

        Map<String, Integer> map = new HashMap<>();
        int lt = 0;
        map.put(gems[lt], map.getOrDefault(gems[lt], 0) + 1);
        int rt = 1;
        map.put(gems[rt], map.getOrDefault(gems[rt], 0) + 1);

        while(map.size() < size){
            String key = gems[++rt];
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        while(map.size() == size){
            int num = map.get(gems[lt]);
            if(num == 1) break;
            else{
                map.put(gems[lt], num - 1);
            }
            lt++;
        }

        return new int[]{lt+1, rt+1};
    }
}

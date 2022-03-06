package com.algorithm.programmers.y2022.m3.d6;

import java.util.*;

public class Solution {
    Map<String, Integer> map;

    public static void main(String[] args) {
        Solution solution = new Solution();

        String[] orders1 = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] course1 = {2,3,4};

        String[] orders2 = {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"};
        int[] course2 = {2,3,5};

        String[] orders3 = {"XYZ", "XWY", "WXA"};
        int[] course3 = {2,3,4};

        System.out.println(solution.solution(orders1, course1));
        System.out.println(solution.solution(orders2, course2));
        System.out.println(solution.solution(orders3, course3));
    }

    public String[] solution(String[] orders, int[] course) {
        List<String> answerList = new ArrayList<>();

        String[] new_orders = Arrays.stream(orders).map(s -> {
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            return new StringBuilder(new String(arr)).toString();
        }).toArray(String[]::new);

        for(int cs : course){
            map = new HashMap<>();

            for(String order : new_orders) {
                combination(order, 0, cs, new ArrayList<>());
            }

            List<Map.Entry<String, Integer>> entryList = new LinkedList<>(map.entrySet());
            entryList.sort((a,b) -> b.getValue() - a.getValue());

            Integer max = 2;
            for(Map.Entry<String, Integer> entry : entryList){
                if(entry.getValue() >= max){
                    System.out.println(entry.getKey());
                    answerList.add(entry.getKey());
                    max = entry.getValue();
                }else{
                    break;
                }
            }

        }

        return answerList.stream().sorted().toArray(String[]::new);
    }

    private void combination(String s, int start, int count, List<String> list) {
        if(count == 0){
            String key = String.join("", list);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }else{
            for(int i = start; i < s.length(); i++){
                list.add(String.valueOf(s.charAt(i)));
                combination(s, i+1, count - 1, list);
                list.remove(list.size() - 1);
            }
        }
    }
}

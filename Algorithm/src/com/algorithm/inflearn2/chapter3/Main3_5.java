package com.algorithm.inflearn2.chapter3;

import java.util.*;

public class Main3_5 {
    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};

        for(List<String> list : solve(strs)) {
            for(String str : list) {
                System.out.print(str +" ");
            }
            System.out.println();
        }
        for(List<String> list : solve_ascii(strs)) {
            for(String str : list) {
                System.out.print(str +" ");
            }
            System.out.println();
        }
    }
    //sort 이용
    public static List<List<String>> solve(String[] strs) {
        List<List<String>> answer = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for(String str : strs) {
            char[] charArr = str.toCharArray();
            Arrays.sort(charArr);
            String key = String.valueOf(charArr);

            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key, list);
        }

        answer.addAll(map.values());
        return answer;
    }

    //sort 이용X
    public static List<List<String>> solve_ascii(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> answer = new ArrayList<>();

        for(String str : strs) {
            int[] count = new int[26];
            for(int k = 0; k < str.length(); k++) {
                count[str.charAt(k) - 'a']++; // [1,0,0,0,0....1] 26개
            }
            String key = Arrays.toString(count);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key, list);
        }
        answer.addAll(map.values());
        return answer;
    }
}

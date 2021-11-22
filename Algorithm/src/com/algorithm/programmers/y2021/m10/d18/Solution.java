package com.algorithm.programmers.y2021.m10.d18;

import java.util.*;

//https://programmers.co.kr/learn/courses/30/lessons/43163

public class Solution {
    public static void main(String[] args) {
        String begin = "1234567000";
        String target = "1234567899";
        String[] words = {"1234567800", "1234567890", "1234567899"};

        System.out.println(solution(begin, target, words));
    }
    public static int solution(String begin, String target, String[] words) {
        int answer = 0;
        int level = 0;
        Map<String, Integer> visited = new HashMap<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(begin);
        while(!queue.isEmpty()) {
            String word = queue.poll();
            List<String> availList = getAvailWords(word, words);
            if(availList.size() > 0) {
                for(int i = 0; i < availList.size(); i++) {
                    String availWord = availList.get(i);
                    if (availWord.equals(target)) return ++level;
                    if(visited.get(availWord) == null) {
                        visited.put(availWord, 1);
                        queue.offer(availWord);
                    }
                }
            }
            level++;
        }

        return answer;
    }
    public static List<String> getAvailWords(String word, String[] words) {
        List<String> availList = new ArrayList<>();
        for(String str : words) {
            if(!word.equals(str)) {
                int diff = 0;
                for(int i = 0; i < str.length(); i++) {
                    if(word.charAt(i) != str.charAt(i)) {
                        diff++;
                    }
                    if(diff > 1) break;
                }
                if(diff == 1) availList.add(str);
            }
        }
        return availList;
    }
}

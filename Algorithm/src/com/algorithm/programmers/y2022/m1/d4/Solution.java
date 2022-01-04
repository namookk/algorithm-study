package com.algorithm.programmers.y2022.m1.d4;

import java.util.*;

//https://programmers.co.kr/learn/courses/30/lessons/67258
//정확성  테스트
//    테스트 1 〉	통과 (0.66ms, 74MB)
//    테스트 2 〉	통과 (0.89ms, 77.6MB)
//    테스트 3 〉	통과 (1.16ms, 76.3MB)
//    테스트 4 〉	통과 (1.10ms, 77.5MB)
//    테스트 5 〉	통과 (0.81ms, 74.6MB)
//    테스트 6 〉	통과 (0.92ms, 73.4MB)
//    테스트 7 〉	통과 (0.65ms, 71.8MB)
//    테스트 8 〉	통과 (1.21ms, 74.3MB)
//    테스트 9 〉	통과 (1.56ms, 77.3MB)
//    테스트 10 〉	통과 (1.29ms, 77.5MB)
//    테스트 11 〉	통과 (1.86ms, 81.4MB)
//    테스트 12 〉	통과 (2.22ms, 74.2MB)
//    테스트 13 〉	통과 (2.05ms, 80MB)
//    테스트 14 〉	통과 (2.26ms, 76MB)
//    테스트 15 〉	통과 (3.09ms, 84.8MB)
//효율성  테스트
//    테스트 1 〉	통과 (13.47ms, 54.8MB)
//    테스트 2 〉	통과 (8.82ms, 56.1MB)
//    테스트 3 〉	통과 (11.86ms, 59.6MB)
//    테스트 4 〉	통과 (10.62ms, 59.6MB)
//    테스트 5 〉	통과 (20.10ms, 61.6MB)
//    테스트 6 〉	통과 (20.04ms, 63.5MB)
//    테스트 7 〉	통과 (30.82ms, 68.3MB)
//    테스트 8 〉	통과 (36.53ms, 70.8MB)
//    테스트 9 〉	통과 (26.11ms, 70.8MB)
//    테스트 10 〉	통과 (44.09ms, 91.4MB)
//    테스트 11 〉	통과 (46.28ms, 78.8MB)
//    테스트 12 〉	통과 (66.52ms, 79.9MB)
//    테스트 13 〉	통과 (37.94ms, 80.5MB)
//    테스트 14 〉	통과 (40.01ms, 79.8MB)
//    테스트 15 〉	통과 (62.79ms, 80.6MB)
public class Solution {
    public static void main(String[] args) {
        String[] gems = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
        String[] gems2 =  {"DIA", "EM", "EM", "RUB", "DIA"};
        int[] result = solution(gems2);
        System.out.println(result[0] +", "+ result[1]);
    }

    private static int[] solution(String[] gems){
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) ->{
            if(a[1] - a[0] == b[1] - b[0]) return a[0] - b[0];
            else return (a[1] - a[0]) - (b[1] - b[0]);
        });

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
        while(rt < gems.length){
            if(map.size() == size) {
                String key = gems[lt];
                int num = map.get(gems[lt]);
                if(num == 1) {
                    pq.offer(new int[]{lt + 1, rt});
                    map.remove(key);
                }
                else map.put(key, num -1);
                lt++;
            }else{
                String key = gems[rt];
                map.put(key, map.getOrDefault(key, 0) + 1);
                rt++;
            }
        }

        while(map.size() == size){
            String key = gems[lt];
            int num = map.get(gems[lt]);
            if(num == 1) {
                pq.offer(new int[]{lt + 1, rt});
                map.remove(key);
            }
            else map.put(key, num -1);
            lt++;
        }

        if(map.size() == size) pq.offer(new int[]{lt + 1, rt});
        return pq.poll();
    }
}

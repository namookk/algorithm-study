package com.algorithm.programmers.y2022.m3.d10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class Solution {

    public static void main(String[] args) {
        String[] info = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
        String[] query = {"java and backend and junior and pizza 100",
            "python and frontend and senior and chicken 200",
            "cpp and - and senior and pizza 250",
            "- and backend and senior and - 150",
            "- and - and - and chicken 100",
            "- and - and - and - 150"};

        int[] result = solution(info, query);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }

    private static int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        Map<String, PriorityQueue<Integer>> map = new HashMap<>();

        for(String infoStr : info){
            String[] infoArr = infoStr.split(" ");
            List<String> keys = generateKey(infoArr);

            int score = Integer.parseInt(infoArr[4]);
            for(String key : keys) {
                PriorityQueue<Integer> pq = map.getOrDefault(key, new PriorityQueue<>());
                pq.offer(score);
                map.put(key, pq);
            }
        }

        for (Entry<String, PriorityQueue<Integer>> stringPriorityQueueEntry : map.entrySet()) {
            System.out.println(stringPriorityQueueEntry.getKey() +  "  " + stringPriorityQueueEntry.getValue().size());
        }

        for(int i = 0; i < query.length; i++){
            String queryStr = query[i];

            String[] queryArr = queryStr.split(" and ");
            String[] foodAndScore = queryArr[3].split(" ");
            String key = queryArr[0] + queryArr[1] + queryArr[2] + foodAndScore[0];
            Integer score = Integer.parseInt(foodAndScore[1]);
            if(map.containsKey(key)) {
                PriorityQueue<Integer> scorePq = map.get(key);
                if (!scorePq.isEmpty()) {
                    int size = scorePq.size();
                    if (size == 1) {
                        if (scorePq.poll() >= score)
                            answer[i] = 1;
                    } else {
                        while (!scorePq.isEmpty() && scorePq.peek() < score) {
                            scorePq.poll();
                        }
                        answer[i] = scorePq.size();
                    }
                }
            }
        }
        return answer;
    }

    private static List<String> generateKey(String[] infoArr){
        String language = infoArr[0];
        String job = infoArr[1];
        String career = infoArr[2];
        String food =  infoArr[3];

        List<String> list = new ArrayList<>();

        //4
        list.add(language + job + career + food);

        //3
        list.add(language + job + career + "-");
        list.add(language + job + "-" + food);
        list.add(language + "-" + career + food);
        list.add("-" + job + career + food);

        //2
        list.add(language + job + "-" + "-");
        list.add(language + "-" + career + "-");
        list.add("-" + job + career + "-");
        list.add(language + "-" + "-" + food);
        list.add("-" + job + "-" + food);
        list.add("-" + "-" + career + food);

        //1
        list.add("-" + "-" + "-" + food);
        list.add("-" + "-" + career + "-");
        list.add("-" + job + "-" + "-");
        list.add(language + "-" + "-" + "-");

        //0
        list.add("-" + "-" + "-" + "-");

        return list;
    }
}

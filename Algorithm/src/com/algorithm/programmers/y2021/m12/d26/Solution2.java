package com.algorithm.programmers.y2021.m12.d26;

import java.util.*;

public class Solution2 {
    public static void main(String[] args) {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};

        for(int i : solution(genres, plays)) System.out.print(i + " ");
    }
    public static int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> genreRank = new HashMap<>();
        Map<String, PriorityQueue<Play>> rankIdxMap = new HashMap<>();

        for(int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];
            genreRank.put(genre, genreRank.getOrDefault(genre,0) + play);

            PriorityQueue<Play> pq = null;
            if(rankIdxMap.containsKey(genre)) pq = rankIdxMap.get(genre);
            else pq = new PriorityQueue<>();

            pq.add(new Play(i, play));
            if(pq.size() > 2) pq.poll();

            rankIdxMap.put(genre, pq);
        }

        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(genreRank.entrySet());
        Collections.sort(entryList, (a,b) -> {
            return b.getValue().compareTo(a.getValue());
        });
        List<Integer> answerList = new ArrayList<>();
        int idx = 0;
        for(Map.Entry<String, Integer> entry : entryList) {
            PriorityQueue<Play> pq = rankIdxMap.get(entry.getKey());
            int len = pq.size();
            while(!pq.isEmpty() && pq != null) {
                Play p = pq.poll();
                answerList.add(idx, p.idx);
            }
            idx += 2;
        }

        return answerList.stream().mapToInt(i->i).toArray();
    }
}

class Play implements Comparable<Play>{
    int idx;
    int count;
    Play(int idx, int count){
        this.idx = idx;
        this.count = count;
    }
    @Override
    public int compareTo(Play o) {
        if(this.count == o.count) return this.idx - o.idx;
        return this.count - o.count;
    }
}

package com.algorithm.baekjoon.silver5;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution_1251 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        System.out.println(solution(s));
    }

    private static String solution(String s){
        PriorityQueue<String> pq = new PriorityQueue<>();

        for (int i = 1; i < s.length() - 1; i++) {
            String start = new StringBuffer(s.substring(0, i))
                    .reverse()
                    .toString();
            if(!pq.isEmpty() && start.compareTo(pq.peek().substring(0, i)) > 0) continue;
            for (int j = i + 1; j < s.length(); j++) {
                String mid = new StringBuffer(s.substring(i, j)).reverse().toString();
                String end = new StringBuffer(s.substring(j)).reverse().toString();
                pq.offer(start + mid + end);
            }
        }

        return pq.poll();
    }
}

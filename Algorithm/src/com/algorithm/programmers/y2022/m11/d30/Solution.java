package com.algorithm.programmers.y2022.m11.d30;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class Solution {

  public static void main(String[] args) {
    int k = 3;
    int[] scores = {10, 100, 20, 150, 1, 100, 200};
    int[] result = solution(k, scores);
    for (int i : result) {
      System.out.println(i + "");
    }
  }

  private static int[] solution(int k, int[] score) {
    int[] answer = new int[score.length];
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    for(int i = 0; i < score.length; i++) {
      if(pq.size() < k || score[i] > pq.peek()) {
        if (pq.size() >= k) {
          pq.poll();
        }

        pq.offer(score[i]);
      }
      Integer min = pq.peek();
      answer[i] = min;
    }

    return answer;
  }
}

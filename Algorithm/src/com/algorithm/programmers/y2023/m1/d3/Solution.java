package com.algorithm.programmers.y2023.m1.d3;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {

  public static void main(String[] args) {
    int[][] office1 = {{1,0,0,0}, {0,0,0,1}, {0,0,1,0}, {0,1,1,0}};
    int k1 = 2;

    System.out.println(solution(office1, k1));
    int[][] office2 = {{1,0,0}, {0,0,1}, {1,0,0}};
    int k2 = 2;

    System.out.println(solution(office2, k2));
  }

  private static int solution(int[][] office, int k) {
    int N = office.length;
    int answer = 0;
    for(int i = 0; i <= N - k; i++) {
      for(int j = 0; j <= N - k; j++) {
        answer = Math.max(answer, count(office, i, j, k));
      }
    }

    return answer;
  }

  private static int count(int[][] office, int startI, int startJ, int k) {
    int count = 0;
    for(int i = startI; i < startI + k; i++) {
      for(int j = startJ; j < startJ + k; j++) {
        count += office[i][j];
      }
    }

    return count;
  }
}

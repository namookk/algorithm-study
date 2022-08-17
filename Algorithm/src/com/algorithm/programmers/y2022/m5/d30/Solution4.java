package com.algorithm.programmers.y2022.m5.d30;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution4 {

  public static void main(String[] args) {
    int n = 10;
    int k = 2;
    System.out.println(solution2(n, k));
  }

  private static int solution(int n, int k) {
    int answer = 0;
    return answer;
  }

  private static int solution2(int n, int k) {
    Queue<int[]> queue = new LinkedList<>();
    int[] arr = new int[k];
    int min = 0;
    for(int i = 0; i < k; i++) {
      arr[i] = k - i;
      min += k - i;
    }
    queue.offer(arr);
    if(min > n) return 0;
    if(min == n) return 1;

    int num = min;
    while(!queue.isEmpty() && num < n) {
      int len = queue.size();
      for(int i = 0; i < len; i++) {
        int[] way = queue.poll();
        int[] new_way = Arrays.copyOf(way, way.length);
        new_way[0] += 1;
        queue.offer(new_way);
        for(int j = 1; j < k; j++) {
          if(way[j-1] > way[j] + 1) {
            new_way = Arrays.copyOf(way, way.length);
            new_way[j] += 1;
            queue.offer(new_way);
          }
        }
      }
      num++;
    }

    Set<String> answer = new HashSet<>();
    while(!queue.isEmpty()){
      int[] way = queue.poll();
      answer.add(Arrays.stream(way).mapToObj(String::valueOf).collect(Collectors.joining(",")));
    }

    return answer.size() % 1000000007;
  }

  private static int getMin(int k) {
    int min = 0;
    for(int i = k; i > 0; i--) {
      min += i;
    }
    return min;
  }
}

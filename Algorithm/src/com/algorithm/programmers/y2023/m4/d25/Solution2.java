package com.algorithm.programmers.y2023.m4.d25;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution2 {

  public static void main(String[] args) {
    String[] name = {"may", "kein", "kain", "radi"};
    int[] yearning = {5, 10, 1, 3};
    String[][] photo = {{"may", "kein", "kain", "radi"},{"may", "kein", "brin", "deny"}, {"kon", "kain", "may", "coni"}};

    int[] results = solution(name, yearning, photo);
    for(int result : results) {
      System.out.print(result + " ");
    }
  }

  private static int[] solution(String[] name, int[] yearning, String[][] photo) {
    Map<String, Integer> map = new HashMap<>();
    for(int i = 0; i < name.length; i++) {
      map.put(name[i], yearning[i]);
    }

    return Arrays.stream(photo)
        .mapToInt(p -> {
          return Arrays.stream(p)
              .mapToInt(nm -> map.getOrDefault(nm, 0))
              .sum();
        }).toArray();
  }
}

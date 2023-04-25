package com.algorithm.programmers.y2023.m4.d25;

import java.util.HashMap;
import java.util.Map;

public class Solution {

  public static void main(String[] args) {
    String[] players = {"mumu", "seo", "poe", "kai", "mine"};
    String[] callings = {"kai", "kai", "mine", "mine"};

    String[] results = solution(players, callings);
    for(String result : results) {
      System.out.print(result + " ");
    }
  }

  private static String[] solution(String[] players, String[] callings) {
    Map<String, Integer> map = new HashMap<>();
    for(int i = 0; i < players.length; i++) {
      map.put(players[i], i);
    }

    for(String calling : callings) {
      int index = map.get(calling);
      String frontPlayer = players[index - 1];
      players[index - 1] = calling;
      players[index] = frontPlayer;
      map.put(calling, index - 1);
      map.put(frontPlayer, index);
    }

    return players;
  }

}

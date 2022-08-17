package com.algorithm.programmers.y2022.m5.d30;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution2 {

  public static void main(String[] args) {
    String[] orders = {"alex pizza pasta", "alex pizza pizza", "alex noodle", "bob pasta", "bob noodle sandwich pasta", "bob steak noodle"};
    String[] result = solution(orders);
    for(String s : result) {
      System.out.print(s + " ");
    }

    System.out.println( );

    String[] orders2 = {"alex pizza pasta steak", "bob noodle sandwich pasta", "choi pizza sandwich pizza", "alex pizza pasta steak"};
    String[] result2 = solution(orders2);
    for(String s : result2) {
      System.out.print(s + " ");
    }
  }

  private static String[] solution(String[] orders) {
    Set<String> answerSet = new HashSet<>();
    int max = Integer.MIN_VALUE;
    Map<String, Set<String>> orderMap = new HashMap<>();

    for(String orderStr : orders) {
      String[] order = orderStr.split(" ");
      String person = order[0];
      Set<String> orderMenu = orderMap.getOrDefault(person, new HashSet<>());
      orderMenu.addAll(Arrays.stream(order).collect(Collectors.toList()));
      orderMap.put(person, orderMenu);
      if(orderMenu.size() >= max) {
        if(orderMenu.size() > max) {
          answerSet.clear();
        }
        answerSet.add(person);
        max = orderMenu.size();
      }
    }

    String[] answer = answerSet.toArray(String[]::new);
    Arrays.sort(answer);
    return answer;
  }

}

package com.algorithm.programmers.y2023.m2.d7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution {

  public static void main(String[] args) {
    String s = "y";
    String skip = "za";
    int index = 1;

    System.out.println(solution(s, skip, index));
  }

  private static String solution(String s, String skip, int index) {
    List<Character> skipCharacters = skip.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
    List<String> answer = new ArrayList<>();
    Map<Character, String> jumpedAlphabetMap = new HashMap<>();
    for(char alphabet : s.toCharArray()) {
      String jumpedAlphabet = jumpedAlphabetMap.getOrDefault(alphabet, getJumpedAlphabet(alphabet, skipCharacters, index));
      answer.add(jumpedAlphabet);
      jumpedAlphabetMap.put(alphabet, jumpedAlphabet);
    }

    return String.join("", answer);
  }

  private static String getJumpedAlphabet(char alphabet, List<Character> skip, int index) {
    System.out.println(alphabet);
    while(index > 0) {
      alphabet++;
      if(alphabet > 122) {
        alphabet = 97;
      }

      if(!skip.contains(alphabet)) {
        System.out.println(alphabet + " - not contains");
        index--;
      }
    }
    System.out.println(alphabet);

    return Character.toString(alphabet);
  }
}

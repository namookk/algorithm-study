package com.algorithm.programmers.y2022.m4.d27;

public class Solution {

  public static void main(String[] args) {
    long[] numbers = {2, 7};
    long[] result = solution(numbers);

    for (long i : result) {
      System.out.println(i + " ");
    }
  }
  public static long[] solution(long[] numbers) {
    long[] answer = new long[numbers.length];
    for(long num : numbers) {
      String binaryStr = Long.toBinaryString(num);
      
    }

    return answer;
  }
}

package com.algorithm.programmers.y2022.m8.d17;

public class Solution {

  public static void main(String[] args) {
    int[] answer = solution(1L, 10L);
    for(int num : answer) {
      System.out.print(num + " ");
    }
  }

  public static int[] solution(long begin, long end) {
    int size = Math.toIntExact(end - begin + 1);
    int[] answer = new int[size];
    int idx = 0;
    for(long i = begin; i <= end; i++) {
      System.out.println("i == " + i );
      answer[idx] = Math.toIntExact(getMaxDivisor(i));
      idx++;
    }
    return answer;
  }

  private static long getMaxDivisor(long n) {
    if(n <= 1) return 0;
    int sqrt = (int) Math.sqrt(n);
    long max = 0;

    for(int i = 1; i <= sqrt; i++) {
      if(n % i == 0){ // 약수 중 작은 수 저장
        if(Math.max(max, i) <= 10_000_000) {
          max = Math.max(max, i);
        }
        if(n / i != i && i != 1 && Math.max(max, n / i) <= 10_000_000){ // 약수 중 큰 수 저장
          max = Math.max(max, n / i);
        }
      }
    }
    return max;
  }
}

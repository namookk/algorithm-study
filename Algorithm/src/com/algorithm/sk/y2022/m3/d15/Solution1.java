package com.algorithm.sk.y2022.m3.d15;

import java.util.Arrays;

public class Solution1 {

  public static void main(String[] args) {
    int money = 4578;
    int[] costs = {1, 4, 99, 35, 50, 1000};

    System.out.println(solution(money, costs));

    int money2 = 1999;
    int[] costs2 = {2, 11, 20, 100, 200, 600};

    System.out.println(solution(money2, costs2));
  }

  private static int solution(int money, int[] costs) {
    int[] kinds = {1, 5, 10, 50, 100, 500};
    int[] dp = new int[money + 1];
    Arrays.fill(dp, Integer.MAX_VALUE);
    for(int i = 1; i < 5; i++) {
      dp[i] = i;
    }

    for(int i = 1; i < kinds.length; i++) {
      for(int j = kinds[i]; j < dp.length; j++) {
        int cost = dp[j - kinds[i]] + costs[i];
        if(dp[j] > cost) dp[j] = cost;
      }
    }
    return dp[money];
  }

}

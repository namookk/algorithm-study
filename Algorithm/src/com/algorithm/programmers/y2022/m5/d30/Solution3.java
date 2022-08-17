package com.algorithm.programmers.y2022.m5.d30;

public class Solution3 {

  public static void main(String[] args) {
    int n = 6;
    System.out.println(solution(n));
  }

  private static int solution(int n) {
    int[][] dp = new int[n+1][3];
    dp[0][0] = 0;
    dp[0][1] = 0;
    dp[0][2] = 1;
    dp[1][0] = 0;
    dp[1][1] = 0;
    dp[1][2] = 1;

    for(int i = 2; i <= n; i++) {
      //부화할 수 없는 용
      dp[i][0] = dp[i-1][0];
      if(i - 4 >= 0) {
        int remove = dp[i-4][1];
        dp[i][0] += remove;
        for(int j = i-4;j <= i-1; j++) {
          dp[j][1] -= remove;
        }
      }
      //부화한 용
      int born = 0;
      if(i - 2 >= 0) {
        born = dp[i-2][2];
        dp[i-2][2] -= born;
        dp[i-1][2] -= born;
      }
      //부화할 수 있는 용
      dp[i][1] = dp[i-1][1] + born;

      //알의 개수
      dp[i][2] = dp[i-1][2] + dp[i][1];
    }

    print(dp);

    return dp[n][0] + dp[n][1] + dp[n][2];
  }

  private static void print(int[][] dp) {
    for(int[] arr: dp) {
      for(int i : arr) {
        System.out.println(i + " ");
      }
      System.out.println();
    }
  }

}

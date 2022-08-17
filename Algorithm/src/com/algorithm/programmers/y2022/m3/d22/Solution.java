package com.algorithm.programmers.y2022.m3.d22;

public class Solution {
  static int[][] ch;
  static int min;
  static int len;
  static boolean isUsed;
  static int answer;
  public static void main(String[] args) {
    String L1 = "..XX.X.";
    String L2 = "X.X.X..";

    System.out.println(solution(L1, L2));

    L1 = ".XXX...X";
    L2 = "..X.XXXX";
    System.out.println(solution(L1, L2));

    L1 = "XXXXX";
    L2 = ".X..X";
    System.out.println(solution(L1, L2));

    L1 = "X...X";
    L2 = "..X..";
    System.out.println(solution(L1, L2));
  }

  private static int solution(String L1, String L2) {
    len = L1.length();
    ch = new int[2][len];
    answer = Integer.MAX_VALUE;
    isUsed = false;
    min = Integer.MAX_VALUE;

    char[][] arr = new char[][]{L1.toCharArray(), L2.toCharArray()};

    dfs(0, 0, arr ,0);
    dfs(1, 0, arr ,0);
    return answer;
  }

  private static void dfs(int row, int col, char[][] arr, int count) {
    if(row < 0 || row > 1 || col >= len || ch[row][col] == 1 || count > min) return;
    ch[row][col] = 1;

    int cnt = count;
    if(arr[row][col] == 'X') cnt++;

    if(col == len - 1) {
      if(min > cnt) {
        min = cnt;
        int xCount = 0;
        for(int i = 0; i < 2; i++) {
          for(int j = 0; j < len; j++) {
            System.out.print(ch[i][j]);
            if(ch[i][j] == 0 && arr[i][j] == 'X') xCount++;
          }
          System.out.println();
        }
        System.out.println();
        answer = xCount;
      }
    }else {
      dfs(row, col + 1, arr, cnt);
      if(isUsed == false) {
        isUsed = true;
        dfs(row == 0 ? 1 : 0, col, arr, cnt);
        isUsed = false;
      }
    }
    ch[row][col] = 0;
  }

}

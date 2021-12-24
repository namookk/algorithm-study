package com.algorithm.programmers.y2021.m12.d24;

//https://programmers.co.kr/learn/courses/30/lessons/67259

import java.util.LinkedList;
import java.util.Queue;

//정확성  테스트
//    테스트 1 〉	통과 (0.03ms, 77.7MB)
//    테스트 2 〉	통과 (0.04ms, 73.6MB)
//    테스트 3 〉	통과 (0.04ms, 77.4MB)
//    테스트 4 〉	통과 (0.05ms, 73.9MB)
//    테스트 5 〉	통과 (0.05ms, 79.2MB)
//    테스트 6 〉	통과 (0.85ms, 76MB)
//    테스트 7 〉	통과 (0.72ms, 79.1MB)
//    테스트 8 〉	통과 (0.90ms, 77.3MB)
//    테스트 9 〉	통과 (1.57ms, 74.1MB)
//    테스트 10 〉	실패 (시간 초과)
//    테스트 11 〉	실패 (시간 초과)
//    테스트 12 〉	통과 (3280.16ms, 90.1MB)
//    테스트 13 〉	통과 (0.49ms, 76.6MB)
//    테스트 14 〉	통과 (1.19ms, 79.3MB)
//    테스트 15 〉	통과 (26.65ms, 76.3MB)
//    테스트 16 〉	실패 (시간 초과)
//    테스트 17 〉	실패 (시간 초과)
//    테스트 18 〉	실패 (시간 초과)
//    테스트 19 〉	실패 (시간 초과)
//    테스트 20 〉	통과 (1.38ms, 81.2MB)
//    테스트 21 〉	통과 (1.52ms, 73MB)
//    테스트 22 〉	통과 (0.07ms, 74.5MB)
//    테스트 23 〉	통과 (0.05ms, 70.3MB)
//    테스트 24 〉	통과 (0.06ms, 72.8MB)
//    테스트 25 〉	통과 (0.05ms, 73.5MB)

//re_solve
//정확성  테스트
//    테스트 1 〉	통과 (0.04ms, 82.9MB)
//    테스트 2 〉	통과 (0.02ms, 74.7MB)
//    테스트 3 〉	통과 (0.04ms, 84.2MB)
//    테스트 4 〉	통과 (0.04ms, 78.9MB)
//    테스트 5 〉	통과 (0.03ms, 74.3MB)
//    테스트 6 〉	통과 (0.61ms, 73.8MB)
//    테스트 7 〉	통과 (0.78ms, 78.6MB)
//    테스트 8 〉	통과 (0.68ms, 76.6MB)
//    테스트 9 〉	통과 (0.79ms, 79.2MB)
//    테스트 10 〉	통과 (0.58ms, 80.2MB)
//    테스트 11 〉	통과 (11.11ms, 84.8MB)
//    테스트 12 〉	통과 (19.55ms, 81.3MB)
//    테스트 13 〉	통과 (0.12ms, 72.7MB)
//    테스트 14 〉	통과 (0.32ms, 72.8MB)
//    테스트 15 〉	통과 (0.94ms, 73.6MB)
//    테스트 16 〉	통과 (2.03ms, 71.7MB)
//    테스트 17 〉	통과 (1.85ms, 77.8MB)
//    테스트 18 〉	통과 (8.12ms, 77.9MB)
//    테스트 19 〉	통과 (16.34ms, 84.4MB)
//    테스트 20 〉	통과 (0.70ms, 77.2MB)
//    테스트 21 〉	통과 (0.72ms, 85.7MB)
//    테스트 22 〉	통과 (0.06ms, 76.2MB)
//    테스트 23 〉	통과 (0.05ms, 74.9MB)
//    테스트 24 〉	통과 (0.05ms, 73.7MB)
//    테스트 25 〉	통과 (0.04ms, 68.4MB)

public class Solution {
    static int answer;
    static int[][] ch;
    static int m,n;
    static int[][] dirs = {{0,1},{1,0},{0, -1},{-1,0}}; // 세로 세로 가로 가로
    static int[][] dp;
    public static void main(String[] args) {
        int[][] board = {{0,0,0,0,0,0},{0,1,1,1,1,0},{0,0,1,0,0,0},{1,0,0,1,0,1},{0,1,0,0,0,1},{0,0,0,0,0,0}};
        int[][] board1 = {{0,0,0},{0,0,0},{0,0,0}};
        System.out.println(solution_bfs(board));
        System.out.println(solution(board));
    }
    public static int solution(int[][] board) {
        answer = Integer.MAX_VALUE;
        m = board.length;
        n = board[0].length;
        ch = new int[m][n];
        dp = new int[m][n];
        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[i].length; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        ch[0][0] = 1;
        dp[0][0] = 0;
        dfs(board, 0, 1, 100, true);
        dfs(board, 1, 0, 100, false);

        return dp[m-1][n-1];
    }

    public static int solution_bfs(int[][] board) {
        Queue<Road> queue = new LinkedList<>();
        answer = Integer.MAX_VALUE;
        m = board.length;
        n = board[0].length;
        ch = new int[m][n];
        ch[0][0] = 1;
        queue.offer(new Road(0, 1, 100, ch, true));
        queue.offer(new Road(1, 0, 100, ch, false));

        while(!queue.isEmpty()){
            int len = queue.size();
            for(int i = 0; i < len; i++) {
                Road road = queue.poll();
                int[][] new_ch = new int[m][n];
                for(int j = 0; j < new_ch.length;j++){
                    System.arraycopy(road.ch[j], 0, new_ch[j], 0, road.ch[0].length);
                }
                new_ch[road.i][road.j] = 1;
                int amount = road.amount;
                if(road.i == m - 1 && road.j == n - 1) {
                    answer = Math.min(answer, amount);
                }else{
                    for(int[] dir : dirs) {
                        int newI = road.i + dir[0];
                        int newJ = road.j + dir[1];
                        if(amount > answer || newI < 0 || newJ < 0 || newI == m || newJ == n || new_ch[newI][newJ] == 1 || board[newI][newJ] == 1) continue;

                        boolean isNextWidth = dir[0] == 0;
                        int nextAmount = getNextAmount(amount, isNextWidth ,road.isWidth);
                        queue.offer(new Road(newI, newJ, nextAmount, new_ch, isNextWidth));
                    }
                }
            }
        }

        return answer;
    }

    public static void dfs(int[][] board, int i, int j, int amount, boolean isWidth){
        if(i < 0 || j < 0 || i == m || j ==n || dp[i][j] < amount || ch[i][j] == 1 || board[i][j] == 1) return;
        int orgDp = dp[i][j];
        dp[i][j] = amount;
        if(i == m - 1 && j == n - 1) return;
        // isWidth - null : 상관없음, true : 가로 , false : 세로
        for (int[] dir : dirs) {
            boolean isNextWidth = dir[0] == 0;
            int nextAmount = getNextAmount(amount, isNextWidth, isWidth);
            ch[i][j] = 1;
            dfs(board, i + dir[0], j + dir[1], nextAmount, isNextWidth);
            ch[i][j] = 0;
        }

    }

    public static int getNextAmount(int amount, boolean isNextWidth, boolean isWidth){
        if(isWidth == isNextWidth) return amount + 100;
        return amount + 600;
    }
}

class Road{
    int i,j;
    int amount;
    int[][] ch;
    boolean isWidth;
    Road(int i, int j, int amount, int[][] ch, boolean isWidth){
        this.i = i;
        this.j = j;
        this.amount = amount;
        this.ch = ch;
        this.isWidth = isWidth;
    }
}
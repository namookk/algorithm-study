package com.algorithm.programmers.y2021.m12.d24;

//https://programmers.co.kr/learn/courses/30/lessons/67259

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
public class Solution {
    static int answer;
    static int[][] ch;
    static int m,n;
    static int[][] dirs = {{1,0},{-1,0}, {0,1},{0,-1}}; // 세로 세로 가로 가로
    public static void main(String[] args) {
        int[][] board = {{0,0,0,0,0,0},{0,1,1,1,1,0},{0,0,1,0,0,0},{1,0,0,1,0,1},{0,1,0,0,0,1},{0,0,0,0,0,0}};
        int[][] board1 = {{0,0,0},{0,0,0},{0,0,0}};
        System.out.println(solution(board));
    }
    public static int solution(int[][] board) {
        answer = Integer.MAX_VALUE;
        m = board.length;
        n = board[0].length;
        ch = new int[m][n];
        ch[0][0] = 1;
        dfs(board, 0, 1, 100, true);
        dfs(board, 1, 0, 100, false);

        return answer;
    }

    public static void dfs(int[][] board, int i, int j, int amount, boolean isWidth){
        if(amount > answer || i < 0 || j < 0 || i == m || j ==n || ch[i][j] == 1 || board[i][j] == 1) return;
        if(i == m -1 && j == n - 1) {
            answer = Math.min(answer, amount);
        }else{
            // isWidth - null : 상관없음, true : 가로 , false : 세로
            for(int[] dir : dirs) {
                boolean isNextWidth = dir[0] == 0;
                int nextAmount = getNextAmount(isNextWidth ,isWidth);
                ch[i][j] = 1;
                dfs(board, i + dir[0] , j + dir[1], amount + nextAmount, isNextWidth);
                ch[i][j] = 0;
            }
        }
    }

    public static int getNextAmount(boolean isNextWidth, boolean isWidth){
        if(isWidth == isNextWidth) return 100;
        return 600;
    }
}

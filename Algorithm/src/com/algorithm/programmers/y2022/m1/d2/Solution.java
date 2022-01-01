package com.algorithm.programmers.y2022.m1.d2;

//https://programmers.co.kr/learn/courses/30/lessons/12905
//정확성  테스트
//    테스트 1 〉	통과 (0.05ms, 73.2MB)
//    테스트 2 〉	통과 (0.04ms, 71MB)
//    테스트 3 〉	통과 (0.05ms, 74.3MB)
//    테스트 4 〉	통과 (0.05ms, 76.4MB)
//    테스트 5 〉	통과 (0.04ms, 75.4MB)
//    테스트 6 〉	통과 (0.03ms, 77.2MB)
//    테스트 7 〉	통과 (0.05ms, 73MB)
//    테스트 8 〉	실패 (0.02ms, 76.6MB)
//    테스트 9 〉	통과 (0.03ms, 78.3MB)
//    테스트 10 〉	통과 (0.04ms, 74.6MB)
//    테스트 11 〉	통과 (0.06ms, 72.6MB)
//    테스트 12 〉	통과 (0.04ms, 72.6MB)
//    테스트 13 〉	통과 (0.03ms, 66.6MB)
//    테스트 14 〉	통과 (0.05ms, 74.2MB)
//    테스트 15 〉	통과 (0.04ms, 74MB)
//    테스트 16 〉	통과 (0.06ms, 75.5MB)
//    테스트 17 〉	통과 (0.05ms, 77MB)
//    테스트 18 〉	통과 (2.04ms, 78.3MB)
//    테스트 19 〉	통과 (1.76ms, 77.9MB)
//    효율성  테스트
//    테스트 1 〉	실패 (시간 초과)
//    테스트 2 〉	실패 (시간 초과)
//    테스트 3 〉	실패 (시간 초과)
public class Solution {
    static int startI, startJ;
    static int answer;
    static int m,n;
    public static void main(String[] args) {
        int[][] board = {{0,0,1,1},{1,1,1,1}};
        System.out.println(solution(board));
    }

    private static int solution(int[][] board){
        m = board.length;
        n = board[0].length;
        answer = 1;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 1) {
                    startI = i;
                    startJ = j;
                    dfs(board, answer);
                }
            }
        }
        return answer * answer;
    }

    private static void dfs(int[][] board, int length){
        if(startI + length - 1 >= m || startJ + length - 1 >= n) return;
        boolean flag = true;
        for(int i = startI; i < startI + length; i++){
            for(int j = startJ; j < startJ + length; j++){
                if(board[i][j] == 0) {
                    flag = false;
                    break;
                }
            }
        }

        if(flag){
            answer = Math.max(answer, length);
            dfs(board, length + 1);
        }
    }
}

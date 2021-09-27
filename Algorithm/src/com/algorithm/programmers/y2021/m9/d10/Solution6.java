package com.algorithm.programmers.y2021.m9.d10;

public class Solution6 {
    public static void main(String[] args) {
        int[][] board = {{5,5,5,5,5},{5,5,5,5,5},{5,5,5,5,5},{5,5,5,5,5}};
        int[][] skill = {{1,0,0,3,4,4},{1,2,0,2,3,2},{2,1,0,3,1,2},{1,0,1,3,3,1}};

        System.out.println(solution(board, skill));
    }

    public static int solution(int[][] board, int[][] skill) {
        int answer = 0;
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                int hp = board[i][j];
                for(int[] sk : skill) {
                    int degree = sk[0] == 1 ? sk[5] * -1 : sk[5];
                    if(i >= sk[1] && i <= sk[3] && j >= sk[2] && j <= sk[4]){
                        hp += degree;
                    }
                }
                if(hp > 0) answer++;
            }
        }

        return answer;
    }
}

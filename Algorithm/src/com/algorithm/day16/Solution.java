package com.algorithm.day16;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int[] moves = {1,5,3,5,1,2,1,4};

        System.out.println(solution(board, moves));
    }

    public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        List<Integer> result = new ArrayList<Integer>();

        for(int move : moves){
            for(int i = 0 ; i < board.length;i++){
                if(board[i][move-1] != 0){
                    result.add(board[i][move-1]);
                    int size = result.size();
                    if(size > 1 && result.get(size-1).intValue() == result.get(size-2).intValue()){
                        result.remove(size-1);
                        result.remove(size-2);
                        answer += 2;
                    }

                    board[i][move-1] = 0;
                    break;
                }
            }
        }
        return answer;
    }
}

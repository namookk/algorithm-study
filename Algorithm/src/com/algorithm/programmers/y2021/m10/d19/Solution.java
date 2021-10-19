package com.algorithm.programmers.y2021.m10.d19;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {
        int rows = 6;
        int columns = 6;
        int[][] queries = {{2,2,5,4},{3,3,6,6},{5,1,6,3}};

        for(int num : solution(rows, columns, queries)) {
            System.out.print(num + " ");
        }
    }
    public static int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] board = new int[rows+1][columns+1];
        int num = 0;
        for(int i = 1; i <= rows; i++) {
            for(int j = 1; j <= columns; j++) {
                board[i][j] = ++num;
            }
        }
        for(int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            Queue<Integer> queue = new LinkedList<>();
            int minRows = query[0];
            int maxRows = query[2];
            int minCols = query[1];
            int maxCols = query[3];

            int currRow = minRows;
            int currCols = minCols;
            String currDirection = "R";
            queue.offer(board[currRow][currCols]);
            board[currRow][currCols] = 0;
            int minNum = Integer.MAX_VALUE;

            while(!queue.isEmpty()) {
                num = queue.poll();
                if(currDirection.equals("R")) {
                    if(currCols < maxCols) currCols++;
                    else{
                        currRow++;
                        currDirection = "D";
                    }
                    queue.offer(board[currRow][currCols]);
                    board[currRow][currCols] = num;
                }else if(currDirection.equals("D")){
                    if(currRow < maxRows) currRow++;
                    else{
                        currCols--;
                        currDirection = "L";
                    }
                    queue.offer(board[currRow][currCols]);
                    board[currRow][currCols] = num;
                }else if(currDirection.equals("L")){
                    if(currCols > minCols) currCols--;
                    else{
                        currRow--;
                        currDirection = "U";
                    }
                    queue.offer(board[currRow][currCols]);
                    board[currRow][currCols] = num;
                }else if(currDirection.equals("U")){
                    if(currRow > minRows){
                        currRow--;
                        queue.offer(board[currRow][currCols]);
                        board[currRow][currCols] = num;
                    }else{
                        break;
                    }
                }
                minNum = Math.min(minNum, num);
            }
            answer[i] = minNum;
        }

        return answer;
    }
}

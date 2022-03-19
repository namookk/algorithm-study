package com.algorithm.programmers.y2022.m3.d19;

public class Solution3 {
    public static void main(String[] args) {
        String[][] grid = {{".....",".XXX.",".X.X.",".XXX.","....."},{"XXXXX","XXXXX","XXX.X","XXX.X","XXXXX"},{"XXXXX","X...X","X.X.X","X...X","XXXXX"},{"....X",".....","XXX..","X.X..","XXX.."},{".......","XXX.XXX","X.X.X.X","XXX.XXX","......."},{"XXXXX","XX.XX","X...X","XX.XX","XXXXX"}};
        boolean[] result = solution(grid);
        for(boolean value : result) System.out.print(value +" ");
    }

    private static boolean[] solution(String[][] grid) {
        boolean[] result = new boolean[grid.length];
        for(int i = 0; i < grid.length; i++) {
            result[i] = isSquare(grid[i]);
        }
        return result;
    }

    private static boolean isSquare(String[] grid) {
        int[][] ch = new int[grid.length][grid[0].length()];
        for(String gridStr : grid) {
            char[] arr = gridStr.toCharArray();
            for(int i = 0; i < arr.length; i++) {
                if(arr[i] == 'X') {

                }
            }
        }

        return false;
    }
}

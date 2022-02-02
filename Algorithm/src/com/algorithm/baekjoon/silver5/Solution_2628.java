package com.algorithm.baekjoon.silver5;

import java.util.*;

public class Solution_2628 {
    static int[][] ch;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int width = sc.nextInt();
        int height = sc.nextInt();
        ch = new int[height][width];

        int n = sc.nextInt();
        List<Integer> widthLine = new ArrayList<>();
        List<Integer> heightLine = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            int flag = sc.nextInt();
            int num = sc.nextInt();
            if(flag == 0) widthLine.add(num);
            else heightLine.add(num);
        }

        Collections.sort(widthLine);
        Collections.sort(heightLine);

        int answer = 0;
        for(int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){
                if(ch[i][j] == 0) {
                    int nextWidthLine = getNextLine(i, widthLine);
                    int nextHeightLine = getNextLine(j, heightLine);

                    int area = getArea(i, j, nextWidthLine == -1 ? height : nextWidthLine, nextHeightLine == -1 ? width : nextHeightLine);

                    answer = Math.max(answer, area);
                }
            }
        }

        System.out.println(answer);
    }

    private static int getArea(int i, int j, int nextWidthLine, int nextHeightLine){
        int area = 0;

        for(int row = i ; row < nextWidthLine; row++){
            for(int col = j ; col < nextHeightLine; col++){
                ch[row][col] = 1;
                area++;
            }
        }
        return area;
    }

    private static int getNextLine(int point, List<Integer> lineList){
        for(Integer line : lineList){
            if(line > point) return line;
        }
        return -1;
    }
}

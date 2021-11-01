package com.algorithm.programmers.y2021.m11.d1;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        int[][] line = {{2, -1, 4}, {-2, -1, 4}, {0, -1, 1}, {5, -8, -12}, {5, 8, 12}};
        for(String s : solution(line)){
            System.out.println(s);
        }
    }
    public static String[] solution(int[][] lines) {
        String[] answer = {};
        List<Point> pointList = new ArrayList<>();
        for(int i = 0; i < lines.length; i++) {
            double a1 = lines[i][0];
            double b1 = lines[i][1];
            double c1 = lines[i][2];
            for(int j = i + 1; j < lines.length; j++) {
                double a2 = lines[j][0];
                double b2 = lines[j][1];
                double c2 = lines[j][2];

                double x = (b1*c2 - b2*c1)/(a1*b2 - a2*b1);
                double y = -a1/b1*(b1*c2-b2*c1)/(a1*b2-a2*b1)-c1/b1;
                if((x == (int)x) && (y == (int)y)){
                    pointList.add(new Point((int)x, (int)y));
                }
            }
        }
        int minY = Integer.MAX_VALUE;
        int minX = Integer.MAX_VALUE;
        int maxY = Integer.MIN_VALUE;
        int maxX = Integer.MIN_VALUE;
        for(Point p : pointList){
            minY = Math.min(minY, p.y);
            minX = Math.min(minX, p.x);
            maxY = Math.max(maxY, p.y);
            maxX = Math.max(maxX, p.x);
        }
        int[][] cdn = new int[(maxY - minY)+1][(maxX - minX)+1];
        for(Point p : pointList){
        }
        System.out.println(minY + " , " + minX + " , " + maxY + " , " + maxX);

        return answer;
    }
}

class Point{
    int x,y;

    public Point(int _x, int _y){
        x = _x;
        y = _y;
    }
}

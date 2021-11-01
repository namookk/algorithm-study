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
        List<Point> pointList = new ArrayList<>();
        List<String> pointStrList = new ArrayList<>();
        long minY = Long.MAX_VALUE;
        long minX = Long.MAX_VALUE;
        long maxY = Long.MIN_VALUE;
        long maxX = Long.MIN_VALUE;

        for(int i = 0; i < lines.length - 1; i++) {
            long A = lines[i][0];
            long B = lines[i][1];
            long E = lines[i][2];
            for(int j = i + 1; j < lines.length; j++) {
                long C = lines[j][0];
                long D = lines[j][1];
                long F = lines[j][2];

                long division = (A*D - B*C);
                if(division == 0) continue;

                double x = (double)(B*F - E*D)/division;
                double y = (double)(E*C - A*F)/division;

                if((x - (long)x == 0) && (y - (long)y == 0)){
                    Point p = new Point((long)x, (long)y);

                    minY = Math.min(minY, p.y);
                    minX = Math.min(minX, p.x);
                    maxY = Math.max(maxY, p.y);
                    maxX = Math.max(maxX, p.x);

                    pointList.add(p);
                    pointStrList.add(p.x+","+p.y);
                }
            }
        }

        String[] answer = new String[(int)(maxY - minY + 1)];
        int i = 0;
        while(maxY >= minY) {
            long currX = minX;
            StringBuffer sb = new StringBuffer();
            while(currX <= maxX) {
                if(pointStrList.indexOf(currX+","+maxY) > -1) sb.append("*");
                else sb.append(".");
                currX++;
            }
            answer[i] = sb.toString();
            i++;
            maxY--;
        }

        return answer;
    }
}

class Point{
    long x,y;

    public Point(long _x, long _y){
        x = _x;
        y = _y;
    }

    public boolean isEqual(long _x, long _y){
        if(x == _x && y == _y) {
            return true;
        }
        return false;
    }
}

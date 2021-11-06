package com.algorithm.programmers.y2021.m11.d6;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {
        int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};

        System.out.println(solution(maps));
    }

    public static int solution(int[][] maps) {
        int answer = 0;
        int[][] ch = new int[5][5];
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(0, 0));
        int level = 1;
        ch[0][0] = 1;

        while(!queue.isEmpty()) {
            int len = queue.size();
            for(int i = 0; i < len; i++) {
                Point point = queue.poll();
                if(point.x == 4 && point.y == 4) return level;
                if(point.y < 4 && maps[point.y + 1][point.x] == 1 && ch[point.y +1][point.x] == 0) {
                    queue.offer(new Point(point.x, point.y + 1));
                    ch[point.y +1][point.x] = 1;
                }
                if(point.x < 4 && maps[point.y][point.x + 1] == 1  && ch[point.y][point.x + 1] == 0) {
                    queue.offer(new Point(point.x + 1, point.y));
                    ch[point.y][point.x + 1] = 1;
                }

                if(point.y > 0 && maps[point.y - 1][point.x] == 1 && ch[point.y - 1][point.x] == 0) {
                    queue.offer(new Point(point.x, point.y - 1));
                    ch[point.y - 1][point.x] = 1;
                }
                if(point.x > 0 && maps[point.y][point.x - 1] == 1  && ch[point.y][point.x - 1] == 0) {
                    queue.offer(new Point(point.x - 1, point.y));
                    ch[point.y][point.x - 1] = 1;
                }
            }
            level++;
        }

        return -1;
    }
}

class Point{
    int x,y;

    public Point(int _x, int _y) {
        x = _x;
        y = _y;
    }
}

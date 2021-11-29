package com.algorithm.inflearn.chapter8;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main8_10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] arr = new int[8][8];
        for(int i = 1; i < 8; i++) {
            for(int j = 1; j < 8; j++) {
               arr[i][j] = sc.nextInt();
            }
        }
        System.out.println(solution(arr));
    }

    public static int solution(int[][] arr) {
        int[][] ch = new int[8][8];
        int level = 0;
        Queue<Point2> queue = new LinkedList<>();
        queue.offer(new Point2(1,1));
        ch[1][1] = 1;
        while(!queue.isEmpty()) {
            int len = queue.size();
            for(int i = 0; i < len; i++) {
                Point2 p = queue.poll();
                if(p.x == 7 && p.y == 7) {
                    return level;
                }else {
                    if (p.x > 1 && arr[p.y][p.x - 1] == 0 && ch[p.y][p.x - 1] == 0) { //LEFT
                        ch[p.y][p.x - 1] = 1;
                        queue.offer(new Point2(p.x - 1, p.y));
                    }
                    if (p.x < 7 && arr[p.y][p.x + 1] == 0 && ch[p.y][p.x + 1] == 0) { //RIGHT
                        ch[p.y][p.x + 1] = 1;
                        queue.offer(new Point2(p.x + 1, p.y));
                    }
                    if (p.y > 1 && arr[p.y - 1][p.x] == 0 && ch[p.y - 1][p.x] == 0) { //UP
                        ch[p.y - 1][p.x] = 1;
                        queue.offer(new Point2(p.x, p.y - 1));
                    }
                    if (p.y < 7 && arr[p.y + 1][p.x] == 0 && ch[p.y + 1][p.x] == 0) { //DOWN
                        ch[p.y + 1][p.x] = 1;
                        queue.offer(new Point2(p.x, p.y + 1));
                    }
                }
            }
            level++;
        }

        return -1;
    }
}

class Point2{
    int x, y;
    public Point2(int _x, int _y) {
        x = _x;
        y = _y;
    }
}

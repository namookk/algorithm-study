package com.algorithm.inflearn.y2021.m11.d9;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main8_9 {
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
        int answer = 0;
        int[][] ch = new int[8][8];
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(1,1));
        ch[1][1] = 1;

        while(!queue.isEmpty()) {
            int len = queue.size();
            for(int i = 0; i < len; i++ ) {
                Point p = queue.poll();
                if(p.x == 7 && p.y == 7) {
                    answer++;
                    continue;
                }
                if(p.x > 1 && arr[p.y][p.x - 1] == 0 && ch[p.y][p.x - 1] == 0) {
                    queue.offer(new Point(p.x - 1, p.y));
                    ch[p.y][p.x - 1] = 1;
                }
                if(p.x < 7 && arr[p.y][p.x + 1] == 0 && ch[p.y][p.x + 1] == 0) {
                    queue.offer(new Point(p.x + 1, p.y));
                    ch[p.y][p.x + 1] = 1;
                }
                if(p.y > 1 && arr[p.y - 1][p.x] == 0 && ch[p.y - 1][p.x] == 0) {
                    queue.offer(new Point(p.x, p.y - 1));
                    ch[p.y - 1][p.x] = 1;
                }
                if(p.y < 7 && arr[p.y + 1][p.x] == 0 && ch[p.y + 1][p.x] == 0) {
                    queue.offer(new Point(p.x, p.y + 1));
                    ch[p.y + 1][p.x] = 1;
                }
            }
        }

        return answer;
    }

}

class Point{
    int x, y;
    public Point(int _x, int _y) {
        x = _x;
        y = _y;
    }
}

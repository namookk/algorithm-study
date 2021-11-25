package com.algorithm.inflearn.m11.d9;

import java.util.Scanner;

public class Main8_9 {
    static int[][] arr = new int[8][8];
    static int answer = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int i = 1; i < 8; i++) {
            for(int j = 1; j < 8; j++) {
               arr[i][j] = sc.nextInt();
            }
        }
        System.out.println(solution());
    }

    public static int solution() {
        int[][] ch = new int[8][8];
        ch[1][1] = 1;
        DFS(new Point(1,1), ch);
        return answer;
    }

    public static void DFS(Point p, int[][] ch) {
        if(p.x == 7 && p.y == 7) {
            answer++;
        }else {
            if (p.x > 1 && arr[p.y][p.x - 1] == 0 && ch[p.y][p.x - 1] == 0) { //LEFT
                ch[p.y][p.x - 1] = 1;
                DFS(new Point(p.x - 1, p.y), ch);
                ch[p.y][p.x - 1] = 0;
            }
            if (p.x < 7 && arr[p.y][p.x + 1] == 0 && ch[p.y][p.x + 1] == 0) { //RIGHT
                ch[p.y][p.x + 1] = 1;
                DFS(new Point(p.x + 1, p.y),ch);
                ch[p.y][p.x + 1] = 0;
            }
            if (p.y > 1 && arr[p.y - 1][p.x] == 0 && ch[p.y - 1][p.x] == 0) { //UP
                ch[p.y - 1][p.x] = 1;
                DFS(new Point(p.x, p.y - 1), ch);
                ch[p.y - 1][p.x] = 0;
            }
            if (p.y < 7 && arr[p.y + 1][p.x] == 0 && ch[p.y + 1][p.x] == 0) { //DOWN
                ch[p.y + 1][p.x] = 1;
                DFS(new Point(p.x, p.y + 1), ch);
                ch[p.y + 1][p.x] = 0;
            }
        }
    }
}

class Point{
    int x, y;
    public Point(int _x, int _y) {
        x = _x;
        y = _y;
    }
}

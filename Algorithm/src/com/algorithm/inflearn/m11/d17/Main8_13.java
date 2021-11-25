package com.algorithm.inflearn.m11.d17;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main8_13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        System.out.println(solution(arr));
    }

    public static int solution(int[][] arr) {
        int answer = Integer.MAX_VALUE;
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[i].length; j++) {
                int num = arr[i][j];
                if(num == 1) { //집일경우 최단배달거리 계산
                    Queue<Coordinates> queue = new LinkedList<>();
                    int[][] ch = new int[arr.length][arr[0].length];
                    ch[i][j] = 1;
                    queue.offer(new Coordinates(j, i));
                    int dist = 0;
                    while(!queue.isEmpty()) {
                        int len = queue.size();
                        boolean finish = false;
                        for(int k = 0; k < len; k++) {
                            Coordinates cd = queue.poll();
                            if(arr[cd.y][cd.x] == 2) {
                                queue = new LinkedList<>();
                                finish = true;
                                break;
                            }else {
                                if (cd.x > 0 && ch[cd.y][cd.x - 1] == 0) { //LEFT
                                    ch[cd.y][cd.x - 1] = 1;
                                    queue.offer(new Coordinates(cd.x - 1, cd.y));
                                }
                                if (cd.x < (ch[0].length - 1) && ch[cd.y][cd.x + 1] == 0) { //RIGHT
                                    ch[cd.y][cd.x + 1] = 1;
                                    queue.offer(new Coordinates(cd.x + 1, cd.y));
                                }
                                if (cd.y > 0 && ch[cd.y - 1][cd.x] == 0) { //UP
                                    ch[cd.y - 1][cd.x] = 1;
                                    queue.offer(new Coordinates(cd.x, cd.y - 1));
                                }
                                if (cd.y < (ch.length - 1) && ch[cd.y + 1][cd.x] == 0) { //DOWN
                                    ch[cd.y + 1][cd.x] = 1;
                                    queue.offer(new Coordinates(cd.x, cd.y + 1));
                                }
                            }
                        }
                        if(!finish) dist++;
                    }
                    answer = Math.min(answer, dist);
                }
            }
        }

        return answer;
    }
}

class Coordinates{
    int x, y;
    public Coordinates(int _x, int _y) {
        x = _x;
        y = _y;
    }
}

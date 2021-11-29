package com.algorithm.inflearn.chapter8;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main8_11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[][] arr = new int[k][n];
        int count = 0;
        for(int i = 0; i < k; i++) {
            for(int j =0; j < n; j++) {
                arr[i][j] = sc.nextInt();
                if(arr[i][j] == 0) count++;
            }
        }
        System.out.println(solution(arr, count));
    }

    public static int solution(int[][] arr, int count) {
        int day = 0;
        if(count == 0) return day;
        Queue<Farm> queue = new LinkedList<>();
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[i].length; j++) {
                if(arr[i][j] == 1) queue.offer(new Farm(j, i));
            }
        }

        while(!queue.isEmpty()){
            if(count == 0) return day;
            int len = queue.size();
            for(int i = 0; i < len; i++) {
                Farm f = queue.poll();
                if (f.x > 0 && arr[f.y][f.x - 1] == 0) { //LEFT
                    arr[f.y][f.x - 1] = 1;
                    queue.offer(new Farm(f.x - 1, f.y));
                    count--;
                }
                if (f.x < (arr[0].length - 1) && arr[f.y][f.x + 1] == 0) { //RIGHT
                    arr[f.y][f.x + 1] = 1;
                    queue.offer(new Farm(f.x + 1, f.y));
                    count--;
                }
                if (f.y > 0 && arr[f.y - 1][f.x] == 0) { //UP
                    arr[f.y - 1][f.x] = 1;
                    queue.offer(new Farm(f.x, f.y - 1));
                    count--;
                }
                if (f.y < (arr.length - 1) && arr[f.y + 1][f.x] == 0) { //DOWN
                    arr[f.y + 1][f.x] = 1;
                    queue.offer(new Farm(f.x, f.y + 1));
                    count--;
                }
            }
            day++;
        }
        return -1;
    }
}

class Farm{
    int x,y;
    public Farm(int _x, int _y) {
        x = _x;
        y = _y;
    }
}


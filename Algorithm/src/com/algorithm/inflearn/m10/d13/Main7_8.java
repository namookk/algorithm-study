package com.algorithm.inflearn.m10.d13;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main7_8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        System.out.println(solution(n, k));
    }

    public static int solution(int n, int k) {
        int[] visitfl = new int[10001];
        Queue<Integer> queue = new LinkedList<>();
        int[] ds = {-1, 1, 5};
        int level = 0;
        queue.offer(n);
        while(!queue.isEmpty()) {
            int len = queue.size();
            for(int i = 0 ; i < len; i++) {
                int x = queue.poll();
                if(x == k) return level;
                for(int j = 0; j < 3; j++) {
                    int nx = x + ds[j];
                    if(nx > 0 && nx < 10001 && visitfl[nx] == 0) {
                        visitfl[nx] = 1;
                        queue.offer(nx);
                    }
                }
            }
            level++;
        }
        return 0;
    }
}

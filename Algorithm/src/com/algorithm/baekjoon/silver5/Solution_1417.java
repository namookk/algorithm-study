package com.algorithm.baekjoon.silver5;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution_1417 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int mine = sc.nextInt();
        int level = 0;
        if(n > 1) {
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            for (int i = 0; i < n - 1; i++) {
                pq.offer(sc.nextInt());
            }
            while (mine <= pq.peek()) {
                pq.offer(pq.poll() - 1);
                mine++;
                level++;
            }
        }
        System.out.println(level);
    }
}

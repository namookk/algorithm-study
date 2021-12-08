package com.algorithm.inflearn2.chapter2;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main2_5 {
    public static void main(String[] args) {
        int[][] intervals = {{5,10},{16,20},{0,30}};
        int[][] intervals2 = {{6,10},{1,3}};

        System.out.println(solve(intervals));
        System.out.println(solve(intervals2));
    }

    public static int solve(int[][] intervals){
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        Queue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);

        for(int[] arr : intervals) {
            if(pq.isEmpty()) pq.offer(arr);
            else{
                if(pq.peek()[1] <= arr[0]) {
                    pq.poll();
                }
                pq.offer(arr);
            }
        }

        return pq.size();
    }
}

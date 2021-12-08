package com.algorithm.inflearn2.chapter2;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main2_6 {
    public static void main(String[] args) {
        int[][] intervals = {{1,4},{2,6},{8,10},{15,18}};
        int[][] intervals2 = {{1,5},{5,6}};
        for(int[] arr : solve(intervals)) {
            for(int i : arr) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
        for(int[] arr : solve(intervals2)) {
            for(int i : arr) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public static int[][] solve(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        Queue<int[]> pq = new PriorityQueue<>((a,b) -> b[1] - a[1]);
        for(int[] arr : intervals) {
            if(pq.isEmpty()) pq.offer(arr);
            else{
                if(pq.peek()[1] >= arr[0]){
                    int[] pqarr = pq.poll();
                    pqarr[1] = arr[1];
                    pq.offer(pqarr);
                }else{
                    pq.offer(arr);
                }
            }
        }
        int[][] answer = new int[pq.size()][2];
        int idx = answer.length - 1;
        while(!pq.isEmpty()){
            answer[idx] = pq.poll();
            idx--;
        }
        return answer;
    }
}

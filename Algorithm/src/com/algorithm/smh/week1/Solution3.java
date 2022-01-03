package com.algorithm.smh.week1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;


//https://leetcode.com/problems/merge-intervals/
//Success
//    Details
//    Runtime: 9 ms, faster than 22.79% of Java online submissions for Merge Intervals.
//    Memory Usage: 43.2 MB, less than 20.55% of Java online submissions for Merge Intervals.
public class Solution3 {
    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        for(int[] arr : solution(intervals)){
            System.out.println(arr[0] +", " + arr[1]);
        }
    }

    private static int[][] solution(int[][] intervals){
        int[][] answer;
        Arrays.sort(intervals, (a,b)->{
            return a[0] - b[0];
        });
        List<int[]> list = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);

        for(int[] interval : intervals){
            if(pq.isEmpty()) pq.offer(interval);
            else{
                int[] prev = pq.poll();
                if(prev[1] >= interval[0]) {
                    prev[1] = Math.max(prev[1],interval[1]);
                    pq.offer(prev);
                }else{
                    list.add(prev);
                    pq.offer(interval);
                }
            }
        }
        if(!pq.isEmpty()) list.add(pq.poll());
        answer = new int[list.size()][2];
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}

package com.algorithm.inflearn2.chapter2;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main2_2 {
    public static void main(String[] args) {
        int[] nums = {3,2,3,1,2,4,5,5,6};
        int k = 4;

        int[] nums2 =  {2,3,1,5,6,4};
        int k2 = 2;
        System.out.println(solve(nums, k));
        System.out.println(solve(nums2, k2));
        System.out.println(solve_pq(nums, k));
        System.out.println(solve_pq(nums2, k2));
    }

    public static int solve(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    public static int solve_pq(int[] nums, int k) {
        Queue<Integer> pq = new PriorityQueue<>(); // asc minheap

        //2,3,1,5,6,4

        // 2 {2}
        // 3 {2,3}
        // 1 {2,3}
        // 5 {3,5}
        // 6 {5,6}
        // 4 {5,6}

        for(int i : nums) {
            pq.offer(i);
            if(pq.size() > k) pq.poll();
        }
        return pq.peek();
    }
}

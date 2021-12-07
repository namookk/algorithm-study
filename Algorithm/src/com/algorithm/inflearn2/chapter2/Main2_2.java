package com.algorithm.inflearn2.chapter2;

import java.util.Arrays;

public class Main2_2 {
    public static void main(String[] args) {
        int[] nums = {3,2,3,1,2,4,5,5,6};
        int k = 4;

        int[] nums2 =  {2,3,1,5,6,4};
        int k2 = 2;
        System.out.println(solve(nums, k));
        System.out.println(solve(nums2, k2));
    }

    public static int solve(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}

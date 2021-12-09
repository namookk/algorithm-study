package com.algorithm.inflearn2.chapter3;

public class Main3_3 {
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int[] nums2 = {5,4,-1,7,8};

        System.out.println(solve(nums));
        System.out.println(solve(nums2));
    }

    public static int solve(int[] nums) {
        int currMax = nums[0];
        int allMax = nums[0];
        for(int i = 1; i < nums.length; i++) {
            currMax = Math.max(nums[i], nums[i] + currMax);
            allMax = Math.max(allMax, currMax);
        }
        return allMax;
    }
}


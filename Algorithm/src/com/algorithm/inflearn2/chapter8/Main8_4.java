package com.algorithm.inflearn2.chapter8;

public class Main8_4 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,2,6,10,4,12};
        int[] nums2 = {0,1,0,3,2,3};
        System.out.println(solve(nums));
        System.out.println(solve(nums2));
    }

    public static int solve(int[] nums) {
        int[] dy = new int[nums.length + 1];
        int[] maxarr = new int[nums.length + 1];
        dy[0] = 0;
        maxarr[0] = -1;

        for(int i = 1; i <= nums.length; i++) {
            if(maxarr[i-1] < nums[i-1]){
                dy[i] = dy[i-1] + 1;
                maxarr[i] = nums[i-1];
            }else{
                dy[i] = dy[i-1];
                maxarr[i] = maxarr[i-1];
            }
            System.out.println(dy[i] +" , " + maxarr[i]);
        }
        return dy[nums.length];
    }
}

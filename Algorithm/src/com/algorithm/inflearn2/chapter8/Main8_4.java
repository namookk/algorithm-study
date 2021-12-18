package com.algorithm.inflearn2.chapter8;

public class Main8_4 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,2,6,10,4,12};
        int[] nums2 = {0,1,0,3,2,3};
        System.out.println(re_solve(nums));
        System.out.println(re_solve(nums2));
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
        }
        return dy[nums.length];
    }

    public static int re_solve(int[] nums) {
        int n = nums.length;
        int[] dy = new int[n];
        dy[0] = 1;
        int max = 1;
        for(int i = 1; i < n; i++) {
            dy[i] = 1;
            for(int j = 0; j < i; j++) {
                if(nums[j] < nums[i]) {
                    dy[i] = Math.max(dy[i], dy[j] + 1);
                }
            }
            max = Math.max(max, dy[i]);
        }

        return max;
    }
}

package com.algorithm.smh.week1;

public class Solution5 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        int k = 3;

        for(int i : solution(nums, k)) System.out.print( i + " ");
    }

    private static int[] solution(int[] nums, int k){

        while(k > 0){
            int num = nums[nums.length - 1];
            for(int i = nums.length - 1; i > 0; i--){
                nums[i] = nums[i-1];
            }
            nums[0] = num;
            k--;
        }

        return nums;
    }
}

package com.algorithm.inflearn2.chapter3;

import java.util.ArrayList;
import java.util.List;

public class Main3_6 {

    public static void main(String[] args) {
        int[] nums = {2,3,5,50,75,98};
        int lower = 0;
        int upper = 99;

        solve(nums, lower, upper);

        System.out.println(re_solve(nums, lower, upper));
    }

    public static void solve(int[] nums, int lower, int upper) {
        int[] arr = new int[upper];
        int prev = lower - 1;
        for(int num : nums) {
           if(num > prev + 1) {
               if(num - 1 == prev + 1){
                   System.out.println(prev + 1);
               }else{
                   System.out.println((prev+1) + " > " + (num - 1));
               }
           }
           prev = num;
        }
        if(prev < upper) {
            if(prev + 1 == upper) System.out.println(upper);
            else System.out.println((prev+1) + " > " + upper);
        }
    }

    public static List<String> re_solve(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<>();
        if(nums == null || nums.length == 0) return result;

        if(lower < nums[0]){
            result.add(makeRange(lower, nums[0]-1));
        }
        for(int i = 0; i < nums.length - 1; i++) {
            if(nums[i] != nums[i+1] && nums[i] + 1 < nums[i+1]) {
                result.add(makeRange(nums[i] + 1, nums[i+1] - 1));
            }
        }
        if(nums[nums.length - 1] < upper) {
           result.add(makeRange(nums[nums.length - 1] + 1, upper));
        }
        return result;
    }

    private static String makeRange(int low, int high) {
        return low == high ? String.valueOf(low) : (low + "->" + high);
    }
}

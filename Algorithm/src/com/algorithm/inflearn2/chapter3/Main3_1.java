package com.algorithm.inflearn2.chapter3;

import java.util.HashMap;
import java.util.Map;

public class Main3_1 {
    public static void main(String[] args) {
        int[] nums = {2, 8, 11, 14};
        int target = 16;

        for(int i : solve(nums, target)) System.out.print( i + " ");
        System.out.println();
        for(int i : re_solve(nums, target)) System.out.print( i + " ");
    }

    //Worst Case O(n^2)
    public static int[] solve(int[] nums, int target) {
        int lt = 0;
        int rt = 1;
        while(nums[lt] + nums[rt] != target) {
            if(rt == nums.length - 1) {
                lt++;
                rt = lt + 1;
            }else{
                rt++;
            }
        }
        int[] answer = new int[]{lt+1, rt+1};
        return answer;
    }

    //O(n)
    public static int[] re_solve(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])){
                int idx = map.get(nums[i]);
                result[0] = idx + 1;
                result[1] = i + 1;
            }else{
                map.put(target - nums[i], i);
            }
        }
        return result;
    }
}

package com.algorithm.inflearn2.chapter9;

import java.util.ArrayList;
import java.util.List;

public class Main9_2 {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(solve_dfs(nums));
    }

    public static List<List<Integer>> solve_dfs(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        if(nums == null || nums.length == 0) return result;

        dfs(nums, result, list);

        return result;
    }

    public static void dfs(int[] nums, List<List<Integer>> result, List<Integer> list) {
        //1. 담는것
        if(list.size() == nums.length) {
            List<Integer> new_list = new ArrayList<>(list);
            result.add(new_list);
        }

        //2. for 탈출
        for(int i = 0; i < nums.length; i++) {
            //if(list.size() == nums.length) continue;
            if(list.contains(nums[i])) continue;
            list.add(nums[i]);
            dfs(nums, result, list);
            list.remove(list.size() - 1);
        }
    }
}

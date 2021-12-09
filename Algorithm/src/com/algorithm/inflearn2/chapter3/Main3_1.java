package com.algorithm.inflearn2.chapter3;

public class Main3_1 {
    public static void main(String[] args) {
        int[] nums = {2, 8, 11, 14};
        int target = 16;

        for(int i : solve(nums, target)) System.out.print( i + " ");
    }

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

        int[] answer = new int[2];
        answer[0] = lt + 1;
        answer[1] = rt + 1;

        return answer;
    }
}

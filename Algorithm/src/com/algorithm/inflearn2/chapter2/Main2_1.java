package com.algorithm.inflearn2.chapter2;

public class Main2_1 {
    public static void main(String[] args) {
        int[] nums = {0,3,2,0,8,5};
        for(int i : solve(nums)) System.out.print(i + " ");
        System.out.println();
        for(int i : solve2(nums)) System.out.print(i + " ");
    }

    public static int[] solve(int[] nums) {
        int[] answer = new int[nums.length];
        int idx = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) {
                answer[idx] = nums[i];
                idx++;
            }
        }
        return answer;
    }

    public static int[] solve2(int[] nums) {
        int n = nums.length;
        int index = 0;
        for(int i = 0; i < n; i++) {
            if(nums[i] != 0) {
                nums[index] = nums[i];
                index++;
            }
        }
        while(index < n) {
            nums[index] = 0;
            index++;
        }

        return nums;
    }
}

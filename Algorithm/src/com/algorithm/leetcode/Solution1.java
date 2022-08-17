package com.algorithm.leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution1 {

  public static void main(String[] args) {
    int[] nums = {3, 2, 4};
    int target = 6;

    int[] result = solution(nums, target);
    System.out.println(result[0] + ", " + result[1]);
  }

  private static int[] solution(int[] nums, int target) {
    int[] answer = {};
    List<Integer> numList = Arrays.stream(nums).boxed().collect(Collectors.toList());
    for(int i = 0; i < nums.length / 2 + 1; i++) {
      int idx = numList.indexOf(target - nums[i]);
      if(idx > -1 && idx > i) {
        return new int[]{i, idx};
      }
    }

    return answer;
  }

}

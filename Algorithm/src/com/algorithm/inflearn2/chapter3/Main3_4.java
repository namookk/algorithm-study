package com.algorithm.inflearn2.chapter3;

public class Main3_4 {
    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(solve(height));
    }

    public static int solve(int[] height) {
        int answer = 0;
        int leftMax = 0;
        for(int i = 0; i < height.length - 1; i++) {
            int curr = height[i];
            if(leftMax > curr) {
                int rightMax = Math.max(height[i+1], curr);

                for(int j = i+1; j < height.length; j++) {
                    rightMax = Math.max(rightMax, height[j]);
                }
                answer += Math.min(rightMax, leftMax) - curr;
            }
            leftMax = Math.max(leftMax, curr);
        }

        return answer;
    }
}

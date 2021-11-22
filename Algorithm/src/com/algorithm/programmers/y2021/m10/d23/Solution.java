package com.algorithm.programmers.y2021.m10.d23;

import java.util.Arrays;

//https://programmers.co.kr/learn/courses/30/lessons/42842
public class Solution {
    public static void main(String[] args) {
        int brown = 24;
        int yellow = 24;

        System.out.println(Arrays.toString(solution(brown, yellow)));
    }
    public static int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int sum = brown + yellow;
        for(int i = 3; i < (sum/2 + 1); i++) {
            if(sum % i == 0) {
                int width = Math.max(i, sum/i);
                int height = Math.min(i, sum/i);
                if(brown == (width * 2 - 1) + (height * 2 - 3)) {
                    answer[0] = width;
                    answer[1] = height;
                    break;
                }
            }
        }

        return answer;
    }
}

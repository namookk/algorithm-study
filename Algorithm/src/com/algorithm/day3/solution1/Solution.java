package com.algorithm.day3.solution1;

public class Solution {
    public static void main(String[] args) {
        int[] absolutes = {};
        boolean[] signs = {};

        System.out.println(solution(absolutes, signs));
    }
    public static int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        int len = absolutes.length;
        for(int i = 0; i < len; i++){
            answer += signs[i] ? absolutes[i] : absolutes[i] * -1;
        }

        return answer;
    }
}

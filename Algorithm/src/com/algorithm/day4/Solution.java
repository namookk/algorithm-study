package com.algorithm.day4;

public class Solution {
    public static void main(String[] args) {
        int left = 13;
        int right = 17;

        System.out.println(solution(left, right));
    }
    public static int solution(int left, int right) {
        int answer = 0;
        while(left <= right){
            int cnt = 0;
            for (int i = 1; i * i <= left; i++) {
                if (left % i == 0) {
                    cnt++;
                    if (i * i < left) {
                        cnt++;
                    }
                }
            }

            if(cnt % 2 == 0) answer += left;
            if(cnt % 2 == 1) answer -= left;
            left++;
        }
        return answer;
    }
}

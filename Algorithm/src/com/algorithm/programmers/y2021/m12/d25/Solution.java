package com.algorithm.programmers.y2021.m12.d25;

//https://programmers.co.kr/learn/courses/30/lessons/12900
//정확성  테스트
//    테스트 1 〉	통과 (0.21ms, 75.7MB)
//    테스트 2 〉	통과 (0.08ms, 79.6MB)
//    테스트 3 〉	통과 (0.15ms, 76.7MB)
//    테스트 4 〉	통과 (0.24ms, 65.4MB)
//    테스트 5 〉	통과 (0.06ms, 69.3MB)
//    테스트 6 〉	통과 (0.35ms, 82.9MB)
//    테스트 7 〉	통과 (0.05ms, 77.2MB)
//    테스트 8 〉	통과 (0.17ms, 76.1MB)
//    테스트 9 〉	통과 (0.16ms, 74.2MB)
//    테스트 10 〉	통과 (0.26ms, 71.6MB)
//    테스트 11 〉	통과 (0.13ms, 74.6MB)
//    테스트 12 〉	통과 (0.05ms, 79MB)
//    테스트 13 〉	통과 (0.07ms, 74MB)
//    테스트 14 〉	통과 (0.13ms, 78.5MB)
//    효율성  테스트
//    테스트 1 〉	통과 (0.78ms, 52.3MB)
//    테스트 2 〉	통과 (1.33ms, 52.3MB)
//    테스트 3 〉	통과 (0.63ms, 52.5MB)
//    테스트 4 〉	통과 (0.64ms, 52.1MB)
//    테스트 5 〉	통과 (1.52ms, 53.1MB)
//    테스트 6 〉	통과 (1.53ms, 52.7MB)
public class Solution {
    public static void main(String[] args) {
        int n = 60000;
        System.out.println(solution(n));
    }

    public static int solution(int n) {
        if(n < 3) return n;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i <= n; i++) {
            dp[i] = (dp[i-2] + dp[i - 1]) % 1000000007;
        }

        return dp[n];
    }
}


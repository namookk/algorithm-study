package com.algorithm.programmers.y2021.m12.d28;

//https://programmers.co.kr/learn/courses/30/lessons/64062
//정확성  테스트
//    테스트 1 〉	통과 (0.02ms, 71.6MB)
//    테스트 2 〉	통과 (0.03ms, 77.1MB)
//    테스트 3 〉	통과 (0.02ms, 73.3MB)
//    테스트 4 〉	통과 (0.03ms, 69.9MB)
//    테스트 5 〉	통과 (0.04ms, 76.1MB)
//    테스트 6 〉	통과 (0.11ms, 87.1MB)
//    테스트 7 〉	통과 (0.15ms, 72MB)
//    테스트 8 〉	통과 (0.14ms, 74.3MB)
//    테스트 9 〉	통과 (0.15ms, 76.7MB)
//    테스트 10 〉	통과 (0.03ms, 72.9MB)
//    테스트 11 〉	통과 (0.02ms, 75.5MB)
//    테스트 12 〉	통과 (0.11ms, 83.3MB)
//    테스트 13 〉	통과 (0.03ms, 76.8MB)
//    테스트 14 〉	통과 (0.08ms, 73MB)
//    테스트 15 〉	통과 (0.14ms, 75.8MB)
//    테스트 16 〉	통과 (0.20ms, 71.4MB)
//    테스트 17 〉	통과 (0.12ms, 70MB)
//    테스트 18 〉	통과 (0.02ms, 72.1MB)
//    테스트 19 〉	통과 (0.03ms, 64.5MB)
//    테스트 20 〉	통과 (0.04ms, 78.7MB)
//    테스트 21 〉	통과 (0.09ms, 75.4MB)
//    테스트 22 〉	통과 (0.14ms, 76.8MB)
//    테스트 23 〉	통과 (0.18ms, 74MB)
//    테스트 24 〉	통과 (0.22ms, 81.6MB)
//    테스트 25 〉	통과 (0.03ms, 71.8MB)
//    효율성  테스트
//    테스트 1 〉	통과 (13.35ms, 62MB)
//    테스트 2 〉	통과 (13.31ms, 61.6MB)
//    테스트 3 〉	통과 (13.32ms, 61.8MB)
//    테스트 4 〉	통과 (14.05ms, 61.9MB)
//    테스트 5 〉	통과 (18.82ms, 62.2MB)
//    테스트 6 〉	통과 (17.23ms, 61.9MB)
//    테스트 7 〉	통과 (10.57ms, 61.2MB)
//    테스트 8 〉	통과 (9.40ms, 61.9MB)
//    테스트 9 〉	통과 (13.40ms, 61.5MB)
//    테스트 10 〉	통과 (7.90ms, 61.7MB)
//    테스트 11 〉	통과 (10.45ms, 69.3MB)
//    테스트 12 〉	통과 (6.22ms, 61.9MB)
//    테스트 13 〉	실패 (시간 초과)
//    테스트 14 〉	실패 (시간 초과)
public class Solution {
    public static void main(String[] args) {
        int[] stones = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
        int k = 3;
        System.out.println(solution(stones, k));
    }

    public static int solution(int[] stones, int k) {
        int answer = Integer.MAX_VALUE;
        int start = 0;
        int end = k - 1;
        int prevMax = 0;
        while(end < stones.length){
            int max = 0;
            if(start - 1 >= 0 && stones[start - 1] < prevMax && stones[end] <= prevMax){
                max = prevMax;
            }else {
                for (int i = start; i <= end; i++) {
                    max = Math.max(max, stones[i]);
                }
            }
            answer = Math.min(answer, max);
            prevMax = max;
            start++;
            end++;
        }

        return answer;
    }
}

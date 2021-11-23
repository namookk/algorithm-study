package com.algorithm.programmers.y2021.m10.d29;

//https://programmers.co.kr/learn/courses/30/lessons/12924
public class Solution2 {
    public static void main(String[] args) {
        int n = 15;
        System.out.println(solution(n));
    }

    public static int solution(int n) {
        int answer = 0;
        for(int i = 1; i < Math.ceil((double)n / 2); i++){
            int sum = 0;
            for(int j = i; j <= Math.ceil((double)n / 2); j++){
                sum += j;
                if(sum >= n) {
                    if(sum == n) answer++;
                    break;
                }
            }
        }
        return answer + 1;
    }
}

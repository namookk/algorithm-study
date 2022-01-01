package com.algorithm.programmers.y2022.m1.d1;

//https://programmers.co.kr/learn/courses/30/lessons/12945
//정확성  테스트
//    테스트 1 〉	통과 (0.07ms, 75.9MB)
//    테스트 2 〉	통과 (0.09ms, 72.5MB)
//    테스트 3 〉	통과 (0.07ms, 76.9MB)
//    테스트 4 〉	통과 (0.09ms, 80.4MB)
//    테스트 5 〉	통과 (0.08ms, 77.6MB)
//    테스트 6 〉	통과 (0.08ms, 74.3MB)
//    테스트 7 〉	통과 (0.47ms, 77.8MB)
//    테스트 8 〉	통과 (0.38ms, 78.5MB)
//    테스트 9 〉	통과 (0.31ms, 79.2MB)
//    테스트 10 〉	통과 (0.49ms, 76.5MB)
//    테스트 11 〉	통과 (0.39ms, 74.6MB)
//    테스트 12 〉	통과 (0.38ms, 69MB)
//    테스트 13 〉	통과 (8.39ms, 78.3MB)
//    테스트 14 〉	통과 (10.03ms, 78.8MB)
public class Solution4 {
    public static void main(String[] args) {
        int n = 100;
        System.out.println(solution(n));
    }
    private static Long solution(int n){
        if(n < 3) return 1L;
        Long[] dy = new Long[n+1];
        dy[1] = 1L;
        dy[2] = 1L;

        final Long MOD = 1234567L;
        for(int i = 3; i <= n; i++){
            dy[i] = (dy[i-2] + dy[i-1]) % MOD;
        }
        return dy[n];
    }
}

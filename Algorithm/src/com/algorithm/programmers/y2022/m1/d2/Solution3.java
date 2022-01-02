package com.algorithm.programmers.y2022.m1.d2;

//https://programmers.co.kr/learn/courses/30/lessons/62048
//정확성  테스트
//    테스트 1 〉	통과 (0.03ms, 74.4MB)
//    테스트 2 〉	통과 (0.03ms, 69.6MB)
//    테스트 3 〉	통과 (0.03ms, 66.6MB)
//    테스트 4 〉	통과 (0.02ms, 76.3MB)
//    테스트 5 〉	통과 (0.02ms, 78.1MB)
//    테스트 6 〉	통과 (0.02ms, 69.8MB)
//    테스트 7 〉	통과 (0.02ms, 73.3MB)
//    테스트 8 〉	통과 (0.02ms, 77.4MB)
//    테스트 9 〉	통과 (0.02ms, 76.6MB)
//    테스트 10 〉	통과 (0.02ms, 77.6MB)
//    테스트 11 〉	통과 (0.02ms, 72.2MB)
//    테스트 12 〉	통과 (0.05ms, 70.1MB)
//    테스트 13 〉	통과 (0.04ms, 71.2MB)
//    테스트 14 〉	통과 (0.02ms, 73.5MB)
//    테스트 15 〉	통과 (0.02ms, 74.5MB)
//    테스트 16 〉	통과 (0.03ms, 72.5MB)
//    테스트 17 〉	통과 (0.03ms, 77MB)
//    테스트 18 〉	통과 (0.02ms, 74.3MB)
public class Solution3 {
    public static void main(String[] args) {
        int w = 8;
        int h = 12;

        System.out.println(solution(w, h));
    }

    private static long solution(int w, int h){
        long gcd = gcd(w, h);
        return ((long)w * (long)h) - (w + h - gcd);
    }

    private static long gcd(int a, int b){
        if(b == 0) return a;
        else return gcd(b, a%b);
    }
}

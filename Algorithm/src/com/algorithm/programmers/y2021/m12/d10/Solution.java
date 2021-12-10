package com.algorithm.programmers.y2021.m12.d10;

//https://programmers.co.kr/learn/courses/30/lessons/87390
/*
정확성  테스트
테스트 1 〉	통과 (3.46ms, 113MB)
테스트 2 〉	통과 (19.02ms, 116MB)
테스트 3 〉	통과 (10.94ms, 117MB)
테스트 4 〉	통과 (0.02ms, 83.6MB)
테스트 5 〉	통과 (0.02ms, 72.6MB)
테스트 6 〉	통과 (3.28ms, 109MB)
테스트 7 〉	통과 (3.36ms, 110MB)
테스트 8 〉	통과 (3.53ms, 92.9MB)
테스트 9 〉	통과 (3.33ms, 95.1MB)
테스트 10 〉	통과 (3.41ms, 108MB)
테스트 11 〉	통과 (3.30ms, 113MB)
테스트 12 〉	통과 (3.91ms, 107MB)
테스트 13 〉	통과 (3.69ms, 111MB)
테스트 14 〉	통과 (3.64ms, 106MB)
테스트 15 〉	통과 (9.36ms, 105MB)
테스트 16 〉	통과 (9.64ms, 114MB)
테스트 17 〉	통과 (10.68ms, 112MB)
테스트 18 〉	통과 (17.19ms, 110MB)
테스트 19 〉	통과 (17.59ms, 117MB)
테스트 20 〉	통과 (16.89ms, 94.5MB)
*/
public class Solution {
    public static void main(String[] args) {
        int n = 3;
        int left = 2;
        int right = 5;

        for(int i : solution(n, left, right)) {
            System.out.print(i + " ");
        }
    }

    public static int[] solution(int n, long left, long right) {
        int[] answer = new int[(int)(right - left + 1)];

        int answerIdx = 0;
        for(long i = left / n; i <= right/n; i++ ) {
            long idx = i * n;
            long val = i + 1;
            for(long j = 1; j <= n; j++) {
                if(j > val) val++;
                if(idx >= left && idx <= right) {
                    answer[answerIdx] = (int)val;
                    answerIdx++;
                }
                idx++;
            }
        }

        return answer;
    }
}

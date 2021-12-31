package com.algorithm.programmers.y2021.m12.d31;

import java.util.Collections;
import java.util.PriorityQueue;

//https://programmers.co.kr/learn/courses/30/lessons/12927
//정확성  테스트
//    테스트 1 〉	통과 (0.53ms, 76.8MB)
//    테스트 2 〉	통과 (0.48ms, 74.6MB)
//    테스트 3 〉	통과 (0.44ms, 74.3MB)
//    테스트 4 〉	통과 (0.49ms, 76.9MB)
//    테스트 5 〉	통과 (0.42ms, 76.9MB)
//    테스트 6 〉	통과 (0.48ms, 76MB)
//    테스트 7 〉	통과 (0.43ms, 78.6MB)
//    테스트 8 〉	통과 (2.27ms, 74.8MB)
//    테스트 9 〉	통과 (2.24ms, 80.5MB)
//    테스트 10 〉	통과 (0.41ms, 74.3MB)
//    테스트 11 〉	통과 (0.44ms, 73MB)
//    테스트 12 〉	통과 (0.46ms, 77.8MB)
//    테스트 13 〉	통과 (0.38ms, 75.6MB)
//    효율성  테스트
//    테스트 1 〉	통과 (129.45ms, 69.6MB)
//    테스트 2 〉	통과 (192.27ms, 69.6MB)

public class Solution3 {
    public static void main(String[] args) {
        int[] works = {4,3,3};
        int n = 4;

        System.out.println(solution(n, works));
    }

    public static long solution(int n, int[] works){
        PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int work : works){
            pq.offer(Long.valueOf(work));
        }
        while(n > 0 && !pq.isEmpty()){
            Long num = pq.poll();
            if(num - 1 > 0) pq.offer(num - 1);
            n--;
        }
        long answer = 0;
        while(!pq.isEmpty()){
            answer += Math.pow(pq.poll(),2);
        }
        return answer;
    }
}

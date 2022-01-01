package com.algorithm.programmers.y2022.m1.d1;

import java.util.Collections;
import java.util.PriorityQueue;

//https://programmers.co.kr/learn/courses/30/lessons/12941
//정확성  테스트
//    테스트 1 〉	통과 (0.42ms, 77.9MB)
//    테스트 2 〉	통과 (0.93ms, 73MB)
//    테스트 3 〉	통과 (1.14ms, 74MB)
//    테스트 4 〉	통과 (1.08ms, 76.5MB)
//    테스트 5 〉	통과 (1.38ms, 79.3MB)
//    테스트 6 〉	통과 (0.83ms, 74.5MB)
//    테스트 7 〉	통과 (1.31ms, 79.3MB)
//    테스트 8 〉	통과 (1.17ms, 77.7MB)
//    테스트 9 〉	통과 (0.90ms, 74.8MB)
//    테스트 10 〉	통과 (0.97ms, 79.3MB)
//    테스트 11 〉	통과 (0.68ms, 77.4MB)
//    테스트 12 〉	통과 (0.81ms, 76.7MB)
//    테스트 13 〉	통과 (1.08ms, 71.2MB)
//    테스트 14 〉	통과 (0.72ms, 75.9MB)
//    테스트 15 〉	통과 (0.81ms, 67.4MB)
//    테스트 16 〉	통과 (0.75ms, 73.4MB)
//효율성  테스트
//    테스트 1 〉	통과 (5.58ms, 52.3MB)
//    테스트 2 〉	통과 (5.81ms, 52.8MB)
//    테스트 3 〉	통과 (7.00ms, 52.1MB)
//    테스트 4 〉	통과 (5.27ms, 52.1MB)
public class Solution3 {
    public static void main(String[] args) {
        int[] A = {1, 4, 2};
        int[] B = {5, 4, 4};

        System.out.println(solution(A, B));
    }

    private static int solution(int[] A, int[] B){
        PriorityQueue<Integer> aq = new PriorityQueue<>();
        PriorityQueue<Integer> bq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0; i < A.length; i++){
            aq.offer(A[i]);
            bq.offer(B[i]);
        }
        int answer = 0;
        while(!aq.isEmpty()){
            int a = aq.poll();
            int b = bq.poll();

            answer += a*b;
        }
        return answer;
    }
}

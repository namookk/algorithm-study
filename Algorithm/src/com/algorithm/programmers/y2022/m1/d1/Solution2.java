package com.algorithm.programmers.y2022.m1.d1;

import java.util.Arrays;

//https://programmers.co.kr/learn/courses/30/lessons/12913?language=java
//정확성  테스트
//    테스트 1 〉	통과 (1.08ms, 77.6MB)
//    테스트 2 〉	통과 (1.17ms, 83.3MB)
//    테스트 3 〉	통과 (1.18ms, 71.9MB)
//    테스트 4 〉	통과 (1.10ms, 74.6MB)
//    테스트 5 〉	통과 (1.14ms, 74.2MB)
//    테스트 6 〉	통과 (1.64ms, 85.5MB)
//    테스트 7 〉	통과 (1.05ms, 70.7MB)
//    테스트 8 〉	통과 (1.21ms, 86.6MB)
//    테스트 9 〉	통과 (1.23ms, 77.6MB)
//    테스트 10 〉	통과 (1.61ms, 79.5MB)
//    테스트 11 〉	통과 (1.11ms, 78.1MB)
//    테스트 12 〉	통과 (1.16ms, 73.7MB)
//    테스트 13 〉	통과 (1.37ms, 79.7MB)
//    테스트 14 〉	통과 (2.18ms, 84.2MB)
//    테스트 15 〉	통과 (1.14ms, 81.6MB)
//    테스트 16 〉	통과 (1.12ms, 80.6MB)
//    테스트 17 〉	통과 (1.04ms, 74.9MB)
//    테스트 18 〉	통과 (1.05ms, 79.8MB)
//효율성  테스트
//    테스트 1 〉	통과 (17.09ms, 86.6MB)
//    테스트 2 〉	통과 (16.31ms, 85.9MB)
//    테스트 3 〉	통과 (16.10ms, 85.8MB)
//    테스트 4 〉	통과 (20.28ms, 85.8MB)
public class Solution2 {
    public static void main(String[] args) {
        int[][] land = {{1,2,3,5},{5,6,7,8},{4,3,2,1}};
        System.out.println(solution(land));
    }

    private static int solution(int[][] land){
        int m = land.length;
        int n = land[0].length;
        int[][] dy = new int[m][n];
        for(int i = 0; i < n; i++){
            dy[0][i] = land[0][i];
        }
        for(int i = 1; i < m; i++){
            for(int j = 0; j < n; j++){
                int max = 0;
                for(int k = 0; k < n; k++){
                    if(k != j){
                        max = Math.max(dy[i-1][k], max);
                    }
                }
                dy[i][j] = max + land[i][j];
            }
        }
        int[] arr = dy[m-1];
        Arrays.sort(arr);
        return arr[n-1];
    }
}

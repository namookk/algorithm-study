package com.algorithm.programmers.y2021.m12.d2;
//https://programmers.co.kr/learn/courses/30/lessons/43105
/*
정확성  테스트
    테스트 1 〉	통과 (0.03ms, 80.8MB)
    테스트 2 〉	통과 (0.03ms, 74.7MB)
    테스트 3 〉	통과 (0.04ms, 76.4MB)
    테스트 4 〉	통과 (0.06ms, 76MB)
    테스트 5 〉	통과 (0.30ms, 78MB)
    테스트 6 〉	통과 (0.11ms, 76.6MB)
    테스트 7 〉	통과 (0.30ms, 74MB)
    테스트 8 〉	통과 (0.08ms, 72.9MB)
    테스트 9 〉	통과 (0.03ms, 76.6MB)
    테스트 10 〉	통과 (0.08ms, 75.9MB)
효율성  테스트
    테스트 1 〉	통과 (9.58ms, 60.2MB)
    테스트 2 〉	통과 (12.60ms, 58.8MB)
    테스트 3 〉	통과 (9.61ms, 60.3MB)
    테스트 4 〉	통과 (9.28ms, 60.4MB)
    테스트 5 〉	통과 (8.67ms, 59.9MB)
    테스트 6 〉	통과 (9.50ms, 58.8MB)
    테스트 7 〉	통과 (8.66ms, 57.7MB)
    테스트 8 〉	통과 (8.55ms, 60MB)
    테스트 9 〉	통과 (8.81ms, 60MB)
    테스트 10 〉	통과 (9.23ms, 57.2MB)
*/
public class Solution2 {
    public static void main(String[] args) {
        int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
        System.out.println(solution(triangle));
    }

    public static int solution(int[][] triangle) {
        int answer = 0;
        for(int i = 1; i < triangle.length; i++) {
            for(int j = 0; j < triangle[i].length; j++) {
               int value = 0;
               if(j == 0) {
                   value = triangle[i-1][j] + triangle[i][j];
               }else if(j == triangle[i].length - 1) {
                   value = triangle[i-1][j-1] + triangle[i][j];
               }else{
                   value = Math.max(triangle[i-1][j-1] + triangle[i][j], triangle[i-1][j] + triangle[i][j]);
               }
               triangle[i][j] = value;

               if(i == triangle.length - 1){
                   answer = Math.max(answer, value);
               }
            }
        }
        return answer;
    }
}

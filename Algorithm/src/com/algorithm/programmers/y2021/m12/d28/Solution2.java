package com.algorithm.programmers.y2021.m12.d28;
//https://programmers.co.kr/learn/courses/30/lessons/12938
//정확성  테스트
//    테스트 1 〉	통과 (0.07ms, 78.4MB)
//    테스트 2 〉	통과 (0.12ms, 79.9MB)
//    테스트 3 〉	통과 (0.08ms, 67.8MB)
//    테스트 4 〉	통과 (0.13ms, 84.8MB)
//    테스트 5 〉	통과 (0.04ms, 85.6MB)
//    테스트 6 〉	통과 (0.08ms, 75.1MB)
//    테스트 7 〉	통과 (0.03ms, 78.2MB)
//    테스트 8 〉	통과 (0.03ms, 73.4MB)
//    테스트 9 〉	통과 (0.07ms, 70.7MB)
//    테스트 10 〉	통과 (0.13ms, 79.6MB)
//    테스트 11 〉	통과 (0.10ms, 80.2MB)
//    테스트 12 〉	통과 (0.08ms, 78.1MB)
//    테스트 13 〉	통과 (0.18ms, 76.7MB)
//    테스트 14 〉	통과 (0.02ms, 76.9MB)
//    효율성  테스트
//    테스트 1 〉	통과 (0.14ms, 53.6MB)
//    테스트 2 〉	통과 (0.22ms, 53.2MB)
//    테스트 3 〉	통과 (0.19ms, 53.3MB)
//    테스트 4 〉	통과 (0.20ms, 53.6MB)
//    테스트 5 〉	통과 (0.34ms, 54.7MB)
//    테스트 6 〉	통과 (0.01ms, 52MB)
public class Solution2 {
    public static void main(String[] args) {
        int n = 5;
        int s = 6;

        for(int i : solution(n, s)) System.out.print(i + " ");

    }
    public static int[] solution(int n, int s){
        if(n > s) return new int[]{-1};
        int[] answer = new int[n];
        int div = s / n;
        int rest = s % n;
        for(int i = 0; i < n - rest; i++){
            answer[i] = div;
        }
        for(int i = (n-rest); i < n; i++){
            answer[i] = div + (rest > 0 ? 1 : 0);
        }
        return answer;
    }
}

package com.algorithm.programmers.y2021.m12.d14;

//https://programmers.co.kr/learn/courses/30/lessons/43162

//정확성  테스트
//    테스트 1 〉	통과 (0.03ms, 79.6MB)
//    테스트 2 〉	통과 (0.03ms, 71.7MB)
//    테스트 3 〉	통과 (0.06ms, 82.1MB)
//    테스트 4 〉	통과 (0.05ms, 71.3MB)
//    테스트 5 〉	통과 (0.03ms, 76MB)
//    테스트 6 〉	통과 (0.18ms, 71.5MB)
//    테스트 7 〉	통과 (0.03ms, 74.6MB)
//    테스트 8 〉	통과 (0.09ms, 77.8MB)
//    테스트 9 〉	통과 (0.06ms, 78.1MB)
//    테스트 10 〉	통과 (0.06ms, 69.9MB)
//    테스트 11 〉	통과 (0.58ms, 71MB)
//    테스트 12 〉	통과 (0.27ms, 75.8MB)
//    테스트 13 〉	통과 (0.16ms, 78.2MB)

public class Solution {
    static int[] ch;
    public static void main(String[] args) {
        int n = 3;
        int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        int[][] computers2 = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
        System.out.println(solution(n, computers));
        System.out.println(solution(n, computers2));
    }

    public static int solution(int n, int[][] computers) {
        int answer = 0;
        ch = new int[n];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(computers[i][j] == 1 && ch[i] == 0) {
                    answer++;
                    dfs(computers, i);
                }
            }
        }

        return answer;
    }

    public static void dfs(int[][] computers, int i) {
        for(int k = 0; k < computers[i].length; k++) {
            if(computers[i][k] == 1 && ch[k] == 0) {
                ch[k] = 1;
                dfs(computers, k);
            }
        }
    }
}

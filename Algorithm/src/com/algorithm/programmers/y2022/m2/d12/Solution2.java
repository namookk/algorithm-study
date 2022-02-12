package com.algorithm.programmers.y2022.m2.d12;

import java.util.HashSet;
import java.util.Set;

public class Solution2 {
    public static void main(String[] args) {
        int[] T = {0, 3, 0, 0, 5, 0, 5};
        int[] A = {4, 2, 6, 1, 0};

        System.out.println(solution(T, A));
    }

    private static int solution(int[] T, int[] A){
        int[] visited = new int[T.length];
        int answer = 1;
        visited[0] = 1;

        for (int i = 0; i < A.length; i++) {
            int idx = A[i];
            while(visited[idx] == 0 && idx > 0) {
                visited[idx] = 1;
                answer++;
                idx = T[idx];
            }
        }

        return answer;
    }
}

package com.algorithm.inflearn2.chapter2;

import java.util.Arrays;

public class Main2_3 {
    public static void main(String[] args) {
        int[][] points = {{3, 3},{5, -1},{-2, 4}};
        int k = 2;

        for(int[] arr : solve(points, k)) {
            for(int i : arr) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public static int[][] solve(int[][] points, int k) {
        Arrays.sort(points, (a,b) -> {
            return (a[0]*a[0] + a[1]*a[1])-(b[0]*b[0] + b[1]*b[1] );
        });

        int[][] answer = new int[k][2];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = points[i];
        }
        return answer;
    }
}

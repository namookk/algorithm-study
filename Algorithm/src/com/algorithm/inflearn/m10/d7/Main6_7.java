package com.algorithm.inflearn.m10.d7;

import java.util.*;

public class Main6_7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] arr = new int[N][2];
        for(int i = 0; i < N; i++) {
            for(int j =0 ; j < 2; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        for(int[] i : solution(N, arr)) {
            System.out.println(i[0] + " " + i[1]);
        }
    }

    public static int[][] solution(int N, int[][] arr) {

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] > o2[0]) {
                    return 1;
                }else if(o1[0] < o2[0]){
                    return -1;
                }else if(o1[1] > o2[1]){
                    return 1;
                }else{
                    return -1;
                }
            }
        });

        return arr;
    }
}

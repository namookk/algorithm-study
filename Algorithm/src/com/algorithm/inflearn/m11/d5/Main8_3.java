package com.algorithm.inflearn.m11.d5;

import java.util.Scanner;

public class Main8_3 {
    static int max;
    static int answer = Integer.MIN_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        max = sc.nextInt();
        int[][] arr = new int[n][n];
        for(int i = 0; i < n; i++){
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }
        System.out.println(solution(arr));
    }

    public static int solution(int[][] arr) {
        DFS(0, 0, 0, arr);
        return answer;
    }

    public static void DFS(int curr, int score, int time, int[][] arr) {
        if(time > max) {
            return;
        }
        answer = Math.max(answer, score);
        if(curr == arr.length) {

        }else{
            DFS(curr + 1, score + arr[curr][0] , time + arr[curr][1], arr);
            DFS(curr + 1, score , time, arr);
        }
    }
}

package com.algorithm.baekjoon.y2022.m1.d1;

import java.util.Scanner;

//계단 오르기
//https://www.acmicpc.net/problem/2579
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(solution(arr));
    }

    public static int solution(int[] arr){
        int[][] dy = new int[arr.length][2];
        dy[0] = new int[]{arr[0],1};
        dy[1] = new int[]{dy[0][0] + arr[1],1};
        dy[2] = new int[]{dy[0][0] + arr[2],2};

        if(arr.length  > 3){
            for(int i = 3; i < dy.length; i++){
                if(dy[i-1][1] == 1){
                    dy[i] = new int[]{dy[i-2][0] + arr[i], 2};
                }else if(dy[i-1][0] + arr[i] > dy[i-2][0] + arr[i]){
                    dy[i] = new int[]{dy[i-1][0] + arr[i], 1};
                }else{
                    dy[i] = new int[]{dy[i-2][0] + arr[i], 2};
                }
            }
        }
        return dy[dy.length - 1][0];
    }
}

package com.algorithm.baekjoon.silver5;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_1246 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[m];
        for(int i = 0; i < m; i++){
            arr[i] = sc.nextInt();
        }
        int[] result = solution(n, m, arr);
        System.out.println(result[0] +" "+ result[1]);
    }

    private static int[] solution(int n, int m, int[] arr){
        Arrays.sort(arr);
        int[] answer = new int[2];
        for(int i = 0; i < m; i++){
            int price = arr[i];
            int sum = price * ( m - i > n ? n : m - i);
            if(answer[1] < sum){
                answer[0] = price;
                answer[1] = sum;
            }
        }

        return answer;
    }
}

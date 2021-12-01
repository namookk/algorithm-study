package com.algorithm.inflearn.chapter10;

import java.util.Scanner;

public class Main10_3 {
    static int[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        arr = new int[n];
        for(int i = 0; i < n; i++) arr[i] = sc.nextInt();
        System.out.println(solution());
    }
    public static int solution() {
        int answer = 0;
        int[] dy = new int[arr.length];
        for(int i = 0; i < arr.length; i++) {
            if(i == 0) dy[i] = 1;
            else{
                int max = 1;
                for(int j = i-1; j >= 0; j--) {
                    if(arr[i] > arr[j]) {
                        max = Math.max(max, dy[j] + 1);
                    }
                }
                dy[i] = max;
                answer = Math.max(answer, max);
            }
        }
        return answer;
    }
}

package com.algorithm.inflearn.m11.d5;

import java.util.Scanner;

public class Main8_2 {
    static int N, cnt;
    static long max;
    static long answer = Long.MIN_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        max = sc.nextLong();
        N = sc.nextInt();
        long[] dogs = new long[N];
        for(int i = 0; i < N; i++) {
            dogs[i] = sc.nextLong();
        }
        System.out.println(solution(dogs));
    }
    public static long solution(long[] dogs) {
        DFS(0, 0, dogs);
        return answer;
    }

    public static void DFS(int n, long sum, long[] dogs) {
        if(sum > max){
            return;
        }
        answer = Math.max(answer, sum);
        if(n == N) {
        }else{
            DFS(n+1, sum + dogs[n], dogs);
            DFS(n+1, sum, dogs);
        }
    }
}

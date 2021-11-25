package com.algorithm.inflearn.m9.d28;

import java.util.*;

public class Main3_5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println("test");
        System.out.print(solution(n));
    }

    public static int solution(int n) {
        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();
        int sum = 0;
        for(int i = 1; i <= Math.ceil(n / 2.0); i++) {
            sum += i;
            queue.offer(i);
            while(sum > n) {
                sum -= queue.poll();
            }
            if(sum == n) answer++;
        }
        return answer;
    }
}

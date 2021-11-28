package com.algorithm.inflearn.chapter3;

import java.util.*;

public class Main3_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.print(solution(k, arr));
    }

    public static int solution(int k, int[] arr) {
        int answer = 0;
        int sum = 0;
        Queue<Integer> queue = new LinkedList<>();
        for(Integer num : arr) {
            sum += num;
            queue.offer(num);
            while(sum > k) {
                sum -= queue.poll();
            }
            if(sum == k) answer++;
        }
        return answer;
    }
}

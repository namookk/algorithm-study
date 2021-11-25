package com.algorithm.inflearn.m9.d27;

import java.util.*;

public class Main3_3 {
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
        int maxSum = 0;
        int currSum = 0;
        Queue<Integer> queue = new LinkedList<>();
        for(Integer num : arr) {
            if(queue.size() == k) {
                currSum -= queue.poll();
            }
            queue.offer(num);
            currSum += num;
            if(maxSum < currSum) maxSum = currSum;
        }

        return maxSum;
    }
}

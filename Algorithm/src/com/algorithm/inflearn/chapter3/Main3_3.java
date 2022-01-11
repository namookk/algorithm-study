package com.algorithm.inflearn.chapter3;

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
        System.out.print(solution2(k, arr));
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

    public static int solution2(int k, int[] arr){
        int currSum = 0;
        for(int i = 0; i < k; i++){
            currSum += arr[i];
        }
        int maxSum = currSum;
        int lt = 1;
        int rt = lt + k - 1;
        while(rt < arr.length){
            currSum -= arr[lt++ - 1];
            currSum += arr[rt++];
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }
}

package com.algorithm.matchhere.study1.round2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for(int num : solution(arr, m)) System.out.print(num + " ");
    }

    public static List<Integer> solution(int[] arr, int m) {
        List<Integer> answer = new ArrayList<>();
        for(int num : arr) {
            if(m > num) answer.add(num);
        }
        return answer;
    }
}

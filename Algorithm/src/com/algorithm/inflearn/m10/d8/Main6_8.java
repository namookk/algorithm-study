package com.algorithm.inflearn.m10.d8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main6_8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int target = sc.nextInt();
        int[] arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(solution(N, target, arr));
    }

    public static int solution(int N, int target, int[] arr) {
        int answer = 0;
        Arrays.sort(arr);
        answer = binarySearch(0, arr.length -1, target, arr);
        return answer + 1;
    }

    public static int binarySearch(int start, int end, int target, int[] arr) {
        int mid = (int) Math.ceil((start+end) / 2);
        if(arr[mid] == target) {
            return mid;
        }else if(arr[mid] > target){
            return binarySearch(start, mid-1, target, arr);
        }else{
            return binarySearch(mid+1, end, target, arr);
        }
    }
}

package com.algorithm.inflearn.m10.d6;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main6_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int N = sc.nextInt();
        int[] arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        for(int i : solution(size, N, arr)) {
            System.out.print(i +" ");
        }
    }

    public static List<Integer> solution(int size, int N, int[] arr) {
        List<Integer> cacheList = new ArrayList<>();

        for(int num : arr) {
            int idx = cacheList.indexOf(num);
            if(idx > -1) cacheList.remove(idx);

            if(cacheList.size() < size) {
                cacheList.add(0,num);
            }else{
                cacheList.remove(size-1);
                cacheList.add(0,num);
            }
        }

        return cacheList;
    }
}

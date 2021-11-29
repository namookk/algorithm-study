package com.algorithm.inflearn.chapter5;

import java.util.*;

public class Main5_6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        System.out.print(solution(n, k));
    }

    public static int solution(int n, int k) {
        int answer = 0;
        Integer[] arr = new Integer[n];
        for(int i = 1; i <= arr.length; i++) {
            arr[i-1] = i;
        }
        List<Integer> list = new ArrayList<>(Arrays.asList(arr));
        int num = 0;
        int idx = 0;
        while(list.size() > 1) {
            num++;
            if(num == k){
                list.remove(idx);
                num = 0;
                if(idx == list.size()) idx = 0;
            }else {
                if (idx >= list.size() - 1) idx = 0;
                else idx++;
            }
        }

        return list.get(0);
    }
}
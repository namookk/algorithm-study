package com.algorithm.inflearn.y2021.m9.d27;

import java.util.*;
import java.util.stream.Stream;

public class Main3_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr1 = new int[n];
        for(int i = 0 ; i < n; i++) {
            arr1[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        int[] arr2 = new int[m];
        for(int i = 0 ; i < m; i++) {
            arr2[i] = sc.nextInt();
        }
        for(int i : solution(arr1, arr2)) {
            System.out.print(i + " ");
        }
    }

    public static Integer[] solution(int[] arr1, int[] arr2) {
        Integer[] sumArr = Stream.concat(Arrays.stream(arr1).boxed(), Arrays.stream(arr2).boxed())
                .toArray(Integer[]::new);

        Arrays.sort(sumArr);

        return sumArr;
    }
}

package com.algorithm.inflearn.m10.d6;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main6_5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(solution(N, arr));
    }

    public static String solution(int N, int[] arr) {
        String answer = "U";
        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
        for(int i = 0; i < list.size(); i++) {
            if(list.indexOf(list.get(i)) != i) {
                return "D";
            }
        }
        return answer;
    }
}

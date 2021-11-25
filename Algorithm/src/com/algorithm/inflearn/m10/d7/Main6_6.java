package com.algorithm.inflearn.m10.d7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main6_6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        for(Integer i : solution(N, arr)) {
            System.out.print(i + " ");
        }
    }

    public static List<Integer> solution(int N, int[] arr) {
        List<Integer> answer = new ArrayList<Integer>();
        List<Integer> sortList = Arrays.stream(arr).boxed().sorted().collect(Collectors.toList());
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] != sortList.get(i)) {
                answer.add(i+1);
            }
        }
        return answer;
    }
}

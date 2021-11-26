package com.algorithm.baekjoon.y2021.m10.d27;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

//https://www.acmicpc.net/problem/1764

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        String[] noHearArr = new String[N];
        sc.nextLine();
        for(int i = 0; i < N; i++) {
            noHearArr[i] = sc.nextLine();
        }
        String[] noSeeArr = new String[M];
        for(int i = 0; i < M; i++) {
            noSeeArr[i] = sc.nextLine();
        }
        solution(noHearArr, noSeeArr);
    }

    public static void solution(String[] noHearArr, String[] noSeeArr) {
        String[] sumArr = Stream.of(noHearArr, noSeeArr).flatMap(Stream::of).toArray(String[]::new);
        Arrays.sort(sumArr);
        List<String> answerList = new ArrayList<>();
        for(int i = 1; i < sumArr.length;i++) {
            if(sumArr[i].equals(sumArr[i-1])){
                answerList.add(sumArr[i]);
            }
        }
        System.out.println(answerList.size());
        for(String answer : answerList) {
            System.out.println(answer);
        }
    }
}

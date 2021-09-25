package com.algorithm.day26;

import java.util.*;
import java.util.stream.Collectors;

public class Main2_8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for(int i : solution(n, arr)){
            System.out.print(i + " ");
        }
    }

    public static List<Integer> solution(int n, int[] arr) {
        List<Integer> answer = new ArrayList<>();
        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
        Collections.sort(list, Collections.reverseOrder());
        for(int i : arr) {
            answer.add(list.indexOf(i) + 1);
        }

        return answer;
    }
}
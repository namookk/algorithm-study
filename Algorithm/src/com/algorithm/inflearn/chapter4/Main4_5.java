package com.algorithm.inflearn.chapter4;

import java.util.*;
import java.util.stream.Collectors;

public class Main4_5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(solution(k, arr));
    }

    public static int solution(int k, int[] arr) {
        int answer = -1;
        List<Integer> list = Arrays.stream(arr).boxed().sorted((a,b) -> b-a).collect(Collectors.toList());
        int firstIdx = 0;
        int secondIdx = 1;
        int thirdIdx = 1;
        List<Integer> sumList = new ArrayList<>();
        while(true) {
            if(++thirdIdx == arr.length) {
                secondIdx++;
                thirdIdx = secondIdx + 1;
            }
            if(secondIdx == arr.length - 1) {
                firstIdx++;
                secondIdx = firstIdx + 1;
                thirdIdx = secondIdx + 1;
            }
            if(firstIdx == arr.length - 2) {
                break;
            }
            int sum = list.get(firstIdx) + list.get(secondIdx) + list.get(thirdIdx);
            if(sumList.indexOf(sum) == -1) sumList.add(sum);
        }

        Collections.sort(sumList, Collections.reverseOrder());
        return (sumList.size() > k ? sumList.get(k-1) : -1);
    }
}
package com.algorithm.inflearn.chapter3;
import java.util.*;

public class Main3_2 {
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

    public static List<Integer> solution(int[] arr1, int[] arr2) {
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int p1 = 0;
        int p2 = 0;
        List<Integer> answerList = new ArrayList<>();
        while(p1 < arr1.length && p2 < arr2.length) {
            if(arr1[p1] == arr2[p2]) {
                answerList.add(arr1[p1]);
                p1++;
                p2++;
            }else if(arr1[p1] > arr2[p2]) {
                p2++;
            }else{
                p1++;
            }
        }
        return answerList;
    }
}

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

    public static List<Integer> solution(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);
        int p1 = 0;
        int p2 = 0;
        List<Integer> answerList = new ArrayList<>();
        while(p1 < a.length && p2 < b.length) {
            if(a[p1] == b[p2]) {
                answerList.add(a[p1]);
                p1++;
                p2++;
            }else if(a[p1] > b[p2]) {
                p2++;
            }else{
                p1++;
            }
        }
        return answerList;
    }
}

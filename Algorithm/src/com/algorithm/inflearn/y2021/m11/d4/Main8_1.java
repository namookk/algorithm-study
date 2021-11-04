package com.algorithm.inflearn.y2021.m11.d4;

import java.util.Arrays;
import java.util.Scanner;

public class Main8_1 {

    static int[] ch;
    static int[] arr;
    static int target;
    static boolean flag = false;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        arr = new int[N];
        for(int i = 0 ; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(solution());
    }

    public static String solution() {
        String answer = "NO";
        int sum = Arrays.stream(arr).sum();
        if(sum % 2 != 0) return "NO";
        target = sum / 2;
        ch = new int[arr.length];
        ch[0] = 1;
        DFS(arr[0], arr[0]);
        return flag ? "YES" : "NO";
    }

    public static void DFS(int curr, int sum) {
       if(sum == target) {
           System.out.println(target);
           for(int i = 0; i < arr.length; i++) {
               if(ch[i] == 1) System.out.print(arr[i] + " ");
           }
           flag = true;
       }else if(!flag){
           for(int i = 0; i < arr.length; i++) {
               if(ch[i] == 0) {
                   ch[i] = 1;
                   DFS(arr[i], sum + arr[i]);
                   ch[i] = 0;
               }
           }
       }
    }
}

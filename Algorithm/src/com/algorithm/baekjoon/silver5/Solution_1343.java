package com.algorithm.baekjoon.silver5;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.Scanner;

public class Solution_1343 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(solution(s));
    }

    private static String solution(String s){
        String[] arr = s.split("\\.", -1);

        if(arr.length == 0) return s;
        for(int i = 0; i < arr.length; i++){
            String str = arr[i];
            if(str.length() > 0){
                if(str.length() % 2 == 1) return "-1";
                arr[i] = "AAAA".repeat(str.length() / 4);
                if(str.length() % 4 == 2) arr[i] += "BB";
            }
        }
        return String.join(".", arr);
    }
}

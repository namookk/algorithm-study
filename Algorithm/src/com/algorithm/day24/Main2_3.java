package com.algorithm.day24;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main2_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Integer[] A = new Integer[n];
        Integer[] B = new Integer[n];
        for(int i = 0 ; i < n; i++) {
            A[i] = sc.nextInt();
        }
        for(int i = 0 ; i < n; i++) {
            B[i] = sc.nextInt();
        }
        for(String s : solution(n, A, B)){
            System.out.println(s);
        }
    }

    public static List<String> solution(int n, Integer[] A, Integer[] B) {
        List<String> answer = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            answer.add(getWinner(A[i], B[i]));
        }

        return answer;
    }
    public static String getWinner(Integer A, Integer B) {
        if(A > B) {
            if(A - B == 2) return "B";
            else return "A";
        }else if(B > A){
            if(B - A == 2) return "A";
            else return "B";
        }else {
            return "D";
        }
    }
}
package com.algorithm.day25;

import java.util.Scanner;

public class Main2_6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String s = sc.nextLine();

        System.out.println(solution(n, s));
    }

    public static int solution(int n, String s) {
        int answer = 0;
        s = s.replaceAll(" ", "");
        String[] arr = s.split("0");
        for(String str : arr) {
            int len = str.length();
            if(len > 0) {
                int sum = (len + 1) * (len / 2) + (len % 2 == 1 ? (len + 1) / 2 : 0); // 합
                answer += sum;
            }
        }
        return answer;
    }
}
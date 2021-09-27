package com.algorithm.inflearn.y2021.m9.d23;

import java.util.Scanner;

public class Main1_11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(solution(str));
    }

    public static String solution(String str) {
        String answer = "";
        int cnt = 1;
        char curr = str.charAt(0);
        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(i == 0) {

            }else if(curr != c){
                answer += String.valueOf(curr);
                if(cnt > 1) answer += cnt;
                cnt = 1;
                curr = c;
            }else{
                cnt++;
            }
            if(i == str.length() - 1){ //마지막일경우
                answer += String.valueOf(c);
                if(cnt > 1) answer += cnt;
            }
        }
        return answer;
    }
}

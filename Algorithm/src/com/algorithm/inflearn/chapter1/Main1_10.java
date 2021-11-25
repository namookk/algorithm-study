package com.algorithm.inflearn.chapter1;

import java.util.Scanner;

public class Main1_10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String t = sc.next();
        System.out.println(solution(s, t));
    }

    public static String solution(String s, String t) {
        String answer = "";
        int[] ansArr = new int[s.length()];
        StringBuffer sb = new StringBuffer(s);
        String revS = sb.reverse().toString();
        int revI = s.length() - 1;
        for(int i = 0 ; i < s.length(); i++) {
            if(String.valueOf(s.charAt(i)).equals(t)){
                ansArr[i] = 0;
            }else{
                int rIdx = s.indexOf(t, i+1);
                int rDiff = s.length();
                int lIdx = revS.indexOf(t, revI+1);
                int lDiff = s.length();
                if(rIdx > -1) rDiff = rIdx - i;
                if(lIdx > -1) lDiff = lIdx - revI;
                if(rDiff > lDiff){
                    ansArr[i] = lDiff;
                }else{
                    ansArr[i] = rDiff;
                }
            }
            answer += ansArr[i] + ((i < s.length() -1) ? " " : "");
            revI--;
        }

        return answer;
    }
}

package com.algorithm.inflearn.y2021.m9.d22;

import java.util.Scanner;

public class Main1_5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(solution(str));
    }

    public static String solution(String str) {
        String[] strArr = str.split("");
        int lt = 0;
        int rt = str.length() - 1;
        while(lt != rt && lt < rt) {
            if(!isAlphabet(str.charAt(lt))) {
                lt++;
            }else if(!isAlphabet(str.charAt(rt))) {
                rt--;
            }else{
                String tempLt = strArr[lt];
                strArr[lt] = strArr[rt];
                strArr[rt] = tempLt;
                lt++;
                rt--;
            }
        }
        return String.join("", strArr);
    }

    public static boolean isAlphabet(char c) {
        if((c >= 65 && c <= 90 ) || ( c >= 97 && c <= 122)) {
            return true;
        }else{
            return false;
        }
    }
}

package com.algorithm.baekjoon.silver5;

import java.util.Scanner;

public class Solution_1439 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        char same = (s.charAt(0) == s.charAt(s.length() - 1)) ? s.charAt(0) : '0';

        int cnt = 0;
        int lt = 0;
        int rt = 0;
        while(rt < s.length()){
            if(s.charAt(rt) != same){
                if(rt == s.length() -1) cnt++;
                rt++;
            }else if(rt > lt){
                cnt++;
                lt = ++rt;
            }else{
                rt++;
                lt++;
            }
        }

        System.out.println(cnt);
    }
}

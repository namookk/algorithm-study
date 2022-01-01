package com.algorithm.programmers.y2022.m1.d1;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        String[] phone_book = {"12","123","1235","567","88"};
        System.out.println(solution(phone_book));
    }

    private static boolean solution(String[] phone_book){
        Arrays.sort(phone_book, (a,b) ->{
            return a.compareTo(b);
        });

        for(int i = 0; i < phone_book.length - 1; i++){
            String s1 = phone_book[i];
            String s2 = phone_book[i+1];
            if(s1.length() >= s2.length()) continue;
            if(s1.equals(s2.substring(0, s1.length()))) return false;
        }

        return true;
    }
}

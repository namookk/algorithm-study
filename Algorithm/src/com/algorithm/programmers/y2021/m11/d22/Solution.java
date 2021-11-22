package com.algorithm.programmers.y2021.m11.d22;

//https://programmers.co.kr/learn/courses/30/lessons/12930
public class Solution {
    public static void main(String[] args) {
        String s = "try hello world";
        System.out.println(solution(s));
    }
    public static String solution(String s) {
        int idx = 0;
        StringBuffer sb = new StringBuffer();

        for(char c : s.toCharArray()){
            if(c == ' '){
                sb.append(" ");
                idx = 0;
            }else{
                sb.append(idx % 2 == 0 ? String.valueOf(c).toUpperCase() : String.valueOf(c).toLowerCase());
                idx++;
            }
        }
        return sb.toString();
    }
}

package com.algorithm.programmers.y2021.m11.d19;
//짝지어 제거하기 난이도 2
//https://programmers.co.kr/learn/courses/30/lessons/12973
public class Solution {
    public static void main(String[] args) {
        String s = "bababa";
        System.out.println(solution(s));
    }

    public static int solution(String s)
    {
        String[] arr = {"aa","bb","cc","dd","ee","ff","gg","hh","ii","jj","kk","ll","nn","mm","oo","pp","qq","rr","ss","tt","uu","vv","ww","xx","yy","zz"};
        while(true){
            int cnt = 0;
            for (String str : arr) {
                while(s.indexOf(str) > -1) {
                    cnt++;
                    s = s.replace(str, "");
                }
            }
            if(cnt == 0) break;
        }
        return s.length() > 0 ? 0 : 1;
    }
}

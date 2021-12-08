package com.algorithm.matchhere.study1.round5;

public class Solution1 {
    public static void main(String[] args) {
        solution();
    }
    public static void solution() {
        int[] dy = new int[10001];
        for(int i = 1; i < dy.length;i++) {
            int n = func(i);
            if(n < 10001) dy[n]++;
        }
        for(int i = 1; i < dy.length; i++){
            if(dy[i] == 0) System.out.println(i);
        }
    }
    public static int func(int n) {
        String num = n + "";
        for(int i = 0; i < num.length(); i++){
            char c = num.charAt(i);
            n += Character.getNumericValue(c);
        }
        return n;
    }
}

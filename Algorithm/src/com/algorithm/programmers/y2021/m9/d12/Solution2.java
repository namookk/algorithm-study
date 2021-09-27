package com.algorithm.programmers.y2021.m9.d12;

public class Solution2 {
    public static void main(String[] args) {
        int n = 16, t = 16, m = 2, p = 1;
        System.out.println(solution(n,t,m,p));
    }

    public static String solution(int n, int t, int m, int p) {
        String answer = "";
        int num = 0;
        int idx = 0;
        int turn = 1;
        while(answer.length() < t){
            String s = "";

            if(num >= 2){
                String numStr = getString(num, n);
                s = Character.toString(numStr.charAt(idx));
                if(numStr.length() == (idx + 1)){
                    idx = 0;
                    num++;
                }else{
                    idx++;
                }
            }else{
                s = num + "";
                num++;
            }

            if(turn == p) answer += s;
            if(turn == m) turn = 1;
            else turn++;

        }
        return answer;
    }

    public static String getString(int n, int k){
        StringBuilder sb = new StringBuilder();
        int current = n;

        while(current > 0){
            if(current % k < 10){
                sb.insert(0, current % k);
            } else {
                sb.insert(0, (char)(current % k - 10 + 'A'));
            }
            current /= k;
        }
        return sb.toString();
    }
}

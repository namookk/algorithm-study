package com.algorithm.day19;

public class Solution {
    public static void main(String[] args) {
        int n = 78;
        System.out.println(solution(n));
    }

    public static int solution(int n) {
        int answer = 0;
        String nBinary = Integer.toBinaryString(n);
        long cnt = nBinary.chars().filter(c -> c == '1').count();
        while(true) {
            String binary = Integer.toBinaryString(++n);
            long cnt2 = binary.chars().filter(c -> c == '1').count();
            if(cnt == cnt2){
                answer = n;
                break;
            }
        }
        return answer;
    }
}

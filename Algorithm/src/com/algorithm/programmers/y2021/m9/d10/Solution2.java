package com.algorithm.programmers.y2021.m9.d10;

public class Solution2 {
    public static void main(String[] args) {
        int n = 999999;
        int k = 4;
        //3
        System.out.println(solution(n, k));
    }

    public static int solution(int n, int k) {
        int answer = 0;
        String[] arr = getString(n, k).split("0");
        for(String str : arr){
            if(str.length() > 0 && isPrime(Long.valueOf(str))) answer++;
        }
        return answer;
    }

    public static String getString(int n, int k){
        StringBuilder builder = new StringBuilder();
        while (n >= 1) {
            builder.insert(0, n % k); n /= k;
        }

        return builder.toString();
    }

    public static boolean isPrime(long num){
        if(num == 1){
            return false;
        }
        for(int i = 2; i <= Math.sqrt(num); i++) {
            if(num % i == 0) return false;
        }
        return true;
    }
}

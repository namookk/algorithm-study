package com.algorithm.programmers.y2021.m11.d23;

//https://programmers.co.kr/learn/courses/30/lessons/12934
public class Solution2 {
    public static void main(String[] args) {
        long n = 121;
        System.out.println(solution(n));
    }

    public static long solution(long n){
        double sqrt = Math.sqrt(n);
        if(sqrt == Math.floor(sqrt)){
            return (long)Math.pow(sqrt+1, 2);
        }else{
            return -1;
        }
    }
}

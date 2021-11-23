package com.algorithm.programmers.y2021.m11.d23;

//https://programmers.co.kr/learn/courses/30/lessons/12977
public class Solution {
    public static void main(String[] args) {
        int[] arr = {1,2,7,6,4};
        System.out.println(solution(arr));
    }

    public static int solution(int[] arr){
        int answer = 0;
        for(int i = 0; i < arr.length; i++) {
            for(int j = i+1; j < arr.length; j++) {
                for(int k = j+1; k < arr.length; k++) {
                    if(isPrime(arr[i] + arr[j] + arr[k])){
                        answer++;
                    }
                }
            }
        }
        return answer;
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

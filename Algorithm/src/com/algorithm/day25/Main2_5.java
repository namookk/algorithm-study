package com.algorithm.day25;

import java.util.Scanner;

public class Main2_5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(solution(n));
    }
    public static int solution(int n) {
        int answer = 0;
        for(int i = 1; i <= n; i++){
            if(isPrime(i)) answer++;
        }
        return answer;
    }
    public static boolean isPrime(int num){
        if(num == 1){
            return false;
        }
        for(int i = 2; i <= Math.sqrt(num); i++) {
            if(num % i == 0) return false;
        }
        return true;
    }
}

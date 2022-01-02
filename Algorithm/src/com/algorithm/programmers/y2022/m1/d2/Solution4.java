package com.algorithm.programmers.y2022.m1.d2;

//https://programmers.co.kr/learn/courses/30/lessons/12953
//정확성  테스트
//    테스트 1 〉	통과 (0.02ms, 77.4MB)
//    테스트 2 〉	통과 (0.02ms, 73.5MB)
//    테스트 3 〉	통과 (0.02ms, 69.4MB)
//    테스트 4 〉	통과 (0.02ms, 72.1MB)
//    테스트 5 〉	통과 (0.03ms, 75MB)
//    테스트 6 〉	통과 (0.03ms, 81MB)
//    테스트 7 〉	통과 (0.02ms, 76.3MB)
//    테스트 8 〉	통과 (0.02ms, 73.4MB)
//    테스트 9 〉	통과 (0.01ms, 77.5MB)
//    테스트 10 〉	통과 (0.02ms, 73.9MB)
public class Solution4 {
    public static void main(String[] args) {
        int[] arr = {2,6,8,14};
        System.out.println(solution(arr));
    }

    private static int solution(int[] arr){
        int[] dy = new int[arr.length - 1];
        dy[0] = arr[0] * arr[1] / gcd(arr[0], arr[1]);
        for(int i = 1; i < dy.length; i++){
            dy[i] = dy[i-1] * arr[i+1] / gcd(dy[i-1], arr[i+1]);
        }

        return dy[arr.length - 2];
    }

    private static int gcd(int a, int b){
        if(b == 0) return a;
        else return gcd(b, a%b);
    }
}

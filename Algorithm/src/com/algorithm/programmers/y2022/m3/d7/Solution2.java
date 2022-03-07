package com.algorithm.programmers.y2022.m3.d7;

//https://programmers.co.kr/learn/courses/30/lessons/92335
//정확성  테스트
//    테스트 1 〉	통과 (11.92ms, 74.6MB)
//    테스트 2 〉	통과 (0.06ms, 77.7MB)
//    테스트 3 〉	통과 (0.08ms, 74.9MB)
//    테스트 4 〉	통과 (0.11ms, 74.5MB)
//    테스트 5 〉	통과 (0.08ms, 74.6MB)
//    테스트 6 〉	통과 (0.08ms, 74.4MB)
//    테스트 7 〉	통과 (0.09ms, 74.4MB)
//    테스트 8 〉	통과 (0.07ms, 73.7MB)
//    테스트 9 〉	통과 (0.08ms, 75.9MB)
//    테스트 10 〉	통과 (0.07ms, 77MB)
//    테스트 11 〉	통과 (0.07ms, 76.5MB)
//    테스트 12 〉	통과 (0.07ms, 78.2MB)
//    테스트 13 〉	통과 (0.11ms, 77.7MB)
//    테스트 14 〉	통과 (0.06ms, 75MB)
//    테스트 15 〉	통과 (0.09ms, 75.7MB)
//    테스트 16 〉	통과 (0.08ms, 76.7MB)
public class Solution2 {
    static String nStr;
    public static void main(String[] args) {
        System.out.println(solution(437674, 3));
        System.out.println(solution(110011, 10));
    }
    private static int solution(int n, int k){
        nStr = Integer.toString(n, k);
        int answer = 0;

        int start = 0;
        int end = 1;

        for (int i = 1; i < nStr.length(); i++) {
            char c = nStr.charAt(i);
            if(c == '0'){
                if(checkPrime(start, end)) answer++;
                start = i + 1;
                end = i + 1;
            }else{
                end++;
            }
        }
        if(checkPrime(start, end)) answer++;

        return answer;
    }

    private static boolean checkPrime(int start, int end) {
        if(start == end) return false;

        String substr = nStr.substring(start, end);
        if(isPrime(Long.parseLong(substr))) {
            return true;
        }

        return false;
    }
    public static boolean isPrime(long num){
        if(num == 1){
            return false;
        }
        for(long i = 2; i <= Math.sqrt(num); i++) {
            if(num % i == 0) return false;
        }
        return true;
    }
}

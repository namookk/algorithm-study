package com.algorithm.programmers.y2021.m12.d2;

//https://programmers.co.kr/learn/courses/30/lessons/42883

/*
테스트 1 〉	통과 (0.06ms, 77.5MB)
테스트 2 〉	통과 (0.07ms, 77.3MB)
테스트 3 〉	통과 (0.20ms, 75.5MB)
테스트 4 〉	통과 (0.78ms, 67.5MB)
테스트 5 〉	통과 (1.21ms, 75.3MB)
테스트 6 〉	통과 (24.83ms, 77.2MB)
테스트 7 〉	통과 (35.73ms, 88.4MB)
테스트 8 〉	통과 (179.67ms, 79MB)
테스트 9 〉	통과 (22.70ms, 92MB)
테스트 10 〉	통과 (6004.40ms, 87.8MB)
테스트 11 〉	통과 (0.12ms, 77.8MB)
테스트 12 〉	통과 (0.11ms, 66MB)
*/
public class Solution {
    public static void main(String[] args) {
        String number = "77777";
        int k = 1;
        System.out.println(solution(number, k));
    }

    public static String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);
            int num = Character.getNumericValue(c);
            boolean flag = false;
            if(k > 0) {
                if(i > number.length() - 1 - k){
                    flag = true;
                }else {
                    for (int j = i + 1; j < (i + 1 + k); j++) {
                        if (num < Character.getNumericValue(number.charAt(j))) {
                            flag = true;
                            break;
                        }
                    }
                }
            }
            if (flag) k--;
            else sb.append(String.valueOf(c));
        }
        return sb.toString();
    }
}

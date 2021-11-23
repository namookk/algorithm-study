package com.algorithm.programmers.y2021.m11.d23;

//https://programmers.co.kr/learn/courses/30/lessons/17681
public class Solution3 {
    public static void main(String[] args) {
        int n = 6;
        int[] arr1 = {46, 33, 33 ,22, 31, 50};
        int[] arr2 = {27 ,56, 19, 14, 14, 10};
        for(String str : solution(n, arr1, arr2)){
            System.out.println(str);
        }
     }

    public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for(int i = 0; i < n; i++) {
            answer[i] = Integer.toBinaryString(arr1[i] | arr2[i]).replaceAll("1","#").replaceAll("0", " ");
            while(answer[i].length() < n) {
                answer[i] = " " + answer[i];
            }
        }
        return answer;
    }
}

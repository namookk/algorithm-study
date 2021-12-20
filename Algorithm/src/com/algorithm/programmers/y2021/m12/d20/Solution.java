package com.algorithm.programmers.y2021.m12.d20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


//https://programmers.co.kr/learn/courses/30/lessons/42839

//  정확성  테스트
//        테스트 1 〉	통과 (1.41ms, 72.7MB)
//        테스트 2 〉	통과 (7.61ms, 84.5MB)
//        테스트 3 〉	통과 (0.31ms, 73.2MB)
//        테스트 4 〉	통과 (5.53ms, 72.7MB)
//        테스트 5 〉	통과 (23.98ms, 91.1MB)
//        테스트 6 〉	통과 (0.33ms, 70MB)
//        테스트 7 〉	통과 (1.42ms, 83.2MB)
//        테스트 8 〉	통과 (14.98ms, 93.7MB)
//        테스트 9 〉	통과 (0.41ms, 73.8MB)
//        테스트 10 〉	통과 (7.44ms, 76.7MB)
//        테스트 11 〉	통과 (3.17ms, 79MB)
//        테스트 12 〉	통과 (2.51ms, 72.5MB)
public class Solution {
    public static void main(String[] args) {
        String numbers = "17";
        System.out.println(solution(numbers));
    }
    public static int solution(String numbers) {
        int answer = 0;

        List<Integer> lists = new ArrayList<>();
        List<String> list = new ArrayList<>();
        String[] arr = numbers.split("");
        int[] ch = new int[arr.length];
        dfs(arr, list, lists, ch);

        System.out.println(lists);

        return lists.size();
    }


    public static void dfs(String[] arr, List<String> list, List<Integer> answer, int[] ch) {
        for(int i = 0; i < arr.length; i++) {
            if(ch[i] == 0 && list.size() < arr.length) {
                ch[i] = 1;
                list.add(arr[i]);
                int num = Integer.parseInt(String.join("", list));
                if(isPrime(num) && !answer.contains(num) && num > 0) {
                    answer.add(num);
                }
                dfs(arr, list, answer, ch);
                ch[i] = 0;
                list.remove(list.size() - 1);
            }
        }
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

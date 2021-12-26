package com.algorithm.programmers.y2021.m12.d27;

import java.util.Arrays;

//https://programmers.co.kr/learn/courses/30/lessons/12904
//정확성  테스트
//    테스트 1 〉	통과 (0.06ms, 73.9MB)
//    테스트 2 〉	통과 (0.07ms, 75.6MB)
//    테스트 3 〉	통과 (0.41ms, 84.2MB)
//    테스트 4 〉	통과 (0.44ms, 85.7MB)
//    테스트 5 〉	통과 (0.35ms, 76.8MB)
//    테스트 6 〉	통과 (0.30ms, 74.7MB)
//    테스트 7 〉	통과 (0.29ms, 73.3MB)
//    테스트 8 〉	통과 (0.38ms, 76.2MB)
//    테스트 9 〉	통과 (0.38ms, 70.5MB)
//    테스트 10 〉	통과 (0.52ms, 73.9MB)
//    테스트 11 〉	통과 (0.27ms, 76.5MB)
//    테스트 12 〉	통과 (0.20ms, 81.1MB)
//    테스트 13 〉	통과 (0.33ms, 71.6MB)
//    테스트 14 〉	통과 (0.54ms, 77.4MB)
//    테스트 15 〉	통과 (0.58ms, 71.7MB)
//    테스트 16 〉	통과 (0.64ms, 77.6MB)
//    테스트 17 〉	통과 (0.03ms, 77.9MB)
//    테스트 18 〉	통과 (0.04ms, 79.3MB)
//    테스트 19 〉	통과 (0.38ms, 73.5MB)
//    테스트 20 〉	통과 (0.32ms, 74.8MB)
//    테스트 21 〉	통과 (0.31ms, 73.6MB)
//    효율성  테스트
//    테스트 1 〉	통과 (6.28ms, 62.5MB)
//    테스트 2 〉	통과 (30.98ms, 66.6MB)
public class Solution {
    public static void main(String[] args) {
        String s = "aaabaaabaaaaaaa";
        String s1 = "abbabb";
        //1 1 1 1 3
        //System.out.println(solution(s));
        System.out.println(solution(s1));
    }

    public static int solution(String s) {
        int answer = 1;
        int[] dy = new int[s.length()];
        Arrays.fill(dy, 1);
        for(int i = 1; i < dy.length; i++){
            boolean flag = false;
            int start = i - dy[i-1] - 1 >= 0 ? i - dy[i-1] - 1 : i - dy[i-1];
            while(start < i){
                String newS = s.substring(start, i+1);
                String reverseNewS = new StringBuilder(newS).reverse().toString();
                if(newS.equals(reverseNewS)) {
                    dy[i] = newS.length();
                    break;
                }
                start++;
            }
            answer = Math.max(answer, dy[i]);
        }

        for(int i : dy) System.out.print(i + " ");
        System.out.println();
        return answer;
    }
}

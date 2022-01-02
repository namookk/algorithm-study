package com.algorithm.programmers.y2022.m1.d2;

import java.util.Stack;

//https://programmers.co.kr/learn/courses/30/lessons/12973
//정확성  테스트
//    테스트 1 〉	통과 (0.27ms, 76.3MB)
//    테스트 2 〉	통과 (11.12ms, 81.2MB)
//    테스트 3 〉	통과 (13.25ms, 79MB)
//    테스트 4 〉	통과 (13.20ms, 86MB)
//    테스트 5 〉	통과 (13.16ms, 80.7MB)
//    테스트 6 〉	통과 (13.00ms, 84MB)
//    테스트 7 〉	통과 (13.33ms, 94.1MB)
//    테스트 8 〉	통과 (11.37ms, 90MB)
//    테스트 9 〉	통과 (0.15ms, 77.5MB)
//    테스트 10 〉	통과 (0.24ms, 71.8MB)
//    테스트 11 〉	통과 (0.18ms, 73.2MB)
//    테스트 12 〉	통과 (0.20ms, 76.5MB)
//    테스트 13 〉	통과 (0.17ms, 75.9MB)
//    효율성  테스트
//    테스트 1 〉	통과 (71.27ms, 64.4MB)
//    테스트 2 〉	통과 (44.12ms, 58.2MB)
//    테스트 3 〉	통과 (52.21ms, 60.8MB)
//    테스트 4 〉	통과 (55.76ms, 60.8MB)
//    테스트 5 〉	통과 (55.14ms, 60.4MB)
//    테스트 6 〉	통과 (54.69ms, 60.6MB)
//    테스트 7 〉	통과 (54.41ms, 60.6MB)
//    테스트 8 〉	통과 (54.89ms, 60.8MB)
public class Solution2 {

    public static void main(String[] args) {
        String s = "baabaa";
        System.out.println(solution(s));
    }
    private static int solution(String s){
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(stack.isEmpty()) stack.add(c);
            else{
                if(stack.peek() == c) stack.pop();
                else stack.add(c);
            }
        }

        return stack.isEmpty() ? 1 : 0;
    }
}

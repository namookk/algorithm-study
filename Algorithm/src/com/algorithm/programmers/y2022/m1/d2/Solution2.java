package com.algorithm.programmers.y2022.m1.d2;

import java.util.Stack;

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

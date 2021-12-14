package com.algorithm.inflearn2.chapter6;

import java.util.Stack;

public class Main6_2 {
    public static void main(String[] args) {
        String s = "([)]";
        System.out.println(solve(s));
    }

    public static boolean solve(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()) {
            if(c == '(' || c == '{' || c == '[') {
                stack.add(c);
            }else if(c == ')' && !stack.isEmpty() && stack.peek() == '('){
                stack.pop();
            }else if(c == '}' && !stack.isEmpty() && stack.peek() == '{'){
                stack.pop();
            }else if(c == ']' && !stack.isEmpty() && stack.peek() == '['){
                stack.pop();
            }else{
                return false;
            }
        }

        return stack.isEmpty();
    }
}

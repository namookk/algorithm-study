package com.algorithm.inflearn2.chapter7;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main7_9 {
    public static void main(String[] args) {
        String s = "(a)())()";
        for(String str : solve(s)) System.out.print(str +" ");
    }

    public static List<String> solve(String s) {
        List<String> answer = new ArrayList<>();
        for(int i = 0; i < s.length(); i++) {
            String new_str = s.substring(0, i) + s.substring(i + 1, s.length());
            if(valid(new_str) && answer.indexOf(new_str) == -1) answer.add(new_str);
        }
        return answer;
    }

    public static boolean valid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()) {
            if(c == '(') stack.add(c);
            else if(c == ')' && !stack.isEmpty() && stack.peek() == '(') stack.pop();
            else if(c != ')' && c != '(') {}
            else return false;
        }
        return stack.isEmpty();
    }
}

package com.algorithm.inflearn2.chapter7;

import java.util.*;

public class Main7_9 {
    public static void main(String[] args) {
        String s = "(a)())()";
        for(String str : solve(s)) System.out.print(str +" ");
        System.out.println();
        for(String str : re_solve(s)) System.out.print(str + " ");
    }

    public static List<String> solve(String s) {
        List<String> answer = new ArrayList<>();
        for(int i = 0; i < s.length(); i++) {
            String new_str = s.substring(0, i) + s.substring(i + 1);
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

    //====================================================
    //bfs 사용
    public static List<String> re_solve(String s){
        //1. ds
        List<String> res = new ArrayList<>();
        if(s == null) return res;

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(s);
        visited.add(s);
        boolean found = false;

        //2
        while(!queue.isEmpty()) {
            int len = queue.size();
            for(int i = 0; i < len; i++) {
                String str = queue.poll();
                if(isValid(str)) {
                    res.add(str);
                    found = true;
                }
                if(found) continue;
                for(int j = 0; j < str.length(); j++) {

                    if(str.charAt(j) != ')' && str.charAt(j) != '(') continue;

                    String newStr = str.substring(0, j) + str.substring(j+1);
                    if(!visited.contains(newStr)) {
                        queue.offer(newStr);
                        visited.add(newStr);
                    }
                }
            }
        }
        return res;
    }
    public static boolean isValid(String str) {
        int count = 0;
        for(char c : str.toCharArray()) {
            if(c == '(') count++;
            else if(c == ')') {
                count--;
                if(count < 0) return false;
            }
        }
        return count == 0;
    }
}

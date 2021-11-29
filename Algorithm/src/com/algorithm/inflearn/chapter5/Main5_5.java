package com.algorithm.inflearn.chapter5;

import java.util.*;

public class Main5_5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.print(solution(s));
    }

    public static int solution(String s) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(') {
                if(s.charAt(i+1) == ')') {
                    i++;
                    continue;
                }else{
                    stack.push(i);
                }
            }else{
                Integer startIdx = stack.pop();
                String str = s.substring(startIdx, i+1);
                int idx = str.indexOf("()");
                answer++;
                while (idx != -1) {
                    answer++;
                    idx = str.indexOf("()", idx+1);
                }
            }
        }
        return answer;
    }
}
package com.algorithm.m10.d1;

import java.util.*;

public class Main5_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        System.out.print(solution(s1));
    }

    public static String solution(String s) {
        String answer = "";
        Queue<String> queue = new LinkedList<>();
        for(char c : s.toCharArray()) {
            if(c == ')') {
                queue.poll();
            }else if(c == '('){
                queue.offer("(");
            }else if(queue.size() == 0){
                answer += Character.toString(c);
            }
        }
        return answer;
    }
}
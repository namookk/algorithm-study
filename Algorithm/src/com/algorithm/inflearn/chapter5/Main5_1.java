package com.algorithm.inflearn.chapter5;


import java.util.*;

public class Main5_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        System.out.print(solution(s1));
    }

    public static String solution(String s) {
        String answer = "YES";
        Queue<String> queue = new LinkedList<>();
        for(char c : s.toCharArray()) {
            if(c == ')') {
                if(queue.poll() == null) return "NO";
            }else{
                queue.offer("(");
            }
        }
        return queue.size() > 0 ? "NO" : answer;
    }
}
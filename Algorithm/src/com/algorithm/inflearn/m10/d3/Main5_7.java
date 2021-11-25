package com.algorithm.inflearn.m10.d3;

import java.util.*;

public class Main5_7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String required = sc.nextLine();
        String cls = sc.nextLine();
        System.out.print(solution(required, cls));
    }

    public static String solution(String required, String cls) {
        String answer = "YES";
        Queue<String> queue = new LinkedList<>();
        List<String> reqList = Arrays.asList(required.split(""));
        for(String s : reqList) {
            queue.offer(s);
        }
        for(char c : cls.toCharArray()) {
            String s = String.valueOf(c);
            if(reqList.indexOf(s) > -1 && !s.equals(queue.poll())) {
                return "NO";
            }
        }
        return queue.size() > 0 ? "NO" : answer;
    }
}

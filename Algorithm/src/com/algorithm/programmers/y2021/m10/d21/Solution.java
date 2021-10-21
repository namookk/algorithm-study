package com.algorithm.programmers.y2021.m10.d21;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        String s = "}]()[{";
        System.out.println(solution(s));
    }
    public static int solution(String s) {
        int answer = 0;
        String str = s;
        int level = -1;
        List<String> openArr = Arrays.asList(new String[]{"[", "{", "("});
        List<String> closeArr = Arrays.asList(new String[]{"]", "}", ")"});
        while(level < s.length() - 1){
            level++;
            str = s.substring(level,s.length()) + s.substring(0,level);
            Stack<String> stack = new Stack<>();
            boolean flag = true;
            for(char c : str.toCharArray()) {
                String s1 = String.valueOf(c);
                if(openArr.indexOf(s1) > -1) {
                    stack.add(s1);
                }else{
                    if(stack.empty()){
                        flag = false;
                        break;
                    }
                    String s2 = stack.pop();
                    if(closeArr.indexOf(s1) != openArr.indexOf(s2)) {
                        flag = false;
                        break;
                    }
                }
            }
            if(flag && stack.empty()) answer++;
        }

        return answer;
    }
}

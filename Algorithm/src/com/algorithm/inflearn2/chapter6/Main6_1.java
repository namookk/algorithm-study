package com.algorithm.inflearn2.chapter6;

import java.util.Stack;

public class Main6_1 {
    public static void main(String[] args) {
        String[] cmds = {"5","-2","4","C","D","9","+","+"};

        System.out.println(solve(cmds));
    }

    public static int solve(String[] cmds) {
        Stack<Integer> stack = new Stack<>();
        for(String cmd : cmds) {
            if(cmd.equals("+")) {
               int num1 = stack.pop();
               int num2 = stack.pop();
               stack.add(num2);
               stack.add(num1);
               stack.add(num1 + num2);
            }else if(cmd.equals("C")){
                stack.pop();
            }else if(cmd.equals("D")){
                int num = stack.peek();
                stack.add(num * 2);
            }else{
                stack.add(Integer.parseInt(cmd));
            }
        }
        int answer = 0;
        while(!stack.isEmpty()){
            int num = stack.pop();
            answer += num;
            System.out.print(num + " ");
        }
        return answer;
    }
}

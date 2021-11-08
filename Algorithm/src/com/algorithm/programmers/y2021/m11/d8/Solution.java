package com.algorithm.programmers.y2021.m11.d8;

import java.util.Stack;

public class Solution {
    static int[] deleted;
    static int curr;
    static Stack<Integer> stack = new Stack<>();
    public static void main(String[] args) {
        int n = 8;
        int k = 2;
        String[] cmd = {"D 2","C","U 3","C","D 4","C","U 2","Z","Z","U 1","C"};
        System.out.println(solution(n, k, cmd));
    }

    public static String solution(int n, int k, String[] cmds) {
        deleted = new int[n];
        curr = k;
        for(String cmd : cmds) {
            String[] cmdArr = cmd.split(" ");
            String command = cmdArr[0];
            if(command.equals("U")){
                doUp(Integer.parseInt(cmdArr[1]));
            }else if(command.equals("D")){
                doDown(Integer.parseInt(cmdArr[1]));
            }else if(command.equals("C")){
                doDelete();
            }else{
                doCancel();
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int delete : deleted){
            if(delete == 0) sb.append("O");
            else sb.append("X");
        }
        return sb.toString();
    }

    public static void doUp(int num) {
        while(num > 0) {
            if(curr == 0) break;
            if(deleted[--curr] == 0) num--;
        }
    }
    public static void doDown(int num) {
        while(num > 0) {
            if(curr == deleted.length - 1) break;
            if(deleted[++curr] == 0) num--;
        }
    }
    public static void doDelete() {
        deleted[curr] = 1;
        stack.push(curr);
        int orgIdx = curr;
        doDown(1);
        if(curr == orgIdx) doUp(1);
    }
    public static void doCancel() {
        if(!stack.isEmpty()){
            int idx = stack.pop();
            deleted[idx] = 0;
        }
    }
}


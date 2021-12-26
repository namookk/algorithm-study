package com.algorithm.programmers.y2021.m12.d26;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//https://programmers.co.kr/learn/courses/30/lessons/81303
//정확성  테스트
//    테스트 1 〉	통과 (0.20ms, 75.4MB)
//    테스트 2 〉	통과 (0.35ms, 84.2MB)
//    테스트 3 〉	통과 (0.24ms, 74.3MB)
//    테스트 4 〉	통과 (0.30ms, 74.1MB)
//    테스트 5 〉	통과 (0.68ms, 76.9MB)
//    테스트 6 〉	통과 (0.56ms, 84.3MB)
//    테스트 7 〉	통과 (0.55ms, 72.3MB)
//    테스트 8 〉	통과 (0.49ms, 73.3MB)
//    테스트 9 〉	통과 (0.51ms, 75.2MB)
//    테스트 10 〉	통과 (0.53ms, 71.8MB)
//    테스트 11 〉	통과 (1.67ms, 75.2MB)
//    테스트 12 〉	통과 (1.82ms, 77MB)
//    테스트 13 〉	통과 (2.59ms, 77.8MB)
//    테스트 14 〉	통과 (1.80ms, 88MB)
//    테스트 15 〉	통과 (2.00ms, 76.6MB)
//    테스트 16 〉	통과 (1.86ms, 80.2MB)
//    테스트 17 〉	통과 (2.60ms, 74.6MB)
//    테스트 18 〉	통과 (2.53ms, 77.3MB)
//    테스트 19 〉	통과 (2.70ms, 79.2MB)
//    테스트 20 〉	통과 (3.03ms, 91.9MB)
//    테스트 21 〉	통과 (2.57ms, 76.1MB)
//    테스트 22 〉	통과 (2.38ms, 79.2MB)
//    테스트 23 〉	통과 (0.24ms, 76.7MB)
//    테스트 24 〉	통과 (0.32ms, 76.9MB)
//    테스트 25 〉	통과 (0.22ms, 77MB)
//    테스트 26 〉	통과 (0.23ms, 86.8MB)
//    테스트 27 〉	통과 (0.31ms, 76.1MB)
//    테스트 28 〉	통과 (0.33ms, 72.7MB)
//    테스트 29 〉	통과 (0.32ms, 78.7MB)
//    테스트 30 〉	통과 (0.28ms, 77.5MB)
//효율성  테스트
//    테스트 1 〉	실패 (시간 초과)
//    테스트 2 〉	실패 (시간 초과)
//    테스트 3 〉	실패 (시간 초과)
//    테스트 4 〉	실패 (시간 초과)
//    테스트 5 〉	실패 (시간 초과)
//    테스트 6 〉	실패 (시간 초과)
//    테스트 7 〉	통과 (465.55ms, 103MB)
//    테스트 8 〉	실패 (시간 초과)
//    테스트 9 〉	실패 (시간 초과)
//    테스트 10 〉	실패 (시간 초과)
public class Solution {
    public static void main(String[] args) {
        int n = 8;
        int k = 2;
        String[] cmds = {"D 2","C","U 3","C","D 4","C","U 2","Z","Z"};
        String[] cmds2 = {"D 2","C","U 3","C","D 4","C","U 2","Z","Z","U 1","C"};
        System.out.println(re_solution(n,k,cmds));
        System.out.println(re_solution(n,k,cmds2));
    }
    public static String solution(int n, int k, String[] cmds){
        int[] arr = new int[n];
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            list.add(i);
        }
        int idx = k;
        Stack<int[]> deleted = new Stack<>();
        for(String cmd : cmds){
            String[] cmdArr = cmd.split(" ");
            Integer num = cmdArr.length > 1 ? Integer.parseInt(cmdArr[1]) : 0;
            if(cmdArr[0].equals("U")){
                idx = idx - num < 0 ? 0 : idx - num;
            }else if(cmdArr[0].equals("D")){
                idx = idx + num >= list.size() ? list.size() - 1 : idx + num;
            }else if(cmdArr[0].equals("C")){
                arr[list.get(idx)] = 1;
                deleted.add(new int[]{idx, list.get(idx)});
                list.remove(idx);
                if(idx >= list.size()) idx = list.size() - 1;
            }else{
                int[] delete = deleted.pop();
                arr[delete[1]] = 0;
                list.add(delete[0], delete[1]);
                if(delete[0] < idx) idx++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == 0) sb.append("O");
            else sb.append("X");
        }
        return sb.toString();
    }

    public static String re_solution(int n, int k, String[] cmds){
        int[] prev = new int[n];
        int[] next = new int[n];
        for(int i = 0; i < n; i++){
            prev[i] = i - 1;
            next[i] = i + 1;
        }
        next[n - 1] = -1;

        Stack<Node> stack = new Stack<>();
        StringBuilder sb = new StringBuilder("O".repeat(n));
        for(String cmd : cmds){
            String[] cmdArr = cmd.split(" ");
            int num = cmdArr.length > 1 ? Integer.parseInt(cmdArr[1]) : 0;
            String cmdStr = cmdArr[0];
            if(cmdStr.equals("U")){
                while(num-- > 0) k = prev[k];
            }else if(cmdStr.equals("D")){
                while(num-- > 0) k = next[k];
            }else if(cmdStr.equals("C")){
                stack.add(new Node(prev[k], next[k], k));
                if(prev[k] != -1) next[prev[k]] = next[k];
                if(next[k] != -1) prev[next[k]] = prev[k];
                sb.setCharAt(k, 'X');

                if(next[k] != -1) k = next[k];
                else k = prev[k];
            }else{
                Node node = stack.pop();
                if(node.prev != -1) next[node.prev] = node.curr;
                if(node.next != -1) prev[node.next] = node.curr;
                sb.setCharAt(node.curr, 'O');
            }
        }

        return sb.toString();
    }
}

class Node{
    int prev, next, curr;
    public Node(int prev, int next, int curr){
        this.prev = prev;
        this.next = next;
        this.curr = curr;
    }
}
package com.algorithm.inflearn2.chapter9;

import java.util.*;

public class Main9_1 {
    public static void main(String[] args) {
        int n = 3;

        for(String str : solve(n)) System.out.println(str);
    }

    public static List<String> solve(int n) {
        List<String> result = new ArrayList<>();
        String[] arr = {"(", ")"};
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(1, 1, new StringBuilder("(")));

        while(!q.isEmpty()) {
            int len = q.size();
            for(int i = 0; i < len; i++) {
                Node node = q.poll();
                if(node.level == n && node.count == 0) {
                    result.add(node.sb.toString());
                }else{
                    for(String s : arr){
                        int count = node.count;
                        int level = node.level;
                        StringBuilder new_sb = new StringBuilder(node.sb.toString());
                        if(s.equals(")") && count > 0) {
                            new_sb.append(")");
                            q.offer(new Node(count - 1, level, new_sb));
                        }else if(s.equals("(") && level < n){
                            new_sb.append("(");
                            q.offer(new Node(count + 1, level + 1, new_sb));
                        }
                    }
                }
            }
        }

        return result;
    }
}

class Node{
    int count;
    int level;
    StringBuilder sb;

    Node(int count, int level, StringBuilder sb) {
        this.count = count;
        this.level = level;
        this.sb = sb;
    }
}
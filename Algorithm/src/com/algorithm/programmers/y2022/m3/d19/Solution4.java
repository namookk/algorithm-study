package com.algorithm.programmers.y2022.m3.d19;

import java.util.HashMap;
import java.util.Map;

public class Solution4 {
    public static void main(String[] args) {
        String[] directory = {
                "/",
                "/hello",
                "/hello/tmp",
                "/root",
                "/root/abcd",
                "/root/abcd/etc",
                "/root/abcd/hello"
        };

        String[] command = {
                "mkdir /root/tmp",
                "cp /hello /root/tmp",
                "rm /hello"
        };

        String[] result = solution(directory, command);
        for(String dir : result){
            System.out.println(dir);
        }
    }

    private static String[] solution(String[] directory, String[] command) {
        Node root = new Node(null);

        for (String dir: directory) {
            if(dir.equals("/")) continue;
            String[] split = dir.split("/");
            Node node = root;
            for(int i = 1; i < split.length; i++){
                if(node.enter(split[i]) == null) {
                    node.mkdir(split[i]);
                }else{
                    node = node.enter(split[i]);
                }
            }
        }

        return new String[0];
    }
}

class Node{
    Map<String, Node> dir;
    Node parent;

    Node(Node parent) {
        dir = new HashMap<>();
        this.parent = parent;
    }

    void mkdir(String name) {
        dir.put(name, new Node(this));
    }

    Node enter(String name) {
        if(!dir.containsKey(name)) return null;
        return dir.get(name);
    }
}

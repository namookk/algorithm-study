package com.algorithm.inflearn2.chapter7;

import java.util.LinkedList;
import java.util.Queue;

public class Main7_7 {
    public static void main(String[] args) {
        String begin = "hit";
        String end = "cog";
        String[] words = {"hot","dot","dog","lot","log","cog"};

        System.out.println(solve(begin, end, words));
    }

    public static int solve(String begin, String end, String[] words) {
        Queue<Node> queue = new LinkedList<>();
        int[] ch = new int[words.length];
        for(int i = 0; i < words.length; i++){
            if(words[i].equals(begin)) ch[i] = 1;
        }
        queue.offer(new Node(begin, ch));
        int answer = 1;
        while(!queue.isEmpty()) {
            int len = queue.size();
            for(int i = 0; i < len; i++) {
                Node node = queue.poll();
                int[] new_ch = node.ch;
                for(int j = 0; j < words.length; j++){
                    if(new_ch[j] == 0 && checkWord(node.word, words[j])){
                        if(words[j].equals(end)) return answer;
                        new_ch[j] = 1;
                        queue.offer(new Node(words[j], new_ch));
                    }
                }
            }
            answer++;
        }
        return 0;
    }

    public static boolean checkWord(String word1, String word2) {
       char[] c1 = word1.toCharArray();
       char[] c2 = word2.toCharArray();
       int count = 0;
       for(int i = 0; i < c1.length; i++) {
           if(c1[i] != c2[i]) count++;
           if(count > 1) return false;
       }
       return count == 1 ? true : false;
    }
}

class Node{
    String word;
    int[] ch;
    Node(String word){
        this.word = word;
    }
    Node(String word, int[] ch){
        this.word = word;
        this.ch = ch;
    }
}

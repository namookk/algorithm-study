package com.algorithm.smh.week1;

import java.util.PriorityQueue;

public class Solution1 {
    public static void main(String[] args) {
        String[] words = {"word","war","warrior","world"};
        System.out.println(solution(words));
    }

    private static int solution(String[] words){
        PriorityQueue<String> pq = new PriorityQueue<>();
        for(String str : words){
            pq.offer(str);
        }
        int answer = 0;
        String nextStr = "";
        String prevStr = "";
        while(!pq.isEmpty()){
            String str = pq.poll();
            if(!pq.isEmpty()) {
                nextStr = pq.peek();
            }else{
                nextStr = "";
            }
            int idx = 1;
            String subStr = str.substring(0,idx);
            while(nextStr.startsWith(subStr) || prevStr.startsWith(subStr)){
                if(idx + 1 > str.length()) break;
                subStr = str.substring(0,++idx);
            }
            answer += subStr.length();
            prevStr = str;
        }
        return answer ;
    }
}

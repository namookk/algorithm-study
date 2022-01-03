package com.algorithm.smh.week1;

import java.util.PriorityQueue;

//https://programmers.co.kr/learn/courses/30/lessons/17685?language=java
//정확성  테스트
//    테스트 1 〉	통과 (0.49ms, 74MB)
//    테스트 2 〉	통과 (0.34ms, 72.8MB)
//    테스트 3 〉	통과 (0.33ms, 67.3MB)
//    테스트 4 〉	통과 (0.44ms, 73.2MB)
//    테스트 5 〉	통과 (0.37ms, 75MB)
//    테스트 6 〉	통과 (108.40ms, 132MB)
//    테스트 7 〉	통과 (0.36ms, 76.2MB)
//    테스트 8 〉	통과 (96.65ms, 121MB)
//    테스트 9 〉	통과 (0.54ms, 74.1MB)
//    테스트 10 〉	통과 (0.50ms, 74.4MB)
//    테스트 11 〉	통과 (0.39ms, 72.3MB)
//    테스트 12 〉	통과 (148.56ms, 113MB)
//    테스트 13 〉	통과 (109.19ms, 126MB)
//    테스트 14 〉	통과 (1.59ms, 80.6MB)
//    테스트 15 〉	통과 (0.37ms, 70.6MB)
//    테스트 16 〉	통과 (97.46ms, 144MB)
//    테스트 17 〉	통과 (96.55ms, 122MB)
//    테스트 18 〉	통과 (0.37ms, 73.7MB)
//    테스트 19 〉	통과 (0.96ms, 86.7MB)
//    테스트 20 〉	통과 (147.99ms, 128MB)
//    테스트 21 〉	통과 (1.02ms, 79.6MB)
//    테스트 22 〉	통과 (0.47ms, 91.9MB)
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

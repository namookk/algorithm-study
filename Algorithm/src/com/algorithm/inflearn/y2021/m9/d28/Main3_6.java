package com.algorithm.inflearn.y2021.m9.d28;

import java.util.*;

public class Main3_6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        sc.nextLine();
        String s = sc.nextLine();
        System.out.print(solution(k, s));
    }

    public static int solution(int k, String s) {
        String[] arr = s.replaceAll(" ","").split("0");
        int maxLen = 0;
        int currLen = 0;
        Queue<Integer> queue = new LinkedList<>();
        for(String str : arr) {
            currLen += str.length();
            queue.offer(str.length());
            if(queue.size() > k+1) {
                currLen -= queue.poll();
            }
            if(currLen > maxLen) maxLen = currLen;
        }
        return maxLen + k;
    }
}

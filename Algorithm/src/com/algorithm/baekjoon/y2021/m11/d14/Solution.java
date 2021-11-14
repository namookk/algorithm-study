package com.algorithm.baekjoon.y2021.m11.d14;

import java.util.Arrays;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        Queue<Integer> queue = new LinkedList<>();
        int cnt = 0;
        Integer last = null;
        for(int i = 0; i < n; i++) {
            String command = sc.nextLine();
            String[] arr = command.split(" ");
            if(arr[0].equals("push")){
                queue.offer(Integer.parseInt(arr[1]));
                cnt++;
                last = Integer.parseInt(arr[1]);
            }else if(arr[0].equals("pop")){
                Integer num = queue.poll();
                if(num != null) cnt--;
                System.out.println(num == null ? -1 : num);
            }else if(arr[0].equals("size")){
                System.out.println(queue.size());
            }else if(arr[0].equals("empty")){
                System.out.println(queue.isEmpty() ? 1 : 0);
            }else if(arr[0].equals("front")){
                System.out.println(queue.peek() != null ? queue.peek() : -1);
            }else if(arr[0].equals("back")){
                if(cnt > 0 ) System.out.println(last);
                else System.out.println(-1);
            }
        }
    }
}

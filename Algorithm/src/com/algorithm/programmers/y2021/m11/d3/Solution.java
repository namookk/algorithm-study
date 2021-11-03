package com.algorithm.programmers.y2021.m11.d3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {
        int n = 6;
        int[][] edge = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};

        System.out.println(solution(n, edge));
    }

    public static int solution(int n, int[][] edge) {
        int[] ch = new int[n+1];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        ch[1] = 1;
        List<Integer> list = new ArrayList<>();
        while(!queue.isEmpty()) {
            int len = queue.size();
            boolean resetfl = false;
            for(int i = 0 ; i < len; i++) {
                Integer num = queue.poll();
                for(int j = 0; j < edge.length; j++) {
                    if(edge[j][0] == num && ch[edge[j][1]] == 0) {
                        if(!resetfl) {
                            list = new ArrayList<>();
                            resetfl = true;
                        }
                        ch[edge[j][1]] = 1;
                        list.add(edge[j][1]);
                        queue.offer(edge[j][1]);
                    }
                    if(edge[j][1] == num && ch[edge[j][0]] == 0) {
                        if(!resetfl) {
                            list = new ArrayList<>();
                            resetfl = true;
                        }
                        ch[edge[j][0]] = 1;
                        list.add(edge[j][0]);
                        queue.offer(edge[j][0]);
                    }
                }
            }
        }

        return list.size();
    }
}

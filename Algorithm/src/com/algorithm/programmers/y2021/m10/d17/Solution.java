package com.algorithm.programmers.y2021.m10.d17;

import java.util.LinkedList;
import java.util.Queue;

//https://programmers.co.kr/learn/courses/30/lessons/43165
public class Solution {
    public static void main(String[] args) {
        int[] numbers = {1,1,1,1,1};
        int target = 3;

        System.out.println(solution(numbers, target));

    }

    public static int solution(int[] numbers, int target) {
        int answer = 0;
        int level = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        while(level < numbers.length) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                Integer num = queue.poll();
                queue.offer(num + numbers[level]);
                queue.offer(num - numbers[level]);
            }
            level++;
        }
        while(!queue.isEmpty()){
            Integer num = queue.poll();
            if(num == target) answer++;
        }
        return answer;
    }
}

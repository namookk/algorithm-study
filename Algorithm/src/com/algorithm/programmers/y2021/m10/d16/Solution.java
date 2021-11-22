package com.algorithm.programmers.y2021.m10.d16;

import java.util.*;
import java.util.stream.Collectors;
//https://programmers.co.kr/learn/courses/30/lessons/42587
public class Solution {
    public static void main(String[] args) {
        int[] priorities = {1, 1, 9, 1, 1, 1};
        int location = 0;

        System.out.println(solution(priorities, location));
    }
    public static int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Printer> queue = new LinkedList<>();
        List<Integer> sortedList = Arrays.stream(priorities)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        for(int i = 0 ; i < priorities.length; i++) {
            queue.offer(new Printer(priorities[i] , i == location));
        }

        while(!queue.isEmpty()){
            Printer printer = queue.poll();
            if(sortedList.get(0) > printer.priority) {
                queue.offer(printer);
            }else{
                answer++;
                sortedList.remove(0);
                if(printer.mine) break;
            }
        }

        return answer;
    }
}

class Printer{
    int priority;
    boolean mine;

    public Printer(int _priority, boolean _mine) {
        priority = _priority;
        mine = _mine;
    }
}

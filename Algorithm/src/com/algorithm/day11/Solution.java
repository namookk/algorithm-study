package com.algorithm.day11;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

        System.out.println(solution(array, commands));
    }

    public static int[] solution(int[] array, int[][] commands){
        int[] answer = new int[commands.length];

        for(int idx = 0; idx < commands.length; idx++){
            int[] command = commands[idx];
            int start = command[0];
            int end = command[1];
            int index = command[2];
            List<Integer> list = new ArrayList<>();
            for(int i = start - 1; i < end; i++){
                list.add(array[i]);
            }
            list.sort((a,b) -> {
                return a-b;
            });
            answer[idx] = list.get(index - 1);
        }
        return answer;
    }
}

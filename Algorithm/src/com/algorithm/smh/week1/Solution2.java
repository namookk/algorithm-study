package com.algorithm.smh.week1;

import java.util.Collections;
import java.util.PriorityQueue;

//https://programmers.co.kr/learn/courses/30/lessons/42628
//정확성  테스트
//    테스트 1 〉	통과 (0.42ms, 75.6MB)
//    테스트 2 〉	통과 (0.46ms, 72.2MB)
//    테스트 3 〉	통과 (0.50ms, 77.6MB)
//    테스트 4 〉	통과 (0.43ms, 74.7MB)
//    테스트 5 〉	통과 (0.48ms, 73.8MB)
//    테스트 6 〉	통과 (0.67ms, 74.4MB)
public class Solution2 {
    public static void main(String[] args) {
        String[] operations = {"I 7","I 5","I -5","D -1"};
        int[] result = solution(operations);
        System.out.println(result[0] + " " +result[1]);
    }

    private static int[] solution(String[] operations){
        int[] answer = new int[2];
        PriorityQueue<Integer> ascq = new PriorityQueue<>();
        PriorityQueue<Integer> descq = new PriorityQueue<>(Collections.reverseOrder());

        for(String oper : operations){
            String[] opers = oper.split(" ");
            String command = opers[0];
            int num = Integer.parseInt(opers[1]);

            switch(command){
                case "I":
                    ascq.offer(num);
                    descq.offer(num);
                    break;
                case "D":
                    if(!ascq.isEmpty()) {
                        if (num > 0) {
                            ascq.remove(descq.poll());
                        } else {
                            descq.remove(ascq.poll());
                        }
                    }
                    break;
                default:
                    break;
            }
        }

        if(!ascq.isEmpty()){
            answer[0] = descq.poll();
            answer[1] = ascq.poll();
        }

        return answer;
    }
}

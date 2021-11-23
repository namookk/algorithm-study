package com.algorithm.programmers.y2021.m10.d26;

import java.util.*;
//https://programmers.co.kr/learn/courses/30/lessons/67257
public class Solution {
    public static void main(String[] args) {
        String expression = "100-200*300-500+20";
        System.out.println(solution(expression));
    }

    public static long solution(String expression) {
        long answer = Long.MIN_VALUE;
        List<Long> numList= new ArrayList<>();
        List<Giho> gihoList = new ArrayList<>();
        String numStr = "";
        List<Giho> gihoEx = new ArrayList<>();
        gihoEx.add(Giho.MINUS);
        gihoEx.add(Giho.MULTIPLICATION);
        gihoEx.add(Giho.PLUS);

        for(char c : expression.toCharArray()) {
            if(Character.isDigit(c)){
                numStr += String.valueOf(c);
            }else{
                Long num = Long.valueOf(numStr);
                numList.add(num);
                numStr = "";

                if(c == '*') gihoList.add(Giho.MULTIPLICATION);
                else if(c == '+') gihoList.add(Giho.PLUS);
                else if(c == '-') gihoList.add(Giho.MINUS);
            }
        }

        Long num = Long.valueOf(numStr);
        numList.add(num);

        Queue<Priority> priortyQueue = new LinkedList<>();
        priortyQueue.offer(new Priority(numList, gihoList, null));

        while(!priortyQueue.isEmpty()) {
            int len = priortyQueue.size();
            for(int i = 0; i < len; i++) {
                Priority priority = priortyQueue.poll();
                if(priority.numList.size() > 1) {
                    for(Giho g : gihoEx){
                        if(priority.visited.indexOf(g) == -1) {
                            List<Giho> temp_gihoList = new ArrayList<>(priority.gihoList);
                            List<Long> temp_numList = new ArrayList<>(priority.numList);
                            List<Giho> visited = new ArrayList<>(priority.visited);
                            for(int j = 0; j < temp_gihoList.size(); j++) {
                                Giho g2 = temp_gihoList.get(j);

                                if(g.equals(g2)) {
                                    Long num1 = temp_numList.get(j);
                                    Long num2 = temp_numList.get(j+1);
                                    Long output = null;
                                    if(g.equals(Giho.MINUS)){
                                        output = num1 - num2;
                                    }else if(g.equals(Giho.MULTIPLICATION)){
                                        output = num1 * num2;
                                    }else if(g.equals(Giho.PLUS)){
                                        output = num1 + num2;
                                    }
                                    temp_numList.remove(j+1);
                                    temp_numList.set(j, output);
                                    temp_gihoList.remove(j);
                                    j--;
                                }
                            }
                            visited.add(g);
                            priortyQueue.offer(new Priority(temp_numList, temp_gihoList, visited));
                        }
                    }
                }else{
                    answer = Math.max(answer, Math.abs(priority.numList.get(0)));
                }
            }
        }

        return answer;
    }
}

class Priority{
    List<Long> numList;
    List<Giho> gihoList;
    List<Giho> visited;

    public Priority(List<Long> _numList, List<Giho> _gihoList, List<Giho> _visited) {
        numList = _numList;
        gihoList = _gihoList;
        if(_visited == null) {
            visited = new ArrayList<>();
        }else {
            visited = _visited;
        }
    }
}

enum Giho {
    PLUS, MINUS, MULTIPLICATION
}

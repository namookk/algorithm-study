package com.algorithm.programmers.y2021.m10.d26;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        String expression = "100-200*300-500+20";
        System.out.println(solution(expression));
    }

    public static long solution(String expression) {
        long answer = 0;
        List<Long> numList= new ArrayList<>();
        List<Giho> gihoList = new ArrayList<>();
        String numStr = "";
        for(char c : expression.toCharArray()) {
            if(Character.isDigit(c)){
                numStr += String.valueOf(c);
            }else{
                Long num = Long.valueOf(numStr);
                numList.add(num);

                if(c == '*') gihoList.add(Giho.MULTIPLICATION);
                else if(c == '+') gihoList.add(Giho.PLUS);
                else if(c == '-') gihoList.add(Giho.MINUS);
            }
        }

        Queue<Priority> priortyQueue = new LinkedList<>();
        priortyQueue.offer(new Priority(numList, gihoList, Giho.PLUS, null));
        priortyQueue.offer(new Priority(numList, gihoList, Giho.MINUS, null));
        priortyQueue.offer(new Priority(numList, gihoList, Giho.MULTIPLICATION, null));

        while(!priortyQueue.isEmpty()) {
            int len = priortyQueue.size();
            for(int i = 0; i < len; i++) {

            }
        }
        return answer;
    }
}

class Priority{
    List<Long> numList;
    List<Giho> gihoList;
    Giho giho;
    List<Giho> visited;

    public Priority(List<Long> _numList, List<Giho> _gihoList, Giho _giho, List<Giho> _visited) {
        numList = new ArrayList<>();
        for(int i = 0; i < _gihoList.size(); i++) {
            Giho g = _gihoList.get(i);
            if(g.equals(_giho)) {
                Long num1 = _numList.get(i);
                Long num2 = _numList.get(i+1);
                Long output = null;
                if(g.equals(Giho.MINUS)){
                    output = num1 - num2;
                }else if(g.equals(Giho.MULTIPLICATION)){
                    output = num1 * num2;
                }else if(g.equals(Giho.PLUS)){
                    output = num1 + num2;
                }
                _numList.remove(i+1);
                _numList.set(i, output);
                _gihoList.remove(i);
                i--;
            }
        }
        Collections.copy(numList, _numList);

        giho = _giho;
        if(_visited == null) {
            visited = new ArrayList<>();
            visited.add(_giho);
        }
        visited = _visited;
    }
}

enum Giho {
    PLUS, MINUS, MULTIPLICATION
}

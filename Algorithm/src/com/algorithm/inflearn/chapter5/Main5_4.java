package com.algorithm.inflearn.chapter5;

import java.util.*;

public class Main5_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.print(solution(s));
    }

    public static int solution(String s) {
        int answer = 0;
        List<Integer> numList = new ArrayList<>();
        List<String> gihoList = new ArrayList<>();
        for(char c : s.toCharArray()) {
            if(Character.isDigit(c)) {
                numList.add(Character.getNumericValue(c));
            }else{
                int num1 = numList.get(numList.size() - 2);
                int num2 = numList.get(numList.size() - 1);
                String giho = String.valueOf(c);
                if(giho.equals("*")) {answer = num1 * num2;}
                else if(giho.equals("+")){answer = num1 + num2;}
                else if(giho.equals("/")) {answer = num1 / num2;}
                else {answer = num1 - num2;}
                numList.remove(numList.size() -1 );
                numList.set(numList.size() -1 , answer);
            }
        }

        return answer;
    }
}
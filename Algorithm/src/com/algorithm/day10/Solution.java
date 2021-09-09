package com.algorithm.day10;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        int[] numbers = {99, 30, 3049, 24, 9};

        System.out.println(solution(numbers));
    }
    //우선순위 1. 맨 앞숫자가 클수록 앞으로
    //우선순위 2. 맨 앞숫자가 같으면 그다음 숫자가 클수록 앞으로
    //우선순위 3.
    public static String solution(int[] numbers) {
        List<Integer> numberList =  Arrays.stream(numbers).boxed().collect(Collectors.toList());
        String answer = "";
        numberList.sort((a,b) -> {
            String aStr = a.toString();
            String bStr = b.toString();
            return -Integer.compare(Integer.parseInt(aStr + bStr) , Integer.parseInt(bStr + aStr));
        });

        for(Integer i : numberList){
            answer += i + "";
        }

        if(answer.charAt(0) == '0'){
            return "0";
        }else{
            return answer;
        }

    }
}

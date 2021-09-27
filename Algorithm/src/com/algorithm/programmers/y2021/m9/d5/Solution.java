package com.algorithm.programmers.y2021.m9.d5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static final List<String> LEFT = new ArrayList<>(Arrays.asList(new String[]{"1", "4", "7", "*"}));
    public static final List<String> RIGHT = new ArrayList<>(Arrays.asList(new String[]{"3", "6", "9", "#"}));
    public static final List<String> CENTER = new ArrayList<>(Arrays.asList(new String[]{"2", "5", "8", "0"}));

    public static void main(String[] args) {
       int[] numbers1 =  {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
       String hand1 = "right";
       String answer1 = "LRLLLRLLRRL";

       int[] numbers2 = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
       String hand2 = "left";
       String answer2 = "LRLLRRLLLRR";

       int[] numbers3 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
       String hand3 = "right";
       String answer3 = "LLRLLRLLRL";

        System.out.println(answer1.equals(solution(numbers1, hand1)));
        System.out.println(answer2.equals(solution(numbers2, hand2)));
        System.out.println(answer3.equals(solution(numbers3, hand3)));
    }
    public static String solution(int[] numbers, String hand) {
        String currLeft = "*";
        String currRight = "#";
        String answer = "";

        for(int number : numbers){
            String num = number + "";
            if(LEFT.contains(num)){ // 왼손
                answer += "L";
                currLeft = num;
            }else if(RIGHT.contains(num)){ // 오른손
                answer += "R";
                currRight = num;
            }else{ // 가운데
                int centerIdx = CENTER.indexOf(num);
                int leftDistance = 5;
                int rightDistance = 5;

                if(LEFT.contains(currLeft)){
                    leftDistance = Math.abs(centerIdx - LEFT.indexOf(currLeft)) + 1;
                }else{
                    leftDistance = Math.abs(centerIdx - CENTER.indexOf(currLeft));
                }
                if(RIGHT.contains(currRight)){
                    rightDistance = Math.abs(centerIdx - RIGHT.indexOf(currRight)) + 1;
                }else{
                    rightDistance = Math.abs(centerIdx - CENTER.indexOf(currRight));
                }

                if(leftDistance > rightDistance){
                    currRight = num;
                    answer += "R";
                }else if(leftDistance < rightDistance){
                    currLeft = num;
                    answer += "L";
                }else{
                    if(hand.equals("left")){
                        currLeft = num;
                        answer += "L";
                    }else{
                        currRight = num;
                        answer += "R";
                    }
                }
            }
        }
        return answer;
    }

}

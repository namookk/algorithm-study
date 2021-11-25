package com.algorithm.programmers.y2021.m8.d31.solution1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        int[][] scores = {{100,90,98,88,65},{50,45,99,85,77},{47,88,95,80,67},{61,57,100,80,65},{24,90,94,75,65}};

        System.out.println(solution(scores));
        System.out.println(solution2(scores));
    }

    public static String solution2(int[][] scores) {
       StringBuffer sb = new StringBuffer();
       int colIdx = 0;
       for(int i = 0; i < scores.length; i++) {
           int mine = scores[i][i];
           Integer[] convertArr = new Integer[scores.length];
           for(int j = 0; j < scores.length; j++){
               convertArr[j] = scores[j][colIdx];
           }
           Arrays.sort(convertArr);
           int sum = Arrays.stream(convertArr).reduce(0, Integer::sum);
           double avg;
           if((convertArr[0] == mine && convertArr[1] > mine) || (convertArr[convertArr.length - 1] == mine && convertArr[convertArr.length - 2] < mine)) {
               sum -= mine;
               avg = (double)sum/ (convertArr.length - 1);
           }else{
               avg = (double)sum/ convertArr.length;
           }
           sb.append(getScoreStr(avg));
           colIdx++;
       }
       return sb.toString();
    }

    public static String solution(int[][] scores) {
        String answer = "";
        for(int i = 0; i < scores.length; i++){
            int min = 100;
            int max = 0;
            int mine = 0;
            List<Integer> scoreList = new ArrayList<>();
            for(int j =0 ; j < scores[i].length; j++){
                int score = scores[j][i];
                if(i == j) mine = score;
                else{
                    scoreList.add(score);
                    if(score < min) min = score;
                    if(score > max) max = score;
                }
            }
            if(mine <= max && mine >= min) scoreList.add(mine);

            double avg = scoreList.stream()
                    .mapToInt(Integer::intValue)
                    .average()
                    .orElse(0);

            answer += getScoreStr(avg);
        }

        return answer;
    }

    public static String getScoreStr(double avg){
        if(avg >= 90) return "A";
        else if(avg >= 80) return "B";
        else if(avg >= 70) return "C";
        else if(avg >= 50) return "D";
        else return "F";
    }
}

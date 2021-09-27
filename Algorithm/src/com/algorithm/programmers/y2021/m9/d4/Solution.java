package com.algorithm.programmers.y2021.m9.d4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        String[] participant = {"mislav", "stanko", "mislav", "ana"};
        String[] completion = {"stanko", "ana", "mislav"};

        System.out.println(solution(participant,completion));
    }
    public static String solution(String[] participant, String[] completion) {
        String answer = "";

        List<String> participantList = new ArrayList<>(Arrays.asList(participant));
        List<String> completionList = new ArrayList<>(Arrays.asList(completion));
        participantList.sort((a,b) -> (a.compareTo(b)));
        completionList.sort((a,b) -> (a.compareTo(b)));

        int len = participantList.size();
        for(int i = 0; i < len; i++){
            if(i == len - 1){
                answer = participantList.get(i);
                break;
            }
            String pt = participantList.get(i);
            String cp = completionList.get(i);
            if(!pt.equals(cp)){
                answer = participantList.get(i);
                break;
            }
        }

        return answer;
    }

}

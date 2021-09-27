package com.algorithm.programmers.y2021.m9.d19;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        String msg = "KAKAO";
        solution(msg);
    }

    public static int[] solution(String msg) {
        int[] answer = {};
        List<Integer> ansList = new ArrayList<>();
        List<String> list = resetList();
        String[] msgArr = msg.split("");
        for(int i = 0; i < msgArr.length; i++) {
            String currMsg = msgArr[i];
            String findMsg = currMsg;
            String nextMsg = "";
            if(i < msgArr.length - 1) nextMsg = msgArr[i+1];
            findMsg += nextMsg;

            while(list.indexOf(findMsg) != -1) {
                currMsg = findMsg;
                if(++i >= msgArr.length - 1) break;
                nextMsg = "";
                if(i < msgArr.length - 1) nextMsg = msgArr[i+1];
                findMsg += nextMsg;
            }

            System.out.println(currMsg + " : currMsg");
            System.out.println(findMsg + " : findMsg");
            System.out.println(i + " : i");
            ansList.add(list.indexOf(currMsg) + 1);
            list.add(findMsg);
        }
        System.out.println(String.join(",", list));
        for(Integer i : ansList) {
            System.out.println(i);
        }
        return answer;
    }

    public static List<String> resetList() {
        String[] arr = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
        return new ArrayList(Arrays.asList(arr));
    }
}

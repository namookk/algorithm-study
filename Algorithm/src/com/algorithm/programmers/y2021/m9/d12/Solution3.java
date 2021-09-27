package com.algorithm.programmers.y2021.m9.d12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution3 {
    public static void main(String[] args) {
        int[] enter = {1,3,2};
        int[] leave = {1,2,3};
        ///[0,1,1];
        solution(enter, leave);
    }

    public static int[] solution(int[] enter, int[] leave) {
        List<Integer> enterList = Arrays.stream(enter).boxed().collect(Collectors.toList());
        List<Integer> leaveList = Arrays.stream(leave).boxed().collect(Collectors.toList());
        List<Integer> answer = new ArrayList<>();
        for(var i = 1 ; i <= enter.length; i++){
            int enterIdx = enterList.indexOf(i);
            int leaveIdx = leaveList.indexOf(i);
            int temp_enterIdx = enterIdx;
            int ans = 0;
            while(temp_enterIdx > 0) { // 뒤로
                int num = enterList.get(temp_enterIdx);
                if(leaveList.indexOf(num) > leaveIdx){
                    ans++;
                }
                temp_enterIdx--;
            }
            temp_enterIdx = enterIdx;
            while(temp_enterIdx < enterList.size()){
                int num = enterList.get(temp_enterIdx);
                if(leaveList.indexOf(num) < leaveIdx){
                    ans++;
                }
                temp_enterIdx++;
            }

            answer.add(ans);
        }
        return answer.stream().mapToInt(i->i).toArray();
    }
}

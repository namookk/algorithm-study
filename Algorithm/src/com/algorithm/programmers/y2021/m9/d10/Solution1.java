package com.algorithm.programmers.y2021.m9.d10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution1 {
    public static void main(String[] args) {
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k = 2;
        //[2,1,1,0]
        solution(id_list, report, k);
    }

    public static int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Map<String, List<String>> reportMap = new HashMap<>(); // 유저별 신고
        Map<String, Integer> reportCntMap = new HashMap<>(); //유저별 신고당한 회수
        List<String> banList = new ArrayList<>();

        for(String rp : report) {
            String[] command = rp.split(" ");
            if(reportMap.get(command[0]) == null) reportMap.put(command[0], new ArrayList<String>());
            if(reportCntMap.get(command[1]) == null) reportCntMap.put(command[1], 0);
            List<String> reportedList = reportMap.get(command[0]);
            Integer rpCnt = reportCntMap.get(command[1]);
            if(reportedList.indexOf(command[1]) == -1){
                reportedList.add(command[1]);
                reportCntMap.put(command[1], ++rpCnt);
                if(rpCnt >= k && banList.indexOf(command[1]) == -1) banList.add(command[1]);
            }
        }

        for(String banId : banList){
            for(int i = 0; i < id_list.length; i++){
                String id = id_list[i];
                if(reportMap.get(id) != null && reportMap.get(id).indexOf(banId) > -1) {
                   answer[i]++;
                }
            }
        }

        return answer;
    }
}

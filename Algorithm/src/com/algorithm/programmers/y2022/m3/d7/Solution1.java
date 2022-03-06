package com.algorithm.programmers.y2022.m3.d7;

import java.util.*;

public class Solution1 {
    public static void main(String[] args) {
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k = 2;

        String[] id_list1 = {"con", "ryan"};
        String[] report1 = {"ryan con", "ryan con", "ryan con", "ryan con"};

        int[] result = solution(id_list, report, k);
        for(int i : result) System.out.print(i +" ");
    }

    public static int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        List<String> idList = Arrays.asList(id_list);
        int[][] counts = new int[id_list.length][1];
        Map<String, List<Integer>> reporter = new HashMap<>();

        for(String rp : report) {
            String[] rp_split = rp.split(" ");
            String rp1 = rp_split[0];
            String rp2 = rp_split[1];
            int rp1_idx = idList.indexOf(rp1);
            int rp2_idx = idList.indexOf(rp2);

            List<Integer> reporterList = reporter.getOrDefault(rp2, new ArrayList<>());
            if(reporterList.indexOf(rp1_idx) == -1) {
                reporterList.add(rp1_idx);
                reporter.put(rp2, reporterList);

                counts[rp2_idx][0]++;
            }
        }

        for(int i = 0; i < counts.length; i++){
            if(counts[i][0] >= k) {
                String rp2 = idList.get(i);
                List<Integer> reporterList = reporter.get(rp2);
                for(Integer reporterIdx : reporterList) {
                    answer[reporterIdx]++;
                }
            }
        }

        return answer;
    }
}

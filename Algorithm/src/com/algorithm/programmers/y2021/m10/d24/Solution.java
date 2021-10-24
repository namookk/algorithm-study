package com.algorithm.programmers.y2021.m10.d24;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        int n = 8;
        int[] lost = {3, 4, 8};
        int[] reserve = {2, 3, 6};

        System.out.println(new Solution().solution(n, lost, reserve));
    }
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;

        List<Integer> lostList = Arrays.stream(lost).boxed()
                .collect(Collectors.toList());

        List<Integer> reserveList = Arrays.stream(reserve).boxed()
                .filter(i -> {
                    int idx = lostList.indexOf(i);
                    if(idx > -1) {
                        lostList.remove(idx);
                        return false;
                    }

                    return true;
                })
                .sorted()
                .collect(Collectors.toList());

        answer = n - lostList.size();
        for(int i = 0; i < reserveList.size(); i++) {
            int idx = reserveList.get(i);
            int prevIdx = lostList.indexOf(idx - 1);
            int nextIdx = lostList.indexOf(idx + 1);

            if(prevIdx > -1) {
                answer++;
                lostList.remove(prevIdx);
            }else if(nextIdx > -1) {
                answer++;
                lostList.remove(nextIdx);
            }
        }
        return answer;
    }
}

package com.algorithm.programmers.y2021.m9.d13;

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        int cacheSize = 3;
        String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};

        System.out.println(solution(cacheSize, cities));
    }

    public static int solution(int cacheSize, String[] cities) {
        int answer = 0;
        ArrayList<String> cacheList = new ArrayList<String>();
        for(String city : cities){
            String smallCity = city.toLowerCase();
            int idx = cacheList.indexOf(smallCity);
            if(cacheSize == 0) {
                answer += 5;
                continue;
            }
            if(idx > -1){
                cacheList.remove(idx);
                cacheList.add(0,smallCity);
                answer += 1;
            }else if(cacheList.size() < cacheSize){
                cacheList.add(0,smallCity);
                answer += 5;
            }else{
                cacheList.remove(cacheList.size() - 1);
                cacheList.add(0, smallCity);
                answer += 5;
            }
        }


        return answer;
    }
}

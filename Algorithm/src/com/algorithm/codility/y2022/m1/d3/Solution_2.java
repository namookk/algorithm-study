package com.algorithm.codility.y2022.m1.d3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution_2 {
    public static void main(String[] args) {
        int n = 16;
        System.out.println(solution(n));
    }
    private static int solution(int n){
        if(n < 10) return n;
        int num = n;
        List<Integer> list = new ArrayList<>();
        while(num > 9) {
           list.add(9);
           num -= 9;
        }
        list.add(num);
        Collections.sort(list);

        int answer = list.stream().reduce((total, i) -> total * 10 + i).get();
        return answer;
    }
}

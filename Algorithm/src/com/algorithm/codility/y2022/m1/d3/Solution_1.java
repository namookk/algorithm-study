package com.algorithm.codility.y2022.m1.d3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution_1 {
    public static void main(String[] args) {
        int num = 1;
        System.out.println(solution(num));
    }

    private static int solution(int N) {
        Integer num = N;

        List<Integer> numList = new ArrayList<>();
        while(num > 0){
            numList.add(num%10);
            num /= 10;
        }

        int answer = numList.stream()
                .sorted(Collections.reverseOrder())
                .reduce((total, i) -> total * 10 + i)
                .get();

        return answer;
    }
}

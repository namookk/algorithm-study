package com.algorithm.baekjoon.silver5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution_1158 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        List<Integer> result = solution(n ,k);
        System.out.println(result.toString().replace("[","<").replace("]", ">"));
    }

    private static List<Integer> solution(int n, int k){
        List<Integer> answer = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for(int i = 1; i <= n; i++) list.add(i);
        int idx = 0;

        while(!list.isEmpty()){
            int nextIdx = idx + k - 1;
            if(nextIdx >= list.size()) nextIdx %= list.size();
            answer.add(list.get(nextIdx));
            list.remove(nextIdx);
            if(nextIdx == list.size()) nextIdx = 0;
            idx = nextIdx;
        }

        return answer;
    }
}

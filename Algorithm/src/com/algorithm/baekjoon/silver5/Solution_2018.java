package com.algorithm.baekjoon.silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_2018 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int target = Integer.parseInt(br.readLine().trim());
        int count = 1;
        int half = target % 2 == 0 ? target / 2 : target / 2 + 1;
        int lt = 1;
        int rt = 1;
        int sum = 1;
        while(rt <= half){
            if(sum >= target){
                if(sum == target) count++;
                sum -= lt++;
            }else{
                sum += ++rt;
            }
        }
        System.out.println(count);
    }
}

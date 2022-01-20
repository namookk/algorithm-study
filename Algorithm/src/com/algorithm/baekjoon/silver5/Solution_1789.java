package com.algorithm.baekjoon.silver5;

import java.util.*;

public class Solution_1789 {
    static int count = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long s = sc.nextLong();
        if(s > 2){
            Long next = 1L;
            while(s - next > next){
                count++;
                s = s - next;
                next++;
            }
        }

        System.out.println(count+1);
    }
}

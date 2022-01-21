package com.algorithm.baekjoon.silver5;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution_1969 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        String[] dnas = new String[n];
        for(int i = 0; i < n; i++){
            dnas[i] = sc.nextLine();
        }

        solution(n, m, dnas);
    }

    private static void solution(int n, int m, String[] dnas){
        StringBuffer sb = new StringBuffer();
        int sum = 0;
        for(int i = 0; i < m; i++){
            int max = 0;
            Character maxC = null;
            Map<Character, Integer> map = new HashMap<>();
            for(int j = 0; j < n; j++){
                char key = dnas[j].charAt(i);
                map.put(key, map.getOrDefault(key, 0) + 1);
                if(map.get(key) > max){
                    max = map.get(key);
                    maxC = key;
                }else if(map.get(key) == max && maxC.compareTo(key) > 0){
                    maxC = key;
                }
            }
            sb.append(maxC);
            for(Character key : map.keySet()){
                if(key != maxC) sum += map.get(key);
            }
        }

        System.out.println(sb.toString());
        System.out.println(sum);
    }
}

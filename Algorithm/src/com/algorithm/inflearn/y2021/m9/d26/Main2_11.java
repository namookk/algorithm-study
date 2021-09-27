package com.algorithm.inflearn.y2021.m9.d26;

import java.util.*;

public class Main2_11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][5];
        for(int i = 0 ; i < n; i++) {
            for(int j = 0; j < 5; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println(solution(n, arr));
    }

    public static int solution(int n, int[][] arr) {
        int answer = 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int[] myArr = arr[i];

            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 5; k++) {
                    if (myArr[k] == arr[j][k]) {
                        List<Integer> mapValue = map.get(i);
                        if (mapValue == null) mapValue = new ArrayList<Integer>();
                        if (mapValue.indexOf(j) == -1) {
                            mapValue.add(j);
                            map.put(i, mapValue);
                        }
                    }
                }
            }

        }
        Integer maxCnt = -1;
        for (Integer key : map.keySet()) {
            Integer cnt = map.get(key).size();
            if (maxCnt < cnt) {
                answer = key + 1;
                maxCnt = cnt;
            }
        }

        return answer;
    }
}
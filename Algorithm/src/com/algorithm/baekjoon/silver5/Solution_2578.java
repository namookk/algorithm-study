package com.algorithm.baekjoon.silver5;

import java.util.*;

public class Solution_2578 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(new ArrayList<>());
        }

        int[] rowBingoArr = new int[5];
        int[] colBingoArr = new int[5];
        Arrays.fill(rowBingoArr, 5);
        Arrays.fill(colBingoArr, 5);
        int leftCross = 5;
        int rightCross = 5;

        Map<Integer, Integer> rowMap = new HashMap<>();
        for (int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++){
                int num = sc.nextInt();
                rowMap.put(num, i);
                list.get(i).add(num);
            }
        }

        int count = 0;
        for(int i = 1; i <= 25; i++){
            int num = sc.nextInt();
            int row = rowMap.get(num);
            int col = list.get(row).indexOf(num);
            if(--rowBingoArr[row] == 0) count++;
            if(--colBingoArr[col] == 0) count++;
            if(row == col && --leftCross == 0) count++;
            if(row + col == 4 && --rightCross == 0) count++;
            if(count >= 3) {
                System.out.println(i);
                break;
            }
        }
    }
}
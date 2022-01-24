package com.algorithm.baekjoon.silver5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution_2422 {
    static List<List<Integer>> combinationList = new ArrayList<>();
    static List<List<Integer>> notCombList = new ArrayList<>();
    static final int LIMIT = 3;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        for (int i = 0; i <= n; i++) {
            notCombList.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int num1 = sc.nextInt();
            int num2 = sc.nextInt();

            notCombList.get(num1).add(num2);
            notCombList.get(num2).add(num1);
        }

        recursive(n, 1, new ArrayList<>(), new ArrayList<>());

        System.out.println(combinationList.size());
    }

    private static void recursive(int n, int start, List<Integer> list, List<Integer> notList){
        if(list.size() == LIMIT){
            List<Integer> new_list = new ArrayList<>(list);
            combinationList.add(new_list);
        }else{
            for(int i = start; i <= n; i++){
                if(!list.contains(i) && !notList.contains(i)){
                    List<Integer> new_notList = new ArrayList<>(notList);
                    new_notList.addAll(notCombList.get(i));
                    list.add(i);
                    recursive(n, i + 1, list, new_notList);
                    list.remove((Integer)i);
                }
            }
        }
    }
}

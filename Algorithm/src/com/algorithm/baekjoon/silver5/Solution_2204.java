package com.algorithm.baekjoon.silver5;

import java.util.*;

public class Solution_2204 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        while(n > 0) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                list.add(sc.nextLine());
            }
            Collections.sort(list, Comparator.comparing(String::toLowerCase));
            System.out.println(list.get(0));

            n = sc.nextInt();
            sc.nextLine();
        }
    }
}

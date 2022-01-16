package com.algorithm.baekjoon.silver5;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class Solution_1181 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        TreeSet<String> set = new TreeSet<>((a, b) -> {
            if(a.length() == b.length()) return a.compareTo(b);
            else return a.length() - b.length();
        });

        sc.nextLine();
        for(int i = 0; i < n; i++){
            set.add(sc.nextLine());
        }

        Iterator<String> iter = set.iterator();
        while(iter.hasNext()){
            System.out.println(iter.next());
        }
    }
}

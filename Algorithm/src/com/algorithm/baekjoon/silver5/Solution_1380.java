package com.algorithm.baekjoon.silver5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution_1380 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> answer = new ArrayList<>();

        while(sc.hasNext()){
            int n = sc.nextInt();
            sc.nextLine();
            if(n == 0) break;
            List<String> student = new ArrayList<>();
            List<String> lost = new ArrayList<>();
            for(int i = 0; i < n; i++){
                String name = sc.nextLine();
                student.add(name);
            }
            for(int i = 0; i < 2*n - 1; i++){
                String s = sc.nextLine();
                String[] arr = s.split(" ");
                int idx = Integer.parseInt(arr[0]) - 1;
                String name = student.get(idx);
                if(lost.contains(name)){
                    lost.remove(name);
                }else{
                    lost.add(name);
                }
            }
            answer.add(lost.get(0));
        }

        for(int i = 0; i < answer.size(); i++){
            System.out.println(i+1 +" "+ answer.get(i));
        }
    }
}

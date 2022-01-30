package com.algorithm.baekjoon.silver5;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution_2535 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<Student> pq = new PriorityQueue<>((a,b) -> b.score - a.score);
        for (int i = 0; i < n; i++) {
            int country = sc.nextInt();
            int number = sc.nextInt();
            int score = sc.nextInt();

            pq.offer(new Student(country, number, score));
        }

        Map<Integer,Integer> map = new HashMap<>();
        int count = 3;
        while(count > 0 && !pq.isEmpty()) {
            Student student = pq.poll();
            if(!map.containsKey(student.country) || map.get(student.country) < 2){
                System.out.println(student.country + " " + student.number);
                count--;
            }
            map.put(student.country, map.getOrDefault(student.country, 0) + 1);
        }
    }
}

class Student{
    int country;
    int number;
    int score;

    public Student(int country, int number, int score) {
        this.country = country;
        this.number = number;
        this.score = score;
    }
}

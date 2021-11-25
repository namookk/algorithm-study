package com.algorithm.inflearn.y2021.m11.d25;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main9_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<People> peopleList = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            peopleList.add(new People(sc.nextInt(), sc.nextInt()));
        }

        System.out.println(solution(peopleList));
    }

    public static int solution(List<People> peopleList) {
        int answer = 0;
        Collections.sort(peopleList);

        int maxWeight = Integer.MIN_VALUE;

        for(People people : peopleList) {
            if(people.weight > maxWeight) answer++;
            maxWeight = Math.max(maxWeight, people.weight);
        }

        return answer;
    }
}

class People implements Comparable<People>{
    int height;
    int weight;

    public People(int _height, int _weight) {
        height = _height;
        weight = _weight;
    }

    @Override
    public int compareTo(People p) {
        if(p.height == this.height) return p.weight - this.weight;
        else return p.height - this.height;
    }
}

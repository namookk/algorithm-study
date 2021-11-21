package com.algorithm.programmers.y2021.m10.d15;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// https://programmers.co.kr/learn/courses/30/lessons/42583

public class Solution {
    public static void main(String[] args) {
        int bridge_length = 100;
        int weight = 100;
        int[] truck_weights = {10};

        System.out.println(solution(bridge_length,weight,truck_weights));
    }
    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        List<Truck> complete = new ArrayList<>();
        Queue<Truck> trucks = new LinkedList<>();
        for(int i = 0; i < truck_weights.length; i++){
            trucks.offer(new Truck(truck_weights[i]));
        }

        Queue<Truck> tq = new LinkedList<>();

        while(complete.size() < truck_weights.length){
            answer++; // 시간 증가
            int curr_weight = 0;
            Queue<Truck> temp_tq = new LinkedList<>();
            while(!tq.isEmpty()) {
                Truck truck = tq.poll();
                if(truck.time++ == bridge_length) {
                    complete.add(truck);
                }else{
                    curr_weight += truck.weight;
                    temp_tq.offer(truck);
                }
            }
            System.out.println("현재 다리에 지나고 있는 트럭의 무게 : " + curr_weight + ", 시간초 : " + answer);
            if(trucks.peek() != null && curr_weight + trucks.peek().weight <= weight) {
                temp_tq.offer(trucks.poll());
            }
            tq = temp_tq;
        }

        return answer;
    }
}

class Truck{
    int weight;
    int time;

    public Truck(int _weight) {
        this.weight = _weight;
        this.time = 1;
    }
}

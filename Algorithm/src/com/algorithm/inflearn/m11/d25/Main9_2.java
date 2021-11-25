package com.algorithm.inflearn.m11.d25;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main9_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Room> roomList = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            roomList.add(new Room(sc.nextInt(), sc.nextInt()));
        }

        System.out.println(solution(roomList));
    }

    public static int solution(List<Room> roomList) {
        int answer = 0;
        Collections.sort(roomList);

        int end = 0;
        for(Room room : roomList) {
            if(end <= room.start) {
                answer++;
                end = room.end;
            }
        }
        return answer;
    }
}

class Room implements Comparable<Room>{
    int start, end;
    public Room(int _start, int _end){
        start = _start;
        end = _end;
    }

    @Override
    public int compareTo(Room r){
       if(this.end == r.end) return this.start - r.start;
       else return this.end - r.end;
    }
}
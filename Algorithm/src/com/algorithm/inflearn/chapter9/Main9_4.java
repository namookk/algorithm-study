package com.algorithm.inflearn.chapter9;

import java.util.*;

public class Main9_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Lecture> lectureList = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            lectureList.add(new Lecture(sc.nextInt(), sc.nextInt()));
        }
        System.out.println(solution(lectureList));
    }

    public static int solution(List<Lecture> lectureList) {
        int answer = 0;
        Collections.sort(lectureList);
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int maxDay = lectureList.get(0).day;
        int j = 0;
        int len = lectureList.size();
        for(int i = maxDay; i >= 1; i--){
            for( ; j < len; j++) {
                if(lectureList.get(j).day < i) break;
                pq.offer(lectureList.get(j).pay);
            }
            if(!pq.isEmpty()) answer += pq.poll();
        }

        return answer;
    }
}

class Lecture implements Comparable<Lecture>{
    int day, pay;

    public Lecture(int _pay, int _day) {
        day = _day;
        pay = _pay;
    }

    @Override
    public int compareTo(Lecture l) {
        return l.day - this.day;
    }
}

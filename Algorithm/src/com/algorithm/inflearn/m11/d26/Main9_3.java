package com.algorithm.inflearn.m11.d26;

import java.util.*;

/*
*   TestCase    Result
*       1         S
*       2         S
*       3         F
*       4         E
*       5         E
* */

public class Main9_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<WeddingTime> timeList = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            timeList.add(new WeddingTime(sc.nextInt(), sc.nextInt()));
        }

        System.out.println(solution(timeList));
    }

    public static int solution(List<WeddingTime> timeList) {
        int answer = 0;
        Queue<WeddingTime> queue = new LinkedList<>();
        /*
            5 14
            12 15
            14 18
            15 20
            20 30
        */
        Collections.sort(timeList);
        for(WeddingTime t : timeList) {
            answer = Math.max(answer, queue.size());
            int len = queue.size();
            for(int i = 0; i < len; i++) {
                WeddingTime qt = queue.peek();
                if (qt.end <= t.start) queue.poll();
            }
            queue.offer(t);
        }
        return answer;
    }

}

class WeddingTime implements Comparable<WeddingTime>{
    int start,end;
    public WeddingTime(int _start, int _end){
        start = _start;
        end = _end;
    }

    @Override
    public int compareTo(WeddingTime t){
        return this.start - t.start;
    }
}

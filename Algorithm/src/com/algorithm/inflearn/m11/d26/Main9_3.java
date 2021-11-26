package com.algorithm.inflearn.m11.d26;

import java.util.*;

/* solution1
*   TestCase    Result
*       1         S
*       2         S
*       3         F
*       4         E
*       5         E
* */
/* solution2
*   TestCase    Result
*       1         S
*       2         S
*       3         S
*       4         S
*       5         S
* */

public class Main9_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        //List<WeddingTime> timeList = new ArrayList<>();
        List<WeddingTime2> timeList2 = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            int st = sc.nextInt();
            int et = sc.nextInt();
            //timeList.add(new WeddingTime(st, et));
            timeList2.add(new WeddingTime2(st, "s"));
            timeList2.add(new WeddingTime2(et, "e"));
        }

        //System.out.println(solution1(timeList));
        System.out.println(solution2(timeList2));
    }

    public static int solution1(List<WeddingTime> timeList) {
        int answer = 0;
        Queue<WeddingTime> queue = new LinkedList<>();
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

    public static int solution2(List<WeddingTime2> timeList){
        int answer = Integer.MIN_VALUE;
        int cnt = 0;
        Collections.sort(timeList);
        for(WeddingTime2 time : timeList) {
            if(time.state.equals("s")) cnt++;
            else cnt--;

            answer = Math.max(answer, cnt);
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

class WeddingTime2 implements Comparable<WeddingTime2>{
    int time;
    String state;
    public WeddingTime2(int _time, String _state){
        time = _time;
        state = _state;
    }

    @Override
    public int compareTo(WeddingTime2 t){
        if(this.time == t.time) return this.state.compareTo(t.state);
        else return this.time - t.time;
    }
}

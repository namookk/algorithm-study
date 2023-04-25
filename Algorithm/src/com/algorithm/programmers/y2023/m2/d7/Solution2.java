package com.algorithm.programmers.y2023.m2.d7;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution2 {

  public static void main(String[] args) {
    String[][] book_time = {{"15:00", "17:00"}, {"16:40", "18:20"}, {"14:20", "15:20"}, {"14:10", "19:20"}, {"18:20", "21:20"}};
    System.out.println(solution(book_time));
  }

  private static int solution(String[][] book_time) {
    int answer = Integer.MIN_VALUE;
    Arrays.sort(book_time, (a,b) -> a[0].compareTo(b[0]));
    PriorityQueue<LocalDateTime[]> bookingQueue = new PriorityQueue<>((a,b) -> a[1].compareTo(b[1]));
    for(int i = 0; i < book_time.length; i++) {
      String[] booking = book_time[i];
      LocalDateTime[] bookingDateTimes = new LocalDateTime[2];
      bookingDateTimes[0] = parseLocalDateTime(booking[0]);
      bookingDateTimes[1] = parseLocalDateTime(booking[1]).plusMinutes(10);

      if(!bookingQueue.isEmpty()){
        LocalDateTime[] fastestOutBooking = bookingQueue.peek();
        while(fastestOutBooking[1].compareTo(bookingDateTimes[0]) < 0) {
          bookingQueue.poll();
          if(bookingQueue.isEmpty()) break;
          fastestOutBooking = bookingQueue.peek();
        }
      }

      bookingQueue.offer(bookingDateTimes);

      answer = Math.max(answer, bookingQueue.size());
    }

    return answer;
  }


  private static LocalDateTime parseLocalDateTime(String time) {
    String[] timeArr = time.split(":");
    return LocalDateTime.now()
        .withHour(Integer.parseInt(timeArr[0]))
        .withMinute(Integer.parseInt(timeArr[1]));
  }

}

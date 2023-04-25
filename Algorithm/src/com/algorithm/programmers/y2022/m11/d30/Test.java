package com.algorithm.programmers.y2022.m11.d30;

import static java.time.temporal.TemporalAdjusters.lastDayOfMonth;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

public class Test {

  public static void main(String[] args) {
    int month = 6;
    LocalDate firstOfWeek = LocalDate.of(2022, month, 1);

    if(firstOfWeek.getDayOfWeek().getValue() > 5) {
      firstOfWeek = firstOfWeek.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
    }

    while(firstOfWeek.getMonthValue() == month) {
      LocalDate lastOfWeek = firstOfWeek.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
      //firstOfWeek이 금요일일 경우
      if(lastOfWeek.getMonthValue() > month) {
        lastOfWeek = firstOfWeek.with(lastDayOfMonth());
      }

      if(Math.abs(firstOfWeek.getDayOfMonth() - lastOfWeek.getDayOfMonth()) > 5) {
        lastOfWeek = firstOfWeek;
      }

      System.out.println(firstOfWeek.format(DateTimeFormatter.ofPattern("MM-dd")) + " ~ " + lastOfWeek.format(DateTimeFormatter.ofPattern("MM-dd")));
      firstOfWeek = firstOfWeek.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
    }
  }
}

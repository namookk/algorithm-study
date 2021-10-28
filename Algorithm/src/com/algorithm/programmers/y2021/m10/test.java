package com.algorithm.programmers.y2021.m10;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class test {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.YEAR, -5); // 1년 전

        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyyMMdd");

        System.out.println(dateFormatter.format(cal.getTime()));

    }
}

package com.algorithm.hackerrank.y2022.m1.d12;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result2 {

    /*
     * Complete the 'interQuartile' function below.
     *
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY values
     *  2. INTEGER_ARRAY freqs
     */

    public static void interQuartile(List<Integer> values, List<Integer> freqs) {
        // Print your answer to 1 decimal place within this function
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < values.size() ; i++) {
            Integer value = values.get(i);
            for(int j = 0; j < freqs.get(i); j++){
                list.add(value);
            }
        }

        Collections.sort(list);
        List<Integer> lowerList = new ArrayList<>();
        List<Integer> upperList = new ArrayList<>();

        for(int i = 0; i < list.size() / 2; i++){
            lowerList.add(list.get(i));
        }
        for(int i = (list.size() % 2 == 0 ? list.size() / 2 : list.size() / 2 + 1); i < list.size(); i++){
            upperList.add(list.get(i));
        }

        System.out.println(getMedian(upperList) - getMedian(lowerList));
    }

    private static Double getMedian(List<Integer> list){
        if(list.size() % 2 == 0){
            double sum = list.get(list.size() / 2) + list.get(list.size() / 2 - 1);
            return sum / 2;
        }else{
            return (double)list.get(list.size() / 2);
        }
    }
}

public class Solution2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> val = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> freq = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        Result2.interQuartile(val, freq);

        bufferedReader.close();
    }
}


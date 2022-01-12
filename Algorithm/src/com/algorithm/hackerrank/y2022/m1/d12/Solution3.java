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

class Result3 {

    /*
     * Complete the 'stdDev' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void stdDev(List<Integer> arr) {
        // Print your answers to 1 decimal place within this function
        int sum = arr.stream().mapToInt(i -> i).sum();
        int avg = sum / arr.size();
        long powSum = 0;
        for(int num : arr){
            powSum += Math.pow((num - avg), 2);
        }
        System.out.println(String.format("%.1f", Math.sqrt(powSum / arr.size())));
    }

}

public class Solution3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> vals = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        Result3.stdDev(vals);

        bufferedReader.close();
    }
}

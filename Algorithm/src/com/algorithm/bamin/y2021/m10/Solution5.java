package com.algorithm.bamin.y2021.m10;
import java.io.*;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        Stream<String> stream = br.lines();
        List<String> list = br.lines().filter(str -> str.length() >= 5).map(str -> str.toUpperCase()).collect(Collectors.toList());

    }
}

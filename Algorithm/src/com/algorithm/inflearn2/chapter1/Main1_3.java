package com.algorithm.inflearn2.chapter1;

import java.util.ArrayList;
import java.util.List;

public class Main1_3 {
    public static void main(String[] args) {
        String s = "8F3Z-2e-9-w-ab";
        int k = 4;

        String s2 = "8-5g-3-J";
        int k2 = 2;

        System.out.println(solve2(s, k));
        System.out.println(solve2(s2, k2));
    }

    public static String solve(String s, int k) {
        List<String> answerList = new ArrayList<>();
        String[] arr = s.split("-");
        answerList.add(arr[0]);
        StringBuffer sb = new StringBuffer();
        for(int i = 1; i < arr.length; i++) {
            String last = answerList.get(answerList.size() - 1);
            if(sb.toString().length() == k) {
                answerList.add(sb.toString());
                sb = new StringBuffer();
            }
            sb.append(arr[i]);

            if(i == arr.length - 1)  answerList.add(sb.toString().toUpperCase());
        }
        return String.join("-", answerList);
    }

    public static String solve2(String s, int k) {
        String newStr = s.replaceAll("-","").toUpperCase();
        StringBuilder sb = new StringBuilder(newStr);

        int len = sb.length();
        for(int i = k; i < len; i += k) {
            sb.insert(len-i, '-');
        }
        return sb.toString();
    }
}

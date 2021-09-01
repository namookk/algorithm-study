package com.algorithm.day5;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        long n = 12345L;
        System.out.println(Arrays.toString(solution(n)));
    }
    public static int[] solution(long n) {
        int[] answer = {};
        String nStr = n +"";
        int[] result = Arrays.stream(nStr.split("")).mapToInt(Integer::parseInt).toArray();
        List<Integer> list = Arrays.stream(result)
                .boxed()
                .collect(Collectors.toList());
        Collections.reverse(list);
        answer = list.stream().mapToInt(i->i).toArray();

        return answer;
    }
}

package com.algorithm.programmers.y2022.m1.d11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//https://programmers.co.kr/learn/courses/30/lessons/12987
//정확성  테스트
//    테스트 1 〉	통과 (2.06ms, 73.2MB)
//    테스트 2 〉	통과 (2.16ms, 75.7MB)
//    테스트 3 〉	통과 (2.81ms, 78.5MB)
//    테스트 4 〉	통과 (2.12ms, 78.3MB)
//    테스트 5 〉	통과 (2.47ms, 75.7MB)
//    테스트 6 〉	통과 (2.69ms, 83.4MB)
//    테스트 7 〉	통과 (2.57ms, 73.8MB)
//    테스트 8 〉	통과 (2.63ms, 71.1MB)
//    테스트 9 〉	통과 (7.04ms, 72.8MB)
//    테스트 10 〉	통과 (5.36ms, 77.9MB)
//    테스트 11 〉	통과 (5.44ms, 73.7MB)
//    테스트 12 〉	통과 (3.78ms, 72.7MB)
//    테스트 13 〉	통과 (32.70ms, 80.8MB)
//    테스트 14 〉	통과 (28.26ms, 80.6MB)
//    테스트 15 〉	통과 (36.48ms, 82.3MB)
//    테스트 16 〉	통과 (27.43ms, 83.9MB)
//    테스트 17 〉	통과 (4.14ms, 77.5MB)
//    테스트 18 〉	통과 (6.41ms, 82.9MB)
//효율성  테스트
//    테스트 1 〉	통과 (657.75ms, 70.8MB)
//    테스트 2 〉	통과 (640.08ms, 85.8MB)
//    테스트 3 〉	통과 (611.52ms, 68.4MB)

public class Solution {
    public static void main(String[] args) {
        int[] a = {5,1,3,7};
        int[] b = {2,2,6,8};

        System.out.println(solution(a, b));
    }

    private static int solution(int[] a, int[] b){
        int answer = 0;
        Arrays.sort(a);
        List<Integer> list = Arrays.stream(b).boxed().sorted().collect(Collectors.toList());

        for(int i = 0; i < a.length; i++){
            int num = a[i];
            if(list.get(list.size() - 1) <= num){
                list.remove(0);
            }else{
                for(int j = 0; j < list.size(); j++){
                    if(list.get(j) > num){
                        answer++;
                        list.remove(j);
                        break;
                    }
                }
            }
        }

        return answer;
    }
}

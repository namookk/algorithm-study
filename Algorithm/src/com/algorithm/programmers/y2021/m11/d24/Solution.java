package com.algorithm.programmers.y2021.m11.d24;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        int N = 5;
        int[] arr = {2, 1, 2, 6, 2, 4, 3, 3};
        for(int i : solution(N, arr)){
            System.out.print(i +" ");
        }
    }

    public static int[] solution(int N, int[] arr) {
        int[] answer = new int[N];
        int people = arr.length;
        List<FailRatio> failRatioList = new ArrayList<>();
        for(int i = 1; i <= N; i++) {
            int fail = 0;
            for(int j = 0; j < arr.length; j++) {
                if(arr[j] == i) fail++;
            }
            failRatioList.add(new FailRatio(i, people > 0 ? (double)fail / (double)people : 0));
            people -= fail;
        }
        Collections.sort(failRatioList, (a,b) -> {
           if(b.ratio > a.ratio){
               return 1;
           }else if(b.ratio == a.ratio){
               return a.stage > b.stage ? 1 : -1;
           }else{
               return -1;
           }
        });
        for(int i = 0; i < N; i++) {
            answer[i] = failRatioList.get(i).stage;
        }
        return answer;
    }
}

class FailRatio{
    int stage;
    double ratio;

    public FailRatio(int _stage, double _ratio) {
        stage = _stage;
        ratio = _ratio;
    }
}

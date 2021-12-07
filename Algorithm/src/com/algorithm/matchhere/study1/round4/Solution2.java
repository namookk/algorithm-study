package com.algorithm.matchhere.study1.round4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<ArrayList<Integer>> scores = new ArrayList<>();
        for(int i = 0; i < n; i++){
            ArrayList<Integer> score = new ArrayList<>();
            int m = sc.nextInt();
            for(int j = 0; j < m; j++) {
                score.add(sc.nextInt());
            }
            scores.add(score);
        }
        for(double percent : solution(scores)) System.out.println(String.format("%.3f", percent * 100) +"%");
    }

    public static List<Double> solution(ArrayList<ArrayList<Integer>> scores) {
        List<Double> answer = new ArrayList<>();
        for(ArrayList<Integer> score : scores) {
            double avg = score.stream().mapToDouble(a -> a)
                    .average()
                    .orElse(0.0);
            int cnt = 0;
            for(Integer num : score) {
                if(num > avg) cnt++;
            }
            double percent = (double)cnt / score.size();
            answer.add(percent);
        }
        return answer;
    }
}

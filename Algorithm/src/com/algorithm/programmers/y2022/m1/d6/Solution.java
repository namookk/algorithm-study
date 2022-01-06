package com.algorithm.programmers.y2022.m1.d6;

import java.util.Arrays;

//https://programmers.co.kr/learn/courses/30/lessons/72412?language=java
//정확성  테스트
//    테스트 1 〉	통과 (4.91ms, 76MB)
//    테스트 2 〉	통과 (2.79ms, 76.8MB)
//    테스트 3 〉	통과 (6.14ms, 82.1MB)
//    테스트 4 〉	통과 (21.90ms, 87.5MB)
//    테스트 5 〉	통과 (25.14ms, 92.9MB)
//    테스트 6 〉	통과 (34.54ms, 90MB)
//    테스트 7 〉	통과 (25.16ms, 91.9MB)
//    테스트 8 〉	통과 (40.64ms, 92MB)
//    테스트 9 〉	통과 (52.74ms, 92.5MB)
//    테스트 10 〉	통과 (36.50ms, 91.6MB)
//    테스트 11 〉	통과 (24.60ms, 87.1MB)
//    테스트 12 〉	통과 (31.43ms, 81.9MB)
//    테스트 13 〉	통과 (37.93ms, 91.2MB)
//    테스트 14 〉	통과 (34.70ms, 88.2MB)
//    테스트 15 〉	통과 (41.10ms, 92.2MB)
//    테스트 16 〉	통과 (21.92ms, 105MB)
//    테스트 17 〉	통과 (24.99ms, 91.5MB)
//    테스트 18 〉	통과 (49.35ms, 97.9MB)
//효율성  테스트
//    테스트 1 〉	실패 (시간 초과)
//    테스트 2 〉	실패 (시간 초과)
//    테스트 3 〉	실패 (시간 초과)
//    테스트 4 〉	실패 (시간 초과)
public class Solution {
    public static void main(String[] args) {
        String[] info = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
        String[] query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};

        for(int i : solution(info, query)) System.out.print(i + " ");
    }

    private static int[] solution(String[] info, String[] query){
        int[] answer = new int[query.length];
        Info[] infos = new Info[info.length];

        for(int i = 0; i < info.length; i++){
            String infoStr = info[i];
            String[] infoArr = infoStr.split(" ");
            infos[i] = new Info(infoArr[0], infoArr[1], infoArr[2], infoArr[3], Integer.parseInt(infoArr[4]));
        }

        for(int i = 0; i < query.length; i++){
            String queryStr = query[i];
            String[] queryArr = queryStr.split(" and ");
            String[] foodAndScore = queryArr[3].split(" ");

            Info[] resultArr = Arrays.stream(infos).filter(item -> {
                return (queryArr[0].equals("-") || item.language.equals(queryArr[0]))
                        && (queryArr[1].equals("-") || item.job.equals(queryArr[1]))
                        && (queryArr[2].equals("-") || item.career.equals(queryArr[2]))
                        && (foodAndScore[0].equals("-") || item.food.equals(foodAndScore[0]))
                        && (item.score >= Integer.parseInt(foodAndScore[1]));
            }).toArray(Info[]::new);

            answer[i] = resultArr.length;
        }

        return answer;
    }

    private static class Info{
        String language;
        String job;
        String career;
        String food;
        int score;

        Info(String language, String job, String career, String food, int score){
            this.language = language;
            this.job = job;
            this.career = career;
            this.food = food;
            this.score = score;
        }
    }
}

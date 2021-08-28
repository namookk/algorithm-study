package com.algorithm.weeklyfour;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        String[] table = {"SI JAVA JAVASCRIPT SQL PYTHON C#", "CONTENTS JAVASCRIPT JAVA PYTHON SQL C++", "HARDWARE C C++ PYTHON JAVA JAVASCRIPT", "PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP", "GAME C++ C# JAVASCRIPT C JAVA"};
        String[] language = {"PYTHON", "C++", "SQL"};
        int[] preference = {7, 5, 5};

        System.out.println(solution(table, language, preference));
    }

    public static String solution(String[] table, String[] languages, int[] preferences) {
        String answer = "";

        LinkedHashMap<String, List<String>> scoreMap = new LinkedHashMap<>();
        List<String> answerList = new ArrayList<>();
        int maxScore = 0;
        for(String tableStr : table){
            List<String> tableList = new ArrayList<>(Arrays.asList(tableStr.split(" ")));
            String job = tableList.get(0);
            tableList.remove(0);
            scoreMap.put(job, tableList);
        }

        int langLen = languages.length;
        for(String job : scoreMap.keySet()){
            List<String> languageScoreList = scoreMap.get(job);
            int score = 0;
            for(int i = 0; i < langLen; i++){
                String lang = languages[i];
                int preference = preferences[i];
                int idx = languageScoreList.indexOf(lang);
                if(idx > -1) score += (5 - idx) * preference;
            }
            if(score > maxScore) {
                maxScore = score;
                answerList = new ArrayList<>();
                answerList.add(job);
            }else if(score == maxScore){
                answerList.add(job);
            }
        }

        if(answerList.size() > 0){
            answerList.sort((a,b) -> {
                return a.compareTo(b);
            });
            answer = answerList.get(0);
        }

        return answer;
    }

}

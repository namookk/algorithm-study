package com.algorithm.programmers.y2022.m2.d12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    static Map<String, Integer> nameMap = new HashMap<>();
    public static void main(String[] args) {
        String s = "John Doe, Peter Parker, Mary Jane Watson-Parker, James Doe, John Elvis Doe, Jane Doe, Penny Parker";
        String c = "Example";

        System.out.println(solution(s, c));
    }

    private static String solution(String s, String c) {
        String[] names = s.split(", ");
        List<String> answerList = new ArrayList<>();

        for(String name : names){
            StringBuilder sb = new StringBuilder(name);
            sb.append(" <")
                .append(getEmail(name, c))
                .append(">");

            answerList.add(sb.toString());
        }

        return String.join(", ", answerList);
    }

    private static String getEmail(String name, String company) {
        StringBuilder sb = new StringBuilder("@"+company.toLowerCase()+".com");
        String match = "[^a-zA-Z]";
        StringBuilder emailNameSb = new StringBuilder();

        String[] namePart = name.split(" ");
        for(int i = 0; i < namePart.length; i++){
            if(i == namePart.length - 1){
                String lastName = namePart[i].replaceAll(match, "").toLowerCase();
                if(lastName.length() > 8) lastName = lastName.substring(0, 8);
                emailNameSb.append(lastName);

                String key = emailNameSb.toString();
                nameMap.put(key, nameMap.getOrDefault(key, 0) + 1);
                int count = nameMap.get(key);
                if(count > 1) emailNameSb.append(count);
            }else{
                emailNameSb.append(namePart[i].toLowerCase().charAt(0));
            }
        }
        sb.insert(0, emailNameSb.toString());

        return sb.toString();
    }
}

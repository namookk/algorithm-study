package com.algorithm.sk.y2022.m3.d20;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution1 {
    public static void main(String[] args) {
        String[] goods = {"pencil","cilicon","contrabase","picturelist"};

        String[] result = solution(goods);
        for(String str : result) System.out.println(str);

        String[] goods2 = {"abcdeabcd","cdabe","abce","bcdeab"};

        String[] result2 = solution(goods2);
        for(String str : result2) System.out.println(str);
    }

    private static String[] solution(String[] goods) {
        List<String> answerList = new ArrayList<>();
        for(int i = 0; i < goods.length; i++) {
            String good = goods[i];
            Set<String> searchKeywordSet = new HashSet<>();
            int len = 1;
            while(searchKeywordSet.size() == 0 && len <= good.length()){
                int lt = 0;
                int rt = len;
                while(rt <= good.length()) {
                    String searchKeyword = good.substring(lt, rt);
                    if(isOnlySearchKeyword(i, goods, searchKeyword)) {
                        searchKeywordSet.add(searchKeyword);
                    }
                    lt++;
                    rt++;
                }
                len++;
            }
            if(searchKeywordSet.size() == 0) answerList.add("None");
            else {
                answerList.add(searchKeywordSet.stream()
                        .sorted()
                        .collect(Collectors.joining(" ")));
            }
        }

        return answerList.toArray(String[]::new);
    }

    private static boolean isOnlySearchKeyword(int idx, String[] goods, String searchKeyword) {
        for(int i = 0; i < goods.length; i++) {
            String good = goods[i];
            if(idx != i && good.contains(searchKeyword)) {
                return false;
            }
        }
        return true;
    }
}

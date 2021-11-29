package com.algorithm.inflearn.chapter4;

import java.util.*;

public class Main4_1{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String s = sc.nextLine();
        System.out.print(solution(n, s));
    }

    public static String solution(int k, String s) {
        String answer = null;
        Map<String, Integer> voteMap = new HashMap<>();
        Integer maxCnt = Integer.MIN_VALUE;

        for(char c : s.toCharArray()) {
            String cStr = Character.toString(c);
            Integer cnt = voteMap.get(cStr);
            if(cnt == null) cnt = 0;
            cnt++;
            if(cnt > maxCnt) {
                maxCnt = cnt;
                answer = cStr;
            }
            voteMap.put(cStr, cnt);
        }

        return answer;
    }
}
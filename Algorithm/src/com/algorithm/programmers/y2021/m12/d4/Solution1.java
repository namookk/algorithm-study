package com.algorithm.programmers.y2021.m12.d4;

public class Solution1 {
    public static void main(String[] args) {
        String[] drum = {"######",">#*###","####*#","#<#>>#",">#*#*<","######"};
        System.out.println(solution(drum));
    }
    public static int solution(String[] drum) {
        int answer = 0;

        for(int i = 0; i < drum[0].length(); i++) {
            int idx = i;
            int star = 0;
            boolean fail = false;
            for(int j = 0; j < drum.length; j++) {
                char[] chars = drum[j].toCharArray();
                while(chars[idx] != '#' && chars[idx] != '*') {
                    if (chars[idx] == '>') idx += 1;
                    else if (chars[idx] == '<') idx -= 1;
                }
                if(chars[idx] == '*') {
                    if(star == 0) star++;
                    else {
                        fail = true;
                        break;
                    }
                }
            }
            if(!fail){
                answer++;
            }
        }

        return answer;
    }
}

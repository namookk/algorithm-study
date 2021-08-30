package com.algorithm.day3.solution2;

import java.util.List;

public class Solution {
    public static void main(String[] args) {
        String s = "one4seveneight";

        System.out.println(solution(s));
    }
    public static int solution(String s) {

        String answerStr = "";
        for(int i = 0 ; i < s.length(); i++){
            String str = Character.toString(s.charAt(i));
            if(Character.isDigit(s.charAt(i))) {
                answerStr += s.charAt(i);
            }else{
                if(str.equals("s") || str.equals("t") || str.equals("f")){
                    str += s.charAt(++i);
                }
                int[] rs = getNumber(str);
                answerStr += rs[0];
                i += rs[1];
            }
        }
        return Integer.parseInt(answerStr);
    }
    public static int[] getNumber(String s){
        int[] result = new int[2];
        if (s.equals("z")){ result[0] = 0; result[1] = 3;}
        else if(s.equals("o")){ result[0] = 1; result[1] = 2;}
        else if(s.equals("tw")){ result[0] = 2; result[1] = 1;}
        else if(s.equals("th")){ result[0] = 3; result[1] = 3;}
        else if(s.equals("fo")){ result[0] = 4; result[1] = 2;}
        else if(s.equals("fi")){ result[0] = 5; result[1] = 2;}
        else if(s.equals("si")){ result[0] = 6; result[1] = 1;}
        else if(s.equals("se")){ result[0] = 7; result[1] = 3;}
        else if(s.equals("e")){ result[0] = 8; result[1] = 4;}
        else if(s.equals("n")){ result[0] = 9; result[1] = 3;}
        return result;
    }
}

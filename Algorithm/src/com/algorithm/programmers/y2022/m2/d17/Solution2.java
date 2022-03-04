package com.algorithm.programmers.y2022.m2.d17;

public class Solution2 {

    public static void main(String[] args) {
        int[] result = solution(0, 2);
        for(int i : result) System.out.print(i + " ");
    }
    public static int[] solution(int day, int k) {
        int[] answer = new int[12];
        int[] months = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int first_sun = 1 + (6 - day);
        System.out.println(first_sun);
        for(int i = 0; i < 12; i++){
            while(first_sun <= months[i]){
                if(k == first_sun || k == first_sun - 1){
                    answer[i] = 1;
                }
                first_sun += 7;
            }
            System.out.println(first_sun);
            first_sun -= months[i];
        }
        return answer;
    }
}

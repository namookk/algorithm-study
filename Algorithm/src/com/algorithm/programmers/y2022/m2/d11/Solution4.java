package com.algorithm.programmers.y2022.m2.d11;

public class Solution4 {
    static int n,m,height,width;
    public static void main(String[] args) {
        String[] isAvailable = {"111110", "110110", "110110", "111110", "111110"};
        System.out.println(solution(isAvailable, 5, 6, 3, 4));
    }

    private static int solution(String[] isAvailable, int N, int M, int H, int W) {
        int answer = 0;
        n = N;
        m = M;
        height = H;
        width = W;
        int min = Math.min(width, height);
        for (int i = 0; i <= n - min; i++) {
            for (int j = 0; j <= m - min; j++) {
                if(isAvailable[i].charAt(j) == '1') {
                    if (isAvailType1(isAvailable, i, j)) answer++;
                    if (isAvailType2(isAvailable, i, j)) answer++;
                    if (isAvailType3(isAvailable, i, j)) answer++;
                    if (isAvailType4(isAvailable, i, j)) answer++;
                }
            }
        }


        return answer;
    }


    private static boolean isAvailType1(String[] isAvailable, int startI, int startJ){
        if(startJ > m - width || startI > n - height) return false;
        for (int j = startJ; j < startJ + width; j++) {
            if(isAvailable[startI].charAt(j) == '0') return false;
        }
        for (int i = startI; i < startI + height; i++) {
            if(isAvailable[i].charAt(startJ) == '0') return false;
            if(isAvailable[i].charAt(startJ + width - 1) == '0') return false;
        }
        return true;
    }
    private static boolean isAvailType2(String[] isAvailable, int startI, int startJ){
        if(startJ > m - height || startI > n - width) return false;
        for (int j = startJ; j < startJ + height; j++) {
            if(isAvailable[startI].charAt(j) == '0') return false;
            if(isAvailable[startI + width - 1].charAt(j) == '0') return false;
        }
        for (int i = startI; i < startI + width; i++) {
            if(isAvailable[i].charAt(startJ) == '0') return false;
        }
        return true;
    }
    private static boolean isAvailType3(String[] isAvailable, int startI, int startJ){
        if(startJ > m - width || startI > n - height) return false;
        for (int j = startJ; j < startJ + height; j++) {
            if(isAvailable[startI + height - 1].charAt(j) == '0') return false;
        }
        for (int i = startI; i < startI + width; i++) {
            if(isAvailable[i].charAt(startJ) == '0') return false;
            if(isAvailable[i].charAt(startJ + width - 1) == '0') return false;
        }
        return true;
    }
    private static boolean isAvailType4(String[] isAvailable, int startI, int startJ){
        if(startJ > m - height || startI > n - height) return false;
        for (int j = startJ; j < startJ + width; j++) {
            if(isAvailable[startI].charAt(j) == '0') return false;
            if(isAvailable[startI + width - 1].charAt(j) == '0') return false;
        }
        for (int i = startI; i < startI + height; i++) {
            if(isAvailable[i].charAt(startJ + height - 1) == '0') return false;
        }
        return true;
    }
}

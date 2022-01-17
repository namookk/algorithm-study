package com.algorithm.baekjoon.silver5;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution_1331 {
    static int[][] ch = new int[7][7];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] arr = new String[36];
        for(int i = 0; i < 36; i++){
            arr[i] = sc.nextLine();
        }
        System.out.println(solution(arr));
    }
    private static String solution(String[] arr){
        List<String> xpoint = Arrays.asList(new String[]{"Z","A","B","C","D","E","F"});
        String start = arr[0];
        String[] startSpl = start.split("");
        boolean flag = true;
        int startX = xpoint.indexOf(startSpl[0]);;
        int startY = Integer.parseInt(startSpl[1]);;
        int prevX = startX;
        int prevY = startY;
        ch[prevX][prevY] = 1;

        for(int i = 1; i < arr.length; i++){
            String s = arr[i];
            String[] spl = s.split("");
            int currX = xpoint.indexOf(spl[0]);
            int currY = Integer.parseInt(spl[1]);

            if(!isValid(prevX, prevY, currX, currY)){
                flag = false;
                break;
            }
            ch[currX][currY] = 1;
            prevX = currX;
            prevY = currY;
        }

        ch[startX][startY] = 0;
        if(flag && isValid(prevX, prevY, startX, startY)) return "Valid";
        else return "Invalid";
    }

    private static boolean isValid(int prevX, int prevY, int currX, int currY){
        if(ch[currX][currY] == 1 || prevX == currX || prevY == currY) return false;
        if(Math.abs(prevX - currX) == 1 && Math.abs(prevY - currY) == 2){
            return true;
        }
        if(Math.abs(prevX - currX) == 2 && Math.abs(prevY - currY) == 1){
            return true;
        }
        return false;
    }
}

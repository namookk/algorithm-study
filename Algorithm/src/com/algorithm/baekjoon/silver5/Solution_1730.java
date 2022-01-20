package com.algorithm.baekjoon.silver5;

import java.util.Scanner;

public class Solution_1730 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String command = sc.nextLine();

        solution(n, command);
    }

    private static void solution(int n, String command){
        int[][] arr = new int[n][n];
        //0 : . , 1 : - , 2 : | , 3 : +
        int x = 0;
        int y = 0;
        for(char c : command.toCharArray()){
            switch (c) {
                case 'D':
                    if(x < n - 1){
                        if(arr[x][y] == 0) arr[x][y] = 2;
                        else if(arr[x][y] == 1) arr[x][y] = 3;
                        x++;
                        if(arr[x][y] == 0) arr[x][y] = 2;
                        else if(arr[x][y] == 1) arr[x][y] = 3;
                    }
                    break;
                case 'U':
                    if(x > 0){
                        if(arr[x][y] == 0) arr[x][y] = 2;
                        else if(arr[x][y] == 1) arr[x][y] = 3;
                        x--;
                        if(arr[x][y] == 0) arr[x][y] = 2;
                        else if(arr[x][y] == 1) arr[x][y] = 3;
                    }
                    break;
                case 'R':
                    if(y < n - 1){
                        if(arr[x][y] == 0) arr[x][y] = 1;
                        else if(arr[x][y] == 2) arr[x][y] = 3;
                        y++;
                        if(arr[x][y] == 0) arr[x][y] = 1;
                        else if(arr[x][y] == 2) arr[x][y] = 3;
                    }
                    break;
                case 'L':
                    if(y > 0){
                        if(arr[x][y] == 0) arr[x][y] = 1;
                        else if(arr[x][y] == 2) arr[x][y] = 3;
                        y--;
                        if(arr[x][y] == 0) arr[x][y] = 1;
                        else if(arr[x][y] == 2) arr[x][y] = 3;
                    }
                    break;
                default :
                    break;
            }
        }

        for(int[] ar : arr){
            for(int num : ar){
                if(num == 0) System.out.print(".");
                else if(num == 1) System.out.print("-");
                else if(num == 2) System.out.print("|");
                else if(num == 3) System.out.print("+");
            }
            System.out.println();
        }
    }
}

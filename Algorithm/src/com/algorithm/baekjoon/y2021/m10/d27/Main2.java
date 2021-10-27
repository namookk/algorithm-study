package com.algorithm.baekjoon.y2021.m10.d27;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        solution(n);
    }

    public static void solution(int n) {
        int len = (2 * (n-2) + 1) + (n * 2);

        for(int i = 0; i < (n*2 - 1) ; i++){
            if(i == 0 || i == (n*2 - 2)) {
                for(int j = 0; j < n; j++){
                    System.out.print("*");
                }
                for(int j = 0; j < (2 * (n-2) + 1); j++){
                    System.out.print(" ");
                }
                for(int j = 0; j < n; j++){
                    System.out.print("*");
                }
            }else if(i <= n - 1) {
                for(int j = 0; j < i; j++){
                    System.out.print(" ");
                }
                if(i == n - 1){
                    for(int j = 0; j < n*2 - 1; j++){
                        if(j == 0 || j == (n - 1) ||j == (n * 2 - 2)){
                            System.out.print("*");
                        }else{
                            System.out.print(" ");
                        }
                    }
                }else{
                    for(int j = 0; j < n; j++){
                        if(j == 0 || j == (n-1)){
                            System.out.print("*");
                        }else{
                            System.out.print(" ");
                        }
                    }
                    int nn = 2 * Math.abs((n - 1) - i) - 1 ;
                    for(int j = 0; j < nn; j++){
                        System.out.print(" ");
                    }
                    for(int j = 0; j < n; j++){
                        if(j == 0 || j == (n-1)){
                            System.out.print("*");
                        }else{
                            System.out.print(" ");
                        }
                    }
                }
            }else if(i > n - 1) {
                for(int j = (i - n); j < (n-2) ; j++){
                    System.out.print(" ");
                }
                for(int j = 0; j < n; j++){
                    if(j == 0 || j == (n-1)){
                        System.out.print("*");
                    }else{
                        System.out.print(" ");
                    }
                }
                int nn = 2 * Math.abs((n - 1) - i) - 1 ;
                for(int j = 0; j < nn; j++){
                    System.out.print(" ");
                }
                for(int j = 0; j < n; j++){
                    if(j == 0 || j == (n-1)){
                        System.out.print("*");
                    }else{
                        System.out.print(" ");
                    }
                }
                for(int j = (i - n); j < (n-1) ; j++){
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}

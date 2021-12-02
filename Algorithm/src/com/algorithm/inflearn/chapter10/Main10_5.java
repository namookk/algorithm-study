package com.algorithm.inflearn.chapter10;

import java.util.Arrays;
import java.util.Scanner;

public class Main10_5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] coins = new int[n];
        for(int i = 0; i < n; i++) coins[i] = sc.nextInt();
        int money = sc.nextInt();
        System.out.println(solution(coins, money));
    }
    public static int solution(int[] coins, int money) {
        int[] dy = new int[money+1];
        Arrays.sort(coins);
        Arrays.fill(dy, Integer.MAX_VALUE);
        for(int i = 0; i < coins[0]; i++){
            dy[i] = 0;
        }
        for(int i = 0; i < coins.length; i++) {
            for(int j = coins[i]; j < dy.length;j++){
                int kind = dy[j - coins[i]] + 1;
                if(dy[j] > kind) dy[j] = kind;
            }
        }

        return dy[money];
    }
}

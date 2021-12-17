package com.algorithm.inflearn2.chapter8;

public class Main8_3 {
    public static void main(String[] args) {
        int[] coins = {1,2,5};
        int amount = 11;

        System.out.println(solve(coins, amount));
    }

    public static int solve(int[] coins, int amount) {
        int[] dy = new int[amount+1];
        for(int i = 0; i < dy.length; i++) dy[i] = i;

        for(int i = 1; i < coins.length; i++) {
            for(int j = coins[i]; j <= amount; j++) {
                dy[j] = dy[j - coins[i]] + 1;
            }
        }
        return dy[amount];
    }
}

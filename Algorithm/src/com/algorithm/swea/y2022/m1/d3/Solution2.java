package com.algorithm.swea.y2022.m1.d3;

import java.util.Scanner;

public class Solution2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i = 1; i <= T; i++){
            //1. ds
            int benefit = 0;
            int n = sc.nextInt();
            int[] prices = new int[n];
            for(int j = 0; j < n; j++){
                prices[j] = sc.nextInt();
            }

            //2
            //1 3 7 11 10
            int lt = 0;
            int rt = 1;
            while(rt < prices.length){
                if(rt == prices.length - 1 || prices[rt] > prices[rt+1]){
                    for(int k = lt; k < rt; k++){
                        if(prices[rt] > prices[lt]) benefit += prices[rt] - prices[k];
                    }
                    lt = rt + 1;
                    rt = lt + 1;
                }else{
                    rt++;
                }
            }

            System.out.println("#"+i+" "+benefit);
        }
    }
}

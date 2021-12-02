package com.algorithm.inflearn.chapter10;

import java.util.*;

public class Main10_6 {
    static int[] s;
    static int[] t;
    static Integer[][] dy;
    static int limit;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        s = new int[n];
        t = new int[n];
        limit = sc.nextInt();
        dy = new Integer[n][limit + 1];
        for(int i = 0; i < n; i++) {
            s[i] = sc.nextInt();
            t[i] = sc.nextInt();
        }

        System.out.println(knapsack(n - 1, limit));
    }

    public static int knapsack(int i, int k) {
        // i가 0미만, 즉 범위 밖이 된다면
        if (i < 0)
            return 0;

        // 탐색하지 않은 위치라면?
        if (dy[i][k] == null) {

            // 현재 물건(i)을 추가로 못담는 경우 (이전 i값 탐색)
            if(t[i] > k) {
                dy[i][k] = knapsack(i - 1, k);
            }
            // 현재 물건(i)을 담을 수 있는 경우
            else {
                // 이전 i값과 이전 i값에 대한 k-W[i]의 값 + 현재 가치(V[i])중 큰 값을 저장
                dy[i][k] = Math.max(knapsack(i - 1, k), knapsack(i - 1, k - t[i]) + s[i]);
            }
        }
        return dy[i][k];
    }
}

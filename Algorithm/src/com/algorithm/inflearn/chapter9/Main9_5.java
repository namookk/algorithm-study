package com.algorithm.inflearn.chapter9;

import java.util.*;

public class Main9_5 {
    static int[] unf;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        unf = new int[n+1];
        for(int i = 1; i <= n; i++) unf[i] = i;
        for(int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            Union(a, b);
        }
        int a = sc.nextInt();
        int b = sc.nextInt();

        int fa = Find(a);
        int fb = Find(b);
        System.out.println(fa == fb ? "YES" : "NO");
    }

    public static void Union(int a, int b){
        int fa = Find(a);
        int fb = Find(b);
        if(fa != fb) unf[fa] = fb;
    }

    public static int Find(int v) {
        if(v == unf[v]) return v;
        else return unf[v] = Find(unf[v]);
    }
}
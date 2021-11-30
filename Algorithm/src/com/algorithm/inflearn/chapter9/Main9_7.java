package com.algorithm.inflearn.chapter9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main9_7 {
    static int[] unf;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();
        unf = new int[v+1];
        for(int i = 1; i <= v; i++) unf[i] = i;

        List<WonderRandEdge> edgeList = new ArrayList<>();
        for(int i = 0; i < e; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            int cost = sc.nextInt();
            edgeList.add(new WonderRandEdge(v1, v2, cost));
        }

        System.out.println(solution(edgeList));
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

    public static int solution(List<WonderRandEdge> edgeList) {
        int answer = 0;
        Collections.sort(edgeList);
        for(WonderRandEdge edge : edgeList) {
            int fv1 = Find(edge.vex1);
            int fv2 = Find(edge.vex2);
            if(fv1 == fv2) continue;

            Union(edge.vex1, edge.vex2);
            answer += edge.cost;
        }
        return answer;
    }
}

class WonderRandEdge implements Comparable<WonderRandEdge>{
    int vex1;
    int vex2;
    int cost;

    WonderRandEdge(int _vex1, int _vex2, int _cost) {
        vex1 = _vex1;
        vex2 = _vex2;
        cost = _cost;
    }

    @Override
    public int compareTo(WonderRandEdge e) {
        return this.cost - e.cost;
    }
}

package com.algorithm.inflearn.chapter9;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main9_7_2 {
    static ArrayList<ArrayList<WonderLandEdge2>> graph = new ArrayList<ArrayList<WonderLandEdge2>>();
    static int[] ch;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();
        ch = new int[v+1];
        for(int i = 0; i <= v; i++){
            graph.add(new ArrayList<WonderLandEdge2>());
        }

        for(int i = 0; i < e; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            int cost = sc.nextInt();

            graph.get(v1).add(new WonderLandEdge2(v2, cost));
            graph.get(v2).add(new WonderLandEdge2(v1, cost));
        }

        System.out.println(solution());
    }

    public static int solution() {
        int answer = 0;
        PriorityQueue<WonderLandEdge2> pq = new PriorityQueue<>();
        pq.offer(new WonderLandEdge2(1,0));

        while(!pq.isEmpty()) {
            WonderLandEdge2 edge = pq.poll();
            if(ch[edge.vex] == 1) continue;

            ch[edge.vex] = 1;
            answer += edge.cost;
            for(WonderLandEdge2 item : graph.get(edge.vex)) {
                if(ch[item.vex] == 0) {
                    pq.offer(new WonderLandEdge2(item.vex, item.cost));
                }
            }
        }

        return answer;
    }
}

class WonderLandEdge2 implements Comparable<WonderLandEdge2>{
    int vex;
    int cost;
    WonderLandEdge2(int _vex, int _cost) {
        vex = _vex;
        cost = _cost;
    }

    @Override
    public int compareTo(WonderLandEdge2 e) {
        return this.cost - e.cost;
    }
}

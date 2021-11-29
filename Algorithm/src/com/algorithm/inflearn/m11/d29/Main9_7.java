package com.algorithm.inflearn.m11.d29;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main9_7 {
    static ArrayList<ArrayList<Edge>> graph;
    static int[] dist;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();
        graph = new ArrayList<ArrayList<Edge>>();
        dist = new int[v+1];
        for(int i = 1; i <= v; i++) dist[i] = Integer.MAX_VALUE;
        for(int i = 0; i <= v; i++) graph.add(new ArrayList<Edge>());
        for(int i = 0; i < e; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            int cost = sc.nextInt();
            graph.get(v1).add(new Edge(v2, cost));
            graph.get(v2).add(new Edge(v1, cost));
        }

        System.out.println(solution(1));
    }

    public static int solution(int v) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(v, 0));
        dist[v] = 0;
        int answer = 0;
        while(!pq.isEmpty()) {
            Edge edge = pq.poll();
            int nowVex = edge.vex;
            int nowCost = edge.cost;
            if(nowCost > dist[nowVex])continue;
            for(int i = 0; i < graph.get(nowVex).size(); i++) {
                Edge e = graph.get(nowVex).get(i);
                if(dist[e.vex] > nowCost + e.cost){
                    dist[e.vex] = nowCost + e.cost;
                    pq.offer(new Edge(e.vex, nowCost+e.cost));
                }
            }
        }
        return answer;
    }
}

class Edge implements Comparable<Edge>{
    int vex;
    int cost;

    Edge(int _vex, int _cost) {
        vex = _vex;
        cost = _cost;
    }

    @Override
    public int compareTo(Edge e) {
        return this.cost - e.cost;
    }
}

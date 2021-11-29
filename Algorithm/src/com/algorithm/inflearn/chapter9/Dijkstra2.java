package com.algorithm.inflearn.chapter9;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class Edge implements Comparable<Edge> {
    public int vex;
    public int cost;

    Edge(int vex, int cost) {
        this.vex = vex;
        this.cost = cost;
    }
    @Override
    public int compareTo(Edge ob) {
        return this.cost - ob.cost;
    }
}

public class Dijkstra2 {
    static int n = 6;
    static int m = 9;
    static ArrayList<ArrayList<Edge>> graph;
    static int[] dis;
    public static void main(String[] args) {
        graph = new ArrayList<ArrayList<Edge>>();
        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Edge>());
        }
        dis = new int[n+1];
        Arrays.fill(dis, Integer.MAX_VALUE);

        graph.get(1).add(new Edge(2, 12));
        graph.get(1).add(new Edge(3, 4));
        graph.get(2).add(new Edge(1, 2));
        graph.get(2).add(new Edge(3, 5));
        graph.get(2).add(new Edge(5, 5));
        graph.get(3).add(new Edge(4, 5));
        graph.get(4).add(new Edge(2, 2));
        graph.get(4).add(new Edge(5, 5));
        graph.get(6).add(new Edge(4, 5));

        solution(1);
        for(int i = 1; i <= n; i++) {
            if(dis[i] != Integer.MAX_VALUE) System.out.println(i + " : " + dis[i]);
            else System.out.println(i + " : impossible");
        }
    }

    public static void solution(int v) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(v, 0));
        dis[v] = 0;
        while(!pq.isEmpty()) {
            Edge edge = pq.poll();
            int now = edge.vex;
            int nowCost = edge.cost;
            if(nowCost > dis[now]) continue;
            for(Edge ob : graph.get(now)) {
                if(dis[ob.vex] > nowCost + ob.cost){
                    dis[ob.vex] = nowCost + ob.cost;
                    pq.offer(new Edge(ob.vex, nowCost+ob.cost));
                }
            }
        }
    }
}

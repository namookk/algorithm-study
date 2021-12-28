package com.algorithm.programmers.y2021.m12.d29;


//https://programmers.co.kr/learn/courses/30/lessons/12978
//정확성  테스트
//    테스트 1 〉	통과 (0.75ms, 73MB)
//    테스트 2 〉	통과 (0.80ms, 73.4MB)
//    테스트 3 〉	통과 (0.84ms, 78.2MB)
//    테스트 4 〉	통과 (0.80ms, 79.8MB)
//    테스트 5 〉	통과 (0.66ms, 72.6MB)
//    테스트 6 〉	통과 (0.72ms, 75.7MB)
//    테스트 7 〉	통과 (0.75ms, 72.8MB)
//    테스트 8 〉	통과 (0.56ms, 78MB)
//    테스트 9 〉	통과 (0.65ms, 77.1MB)
//    테스트 10 〉	통과 (0.66ms, 76.1MB)
//    테스트 11 〉	통과 (0.63ms, 76.1MB)
//    테스트 12 〉	통과 (1.10ms, 72.7MB)
//    테스트 13 〉	통과 (0.92ms, 77.1MB)
//    테스트 14 〉	통과 (2.62ms, 79.6MB)
//    테스트 15 〉	통과 (2.61ms, 72.1MB)
//    테스트 16 〉	통과 (0.80ms, 78.5MB)
//    테스트 17 〉	통과 (0.87ms, 80.1MB)
//    테스트 18 〉	통과 (1.14ms, 77.6MB)
//    테스트 19 〉	통과 (2.90ms, 72.2MB)
//    테스트 20 〉	통과 (1.60ms, 83.6MB)
//    테스트 21 〉	통과 (2.84ms, 78.6MB)
//    테스트 22 〉	통과 (1.39ms, 76.1MB)
//    테스트 23 〉	통과 (2.02ms, 79.5MB)
//    테스트 24 〉	통과 (1.82ms, 84.7MB)
//    테스트 25 〉	통과 (2.93ms, 73.2MB)
//    테스트 26 〉	통과 (2.32ms, 75.7MB)
//    테스트 27 〉	통과 (2.27ms, 79.4MB)
//    테스트 28 〉	통과 (2.29ms, 83.1MB)
//    테스트 29 〉	통과 (2.35ms, 79.2MB)
//    테스트 30 〉	통과 (4.23ms, 77.8MB)
//    테스트 31 〉	통과 (0.72ms, 78.7MB)
//    테스트 32 〉	통과 (0.95ms, 80.2MB)


import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution2 {
    static ArrayList<ArrayList<Edge>> graph;
    static int[] dis;
    public static void main(String[] args) {
        int n = 5;
        int[][] road = {{1,2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}};
        int k = 3;

        System.out.println(solution(n, road, k));
    }

    public static int solution(int n, int[][] road, int k){
        int answer = 0;
        graph = new ArrayList<ArrayList<Edge>>();
        dis = new int[n+1];
        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Edge>());
        }
        Arrays.fill(dis, Integer.MAX_VALUE);

        for(int[] r : road){
            graph.get(r[0]).add(new Edge(r[1], r[2]));
            graph.get(r[1]).add(new Edge(r[0], r[2]));
        }
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(1, 0));
        dis[1] = 0;

        while(!pq.isEmpty()) {
            Edge edge = pq.poll();
            int now = edge.edge;
            int nowDist = edge.dist;
            if(nowDist > dis[now]) continue;
            for(Edge ob : graph.get(now)) {
                if(dis[ob.edge] > nowDist + ob.dist) {
                    dis[ob.edge] = nowDist + ob.dist;
                    pq.offer(new Edge(ob.edge, nowDist + ob.dist));
                }
            }
        }
        for(int i = 1; i <= n; i++){
            if(dis[i] <= k) answer++;
        }
        return answer;
    }
}

class Edge implements Comparable<Edge>{
    int edge;
    int dist;

    Edge(int edge, int dist){
        this.edge = edge;
        this.dist = dist;
    }
    @Override
    public int compareTo(Edge o) {
        return this.dist - o.dist;
    }
}

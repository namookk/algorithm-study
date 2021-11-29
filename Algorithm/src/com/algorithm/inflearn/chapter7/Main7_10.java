package com.algorithm.inflearn.chapter7;

import java.util.Scanner;

public class Main7_10 {
    static int[][] graph;
    static int[] ch;
    static int n, answer = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] nodes = new int[M][2];
        for(int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            nodes[i][0] = a;
            nodes[i][1] = b;
        }
        System.out.println(solution(N, nodes));
    }

    public static int solution(int N, int[][] nodes) {
        graph = new int[N+1][N+1];
        ch = new int[N+1];
        n = N;
        for(int i = 0; i < nodes.length;i++) {
            graph[nodes[i][0]][nodes[i][1]] = 1;
        }
        ch[1] = 1;
        DFS(1);
        return answer;
    }

    public static void DFS( int curr){
        if( curr == n) answer++;
        else {
            for (int i = 1; i <= n; i++) {
                if (graph[curr][i] == 1 && ch[i] == 0) {
                    ch[i] = 1;
                    DFS(i);
                    ch[i] = 0;
                }
            }
        }
    }
}
